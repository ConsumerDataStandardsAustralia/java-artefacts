/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 */
package au.org.consumerdatastandards.client.model;

import java.util.Objects;

public class Error {

    private String code;

    private String title;

    private String detail;

    private Object meta;

    /**
     * Must be one of the following: 0001 – Account not able to be found
     * @return code
     */
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Must be one of the following: Invalid account
     * @return title
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * ID of the account not found
     * @return detail
     */
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * Optional additional data for specific error types
     * @return meta
     */
    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Error responseErrorListErrors = (Error) o;
        return Objects.equals(this.code, responseErrorListErrors.code) &&
            Objects.equals(this.title, responseErrorListErrors.title) &&
            Objects.equals(this.detail, responseErrorListErrors.detail) &&
            Objects.equals(this.meta, responseErrorListErrors.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            code,
            title,
            detail,
            meta);
    }

    @Override
    public String toString() {
        return "class Error {\n" +
            "   code: " + toIndentedString(code) + "\n" + 
            "   title: " + toIndentedString(title) + "\n" + 
            "   detail: " + toIndentedString(detail) + "\n" + 
            "   meta: " + toIndentedString(meta) + "\n" + 
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
