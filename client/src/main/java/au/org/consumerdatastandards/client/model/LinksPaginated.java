/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 */
package au.org.consumerdatastandards.client.model;

import java.util.Objects;

public class LinksPaginated extends Links {

    private String first;

    private String prev;

    private String next;

    private String last;

    /**
     * URI to the first page of this set. Mandatory if this response is not the first page
     * @return first
     */
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    /**
     * URI to the previous page of this set. Mandatory if this response is not the first page
     * @return prev
     */
    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    /**
     * URI to the next page of this set. Mandatory if this response is not the last page
     * @return next
     */
    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    /**
     * URI to the last page of this set. Mandatory if this response is not the last page
     * @return last
     */
    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LinksPaginated linksPaginated = (LinksPaginated) o;
        return Objects.equals(this.getSelf(), linksPaginated.getSelf()) &&
            Objects.equals(this.first, linksPaginated.first) &&
            Objects.equals(this.prev, linksPaginated.prev) &&
            Objects.equals(this.next, linksPaginated.next) &&
            Objects.equals(this.last, linksPaginated.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            getSelf(),
            first,
            prev,
            next,
            last);
    }

    @Override
    public String toString() {
        return "class LinksPaginated {\n" +
            "   self: " + toIndentedString(getSelf()) + "\n" +
            "   first: " + toIndentedString(first) + "\n" + 
            "   prev: " + toIndentedString(prev) + "\n" + 
            "   next: " + toIndentedString(next) + "\n" + 
            "   last: " + toIndentedString(last) + "\n" + 
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
