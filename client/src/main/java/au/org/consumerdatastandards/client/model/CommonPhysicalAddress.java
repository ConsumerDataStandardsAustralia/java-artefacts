/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 */
package au.org.consumerdatastandards.client.model;

import java.util.Objects;

public class CommonPhysicalAddress {

    public enum AddressUType {
        SIMPLE,
        PAF
    }

    private AddressUType addressUType;

    private CommonSimpleAddress simple;

    private CommonPAFAddress paf;

    /**
     * The type of address object present
     * @return addressUType
     */
    public AddressUType getAddressUType() {
        return addressUType;
    }

    public void setAddressUType(AddressUType addressUType) {
        this.addressUType = addressUType;
    }

    /**
     * Get simple
     * @return simple
     */
    public CommonSimpleAddress getSimple() {
        return simple;
    }

    public void setSimple(CommonSimpleAddress simple) {
        this.simple = simple;
    }

    /**
     * Get paf
     * @return paf
     */
    public CommonPAFAddress getPaf() {
        return paf;
    }

    public void setPaf(CommonPAFAddress paf) {
        this.paf = paf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CommonPhysicalAddress commonPhysicalAddress = (CommonPhysicalAddress) o;
        return Objects.equals(this.addressUType, commonPhysicalAddress.addressUType) &&
            Objects.equals(this.simple, commonPhysicalAddress.simple) &&
            Objects.equals(this.paf, commonPhysicalAddress.paf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            addressUType,
            simple,
            paf);
    }

    @Override
    public String toString() {
        return "class CommonPhysicalAddress {\n" +
            "   addressUType: " + toIndentedString(addressUType) + "\n" + 
            "   simple: " + toIndentedString(simple) + "\n" + 
            "   paf: " + toIndentedString(paf) + "\n" + 
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
