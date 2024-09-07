package askomdch.com.workobject;

public class BillingDetails {
    private String billingFirstName="";
    private String billingLastName="";
    private String billingCountry="";
    private String billingStreet_address="";
    private String billingCity="";
    private String billingState="";
    private String billingZip_Code="";
    private String billingEmail_address="";

    public BillingDetails(String billingFirstName, String billingLastName, String billingCountry,
                          String billingStreet_address, String billingCity, String billingState,
                          String billingZip_Code, String billingEmail_address) {
        this.billingFirstName = billingFirstName;
        this.billingLastName = billingLastName;
        this.billingCountry = billingCountry;
        this.billingStreet_address = billingStreet_address;
        this.billingCity = billingCity;
        this.billingState = billingState;
        this.billingZip_Code = billingZip_Code;
        this.billingEmail_address = billingEmail_address;
    }

    public String getBillingFirstName() {
        return billingFirstName;
    }

    public void setBillingFirstName(String billingFirstName) {
        this.billingFirstName = billingFirstName;
    }

    public String getBillingLastName() {
        return billingLastName;
    }

    public void setBillingLastName(String billingLastName) {
        this.billingLastName = billingLastName;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    public String getBillingStreet_address() {
        return billingStreet_address;
    }

    public void setBillingStreet_address(String billingStreet_address) {
        this.billingStreet_address = billingStreet_address;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public String getBillingZip_Code() {
        return billingZip_Code;
    }

    public void setBillingZip_Code(String billingZip_Code) {
        this.billingZip_Code = billingZip_Code;
    }

    public String getBillingEmail_address() {
        return billingEmail_address;
    }

    public void setBillingEmail_address(String billingEmail_address) {
        this.billingEmail_address = billingEmail_address;
    }
}
