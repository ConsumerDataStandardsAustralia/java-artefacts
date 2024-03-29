/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 */
package au.org.consumerdatastandards.client.model;

import java.util.Objects;

public class CommonEmailAddress {

    public enum Purpose {
        WORK,
        HOME,
        OTHER,
        UNSPECIFIED
    }

    private Boolean isPreferred;

    private Purpose purpose;

    private String address;

    /**
     * May be true for one and only one email record in the collection. Denotes the default email address
     * @return isPreferred
     */
    public Boolean getIsPreferred() {
        return isPreferred;
    }

    public void setIsPreferred(Boolean isPreferred) {
        this.isPreferred = isPreferred;
    }

    /**
     * The purpose for the email, as specified by the customer (Enumeration)
     * @return purpose
     */
    public Purpose getPurpose() {
        return purpose;
    }

    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }

    /**
     * A correctly formatted email address, as defined by the addr_spec format in [RFC 5322](https://www.ietf.org/rfc/rfc5322.txt)
     * @return address
     */
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CommonEmailAddress commonEmailAddress = (CommonEmailAddress) o;
        return Objects.equals(this.isPreferred, commonEmailAddress.isPreferred) &&
            Objects.equals(this.purpose, commonEmailAddress.purpose) &&
            Objects.equals(this.address, commonEmailAddress.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            isPreferred,
            purpose,
            address);
    }

    @Override
    public String toString() {
        return "class CommonEmailAddress {\n" +
            "   isPreferred: " + toIndentedString(isPreferred) + "\n" + 
            "   purpose: " + toIndentedString(purpose) + "\n" + 
            "   address: " + toIndentedString(address) + "\n" + 
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
