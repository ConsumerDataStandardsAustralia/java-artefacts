/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 */
package au.org.consumerdatastandards.client.model;

import java.util.Objects;

public class MetaPaginated {

    private Integer totalRecords;

    private Integer totalPages;

    /**
     * The total number of records in the full set. See [pagination](#pagination).
     * @return totalRecords
     */
    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    /**
     * The total number of pages in the full set. See [pagination](#pagination).
     * @return totalPages
     */
    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MetaPaginated metaPaginated = (MetaPaginated) o;
        return Objects.equals(this.totalRecords, metaPaginated.totalRecords) &&
            Objects.equals(this.totalPages, metaPaginated.totalPages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            totalRecords,
            totalPages);
    }

    @Override
    public String toString() {
        return "class MetaPaginated {\n" +
            "   totalRecords: " + toIndentedString(totalRecords) + "\n" +
            "   totalPages: " + toIndentedString(totalPages) + "\n" +
            "}";
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     * @param o Object
     * @return Indented string representation of <code>o</code>
     */
    protected String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
