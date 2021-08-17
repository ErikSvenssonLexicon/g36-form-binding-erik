package se.lexicon.g36formbindingerik.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.lexicon.g36formbindingerik.model.dto.CustomerDTO;

@Controller
public class CustomerController {

    @GetMapping("/customer/create")
    public String getForm(Model model){
        CustomerDTO customerDTO = new CustomerDTO();
        model.addAttribute("form", customerDTO);
        return "customer-form";
    }

    /*
        * Create the form and do form binding
        * in controller do method to handle form data @PostMapping and activate validation
        *   if errors -> return form view
        *   else add to empty array list and then redirect to method below
        * create a method find by id in controller and redirect on success to that method
     */

}
