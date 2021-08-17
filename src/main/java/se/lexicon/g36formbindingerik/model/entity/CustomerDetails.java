package se.lexicon.g36formbindingerik.model.entity;

public class CustomerDetails {

    public static final String UNSPECIFIED = "UNSPECIFIED";
    private String detailsId;
    private String street;
    private String zipCode;
    private String city;
    private String homePhone;
    private String cellPhone;

    public CustomerDetails(String detailsId, String street, String zipCode, String city, String homePhone, String cellPhone) {
        this.detailsId = detailsId;
        setStreet(street);
        setZipCode(zipCode);
        setCity(city);
        setHomePhone(homePhone);
        setCellPhone(cellPhone);
    }

    public String getDetailsId() {
        return detailsId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        if(street == null || street.isEmpty()) street = UNSPECIFIED;
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        if(zipCode == null || zipCode.isEmpty()) zipCode = UNSPECIFIED;
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if(city == null || city.isEmpty()) city = UNSPECIFIED;
        this.city = city;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        if(homePhone == null || homePhone.isEmpty()) homePhone = UNSPECIFIED;
        this.homePhone = homePhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        if(cellPhone == null || cellPhone.isEmpty()) cellPhone = UNSPECIFIED;
        this.cellPhone = cellPhone;
    }
}
