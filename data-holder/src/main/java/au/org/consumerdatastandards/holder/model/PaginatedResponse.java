/*
 * Consumer Data Standards
 * Sample Data Holder to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
  * Do not edit the class manually.
 */
package au.org.consumerdatastandards.holder.model;

import java.util.Objects;

public class PaginatedResponse {

    /**
     * The links attribute contains a Links object with links to
     * related API end points. This will include links to support
     * pagination.
     */
    private LinksPaginated links;

    /**
     * The meta object is used to provide additional information
     * such as second factor authorisation data, traffic
     * management, pagination counts or other purposes that are
     * complementary to the workings of the API.
     */
    private MetaPaginated meta;

    public LinksPaginated getLinks() {
        return links;
    }

    public void setLinks(LinksPaginated links) {
        this.links = links;
    }

    public MetaPaginated getMeta() {
        return meta;
    }

    public void setMeta(MetaPaginated meta) {
        this.meta = meta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaginatedResponse that = (PaginatedResponse) o;
        return Objects.equals(links, that.links) &&
            Objects.equals(meta, that.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            links,
            meta);
    }

    @Override
    public String toString() {
        return "PaginatedResponse{" +
            "links=" + links +
            ", meta=" + meta +
            '}';
    }
}
