/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 */
package au.org.consumerdatastandards.client.model;

import java.util.Objects;

public class ResponseCommonCustomerDetailData {

    public enum CustomerUType {
        person,
        organisation
    }

    private CustomerUType customerUType;

    private CommonPersonDetail person;

    private CommonOrganisationDetail organisation;

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
    public CommonPersonDetail getPerson() {
        return person;
    }

    public void setPerson(CommonPersonDetail person) {
        this.person = person;
    }

    /**
     * Get organisation
     * @return organisation
     */
    public CommonOrganisationDetail getOrganisation() {
        return organisation;
    }

    public void setOrganisation(CommonOrganisationDetail organisation) {
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
        ResponseCommonCustomerDetailData responseCommonCustomerDetailData = (ResponseCommonCustomerDetailData) o;
        return Objects.equals(this.customerUType, responseCommonCustomerDetailData.customerUType) &&
            Objects.equals(this.person, responseCommonCustomerDetailData.person) &&
            Objects.equals(this.organisation, responseCommonCustomerDetailData.organisation);
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
        return "class ResponseCommonCustomerDetailData {\n" +
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
