package se.lexicon.g36formbindingerik.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import se.lexicon.g36formbindingerik.model.dto.CustomerDTO;
import se.lexicon.g36formbindingerik.model.entity.Customer;
import se.lexicon.g36formbindingerik.model.entity.CustomerDetails;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class CustomerController {

    private List<Customer> customerList = new ArrayList<>();

    @GetMapping("/customer/create")
    public String getForm(Model model){
        CustomerDTO customerDTO = new CustomerDTO();
        model.addAttribute("form", customerDTO);
        return "customer-form";
    }

    @PostMapping("/customer/create/process")
    public String handleForm(@Valid @ModelAttribute(name = "form") CustomerDTO form, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "customer-form";
        }

        CustomerDetails customerDetails = new CustomerDetails(
                UUID.randomUUID().toString(),
                form.getStreet(),
                form.getZipCode(),
                form.getCity(),
                form.getHomePhone(),
                form.getCellPhone()
        );
        Customer customer = new Customer(form.getEmail(), LocalDate.now(), customerDetails);

        if(!customerList.contains(customer)){
            customerList.add(customer);
        }

        return "redirect:/customer/"+customer.getCustomerId();
    }

    @GetMapping("/customer/{id}")
    public String findById(@PathVariable(name = "id") String id, Model model){
        Customer customer = customerList.stream()
                .filter(c -> c.getCustomerId().equals(id))
                .findFirst().orElseThrow();

        model.addAttribute("customer", customer);
        return "customer-view";
    }

}
