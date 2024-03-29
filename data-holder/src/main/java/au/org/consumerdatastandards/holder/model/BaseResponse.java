/*
 * Consumer Data Standards
 * Sample Data Holder to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
  * Do not edit the class manually.
 */
package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Map;
import java.util.Objects;

public class BaseResponse {

    /**
     * The links attribute contains a Links object with links to
     * related API end points. This will include links to support
     * pagination.
     */
    private Links links;

    /**
     * The meta object is used to provide additional information
     * such as second factor authorisation data, traffic
     * management, pagination counts or other purposes that are
     * complementary to the workings of the API.
     */
    private Map<String, Object> meta;

    @ApiModelProperty(required = true)
    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    @ApiModelProperty
    public Map<String, Object> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, Object> meta) {
        this.meta = meta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseResponse that = (BaseResponse) o;
        return Objects.equals(links, that.links) &&
            Objects.equals(meta, that.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(links, meta);
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
            "links=" + links +
            ", meta=" + meta +
            '}';
    }
}
