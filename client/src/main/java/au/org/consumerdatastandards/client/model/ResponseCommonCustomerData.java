/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 */
package au.org.consumerdatastandards.client.model;

import java.util.Objects;

public class ResponseCommonCustomerData {

    public enum CustomerUType {
        person,
        organisation
    }

    private CustomerUType customerUType;

    private CommonPerson person;

    private CommonOrganisation organisation;

    /**
     * The type of customer object that is present
     * @return customerUType
     */
    public CustomerUType getCustomerUType() {
        return customerUType;
    }

    public void setCustomerUType(CustomerUType customerUType) {
        this.customerUType = customerUType;
    }

    /**
     * Get person
     * @return person
     */
    public CommonPerson getPerson() {
        return person;
    }

    public void setPerson(CommonPerson person) {
        this.person = person;
    }

    /**
     * Get organisation
     * @return organisation
     */
    public CommonOrganisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(CommonOrganisation organisation) {
        this.organisation = organisation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResponseCommonCustomerData responseCommonCustomerData = (ResponseCommonCustomerData) o;
        return Objects.equals(this.customerUType, responseCommonCustomerData.customerUType) &&
            Objects.equals(this.person, responseCommonCustomerData.person) &&
            Objects.equals(this.organisation, responseCommonCustomerData.organisation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            customerUType,
            person,
            organisation);
    }

    @Override
    public String toString() {
        return "class ResponseCommonCustomerData {\n" +
            "   customerUType: " + toIndentedString(customerUType) + "\n" + 
            "   person: " + toIndentedString(person) + "\n" + 
            "   organisation: " + toIndentedString(organisation) + "\n" + 
            "}";
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
