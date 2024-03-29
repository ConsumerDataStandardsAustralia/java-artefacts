/*
 * Consumer Data Standards
 * Sample Data Holder to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 * Do not edit the class manually.
 */
package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

@ApiModel
public class MetaPaginated  {

    /**
     * The total number of pages in the full set. See [pagination](#pagination).
     */
    protected Integer totalPages;

    /**
     * The total number of records in the full set. See [pagination](#pagination).
     */
    protected Integer totalRecords;

    public MetaPaginated totalPages(Integer totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    @ApiModelProperty(required = true, value = "The total number of pages in the full set. See [pagination](#pagination).")
    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
    public MetaPaginated totalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
        return this;
    }

    @ApiModelProperty(required = true, value = "The total number of records in the full set. See [pagination](#pagination).")
    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
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
        return Objects.equals(this.totalPages, metaPaginated.totalPages) &&
            Objects.equals(this.totalRecords, metaPaginated.totalRecords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            totalPages,
            totalRecords);
    }

    @Override
    public String toString() {
        return "class MetaPaginated {\n" +
            "   totalPages: " + toIndentedString(totalPages) + "\n" + 
            "   totalRecords: " + toIndentedString(totalRecords) + "\n" + 
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

