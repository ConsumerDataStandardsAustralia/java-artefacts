/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 */
package au.org.consumerdatastandards.client.model;

import java.util.Objects;

public class PaginatedResponse {

  protected LinksPaginated links;

  protected TxMetaPaginated meta;

  /**
   * The links attribute contains a Links object with links to
   * related API end points. This will include links to support
   * pagination.
   * @return links
   */
  public LinksPaginated getLinks() {
    return links;
  }

  public void setLinks(LinksPaginated links) {
    this.links = links;
  }

  /**
   * The meta object is used to provide additional information
   * such as second factor authorisation data, traffic
   * management, pagination counts or other purposes that are
   * complementary to the workings of the API.
   * @return meta
   */
  public TxMetaPaginated getMeta() {
    return meta;
  }

  public void setMeta(TxMetaPaginated meta) {
    this.meta = meta;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    PaginatedResponse inputModel = (PaginatedResponse) o;
    if (!(links.equals(inputModel.getLinks()))) {
      return false;
    }
    return meta.equals(inputModel.getMeta());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        links,
        meta);
  }

  @Override
  public String toString() {
    return "class PaginatedResponse {\n" +
        "    links: " + toIndentedString(links) + "\n" +
        "    meta: " + toIndentedString(meta) + "\n" +
        "}";
  }

  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}