/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 */
package au.org.consumerdatastandards.client.model;

import java.util.Objects;

public class CommonSimpleAddress {

    private String mailingName;

    private String addressLine1;

    private String addressLine2;

    private String addressLine3;

    private String postcode;

    private String city;

    private String state;

    private String country = "AUS";

    /**
     * Name of the individual or business formatted for inclusion in an address used for physical mail
     * @return mailingName
     */
    public String getMailingName() {
        return mailingName;
    }

    public void setMailingName(String mailingName) {
        this.mailingName = mailingName;
    }

    /**
     * First line of the standard address object
     * @return addressLine1
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    /**
     * Second line of the standard address object
     * @return addressLine2
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    /**
     * Third line of the standard address object
     * @return addressLine3
     */
    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    /**
     * Mandatory for Australian addresses
     * @return postcode
     */
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * Name of the city or locality
     * @return city
     */
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Free text if the country is not Australia. If country is Australia then must be one of the values defined by the [State Type Abbreviation](https://auspost.com.au/content/dam/auspost_corp/media/documents/australia-post-data-guide.pdf) in the PAF file format. NSW, QLD, VIC, NT, WA, SA, TAS, ACT, AAT
     * @return state
     */
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    /**
     * A valid [ISO 3166 Alpha-3](https://www.iso.org/iso-3166-country-codes.html) country code. Australia (AUS) is assumed if country is not present.
     * @return country
     */
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CommonSimpleAddress commonSimpleAddress = (CommonSimpleAddress) o;
        return Objects.equals(this.mailingName, commonSimpleAddress.mailingName) &&
            Objects.equals(this.addressLine1, commonSimpleAddress.addressLine1) &&
            Objects.equals(this.addressLine2, commonSimpleAddress.addressLine2) &&
            Objects.equals(this.addressLine3, commonSimpleAddress.addressLine3) &&
            Objects.equals(this.postcode, commonSimpleAddress.postcode) &&
            Objects.equals(this.city, commonSimpleAddress.city) &&
            Objects.equals(this.state, commonSimpleAddress.state) &&
            Objects.equals(this.country, commonSimpleAddress.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            mailingName,
            addressLine1,
            addressLine2,
            addressLine3,
            postcode,
            city,
            state,
            country);
    }

    @Override
    public String toString() {
        return "class CommonSimpleAddress {\n" +
            "   mailingName: " + toIndentedString(mailingName) + "\n" + 
            "   addressLine1: " + toIndentedString(addressLine1) + "\n" + 
            "   addressLine2: " + toIndentedString(addressLine2) + "\n" + 
            "   addressLine3: " + toIndentedString(addressLine3) + "\n" + 
            "   postcode: " + toIndentedString(postcode) + "\n" + 
            "   city: " + toIndentedString(city) + "\n" + 
            "   state: " + toIndentedString(state) + "\n" + 
            "   country: " + toIndentedString(country) + "\n" + 
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
