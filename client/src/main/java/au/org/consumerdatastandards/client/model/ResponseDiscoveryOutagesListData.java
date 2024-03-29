/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 */
package au.org.consumerdatastandards.client.model;

import java.util.List;
import java.util.Objects;

public class ResponseDiscoveryOutagesListData {

    private List<DiscoveryOutage> outages;

    /**
     * List of scheduled outages. Property is mandatory but may contain and empty list if no outages are scheduled
     * @return outages
     */
    public List<DiscoveryOutage> getOutages() {
        return outages;
    }

    public void setOutages(List<DiscoveryOutage> outages) {
        this.outages = outages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResponseDiscoveryOutagesListData responseDiscoveryOutagesListData = (ResponseDiscoveryOutagesListData) o;
        return Objects.equals(this.outages, responseDiscoveryOutagesListData.outages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            outages);
    }

    @Override
    public String toString() {
        return "class ResponseDiscoveryOutagesListData {\n" +
            "   outages: " + toIndentedString(outages) + "\n" + 
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
