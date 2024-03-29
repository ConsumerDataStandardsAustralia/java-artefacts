/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 */
package au.org.consumerdatastandards.client.model;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

public class CommonPerson {

    public enum OccupationCodeVersion {
        ANZSCO_1220_0_2013_V1_3("ANZSCO_1220.0_2013_V1.3"),
        ANZSCO_1220_0_2013_V1_2("ANZSCO_1220.0_2013_V1.2"),
        ANZSCO_1220_0_2006_V1_1("ANZSCO_1220.0_2006_V1.1"),
        ANZSCO_1220_0_2006_V1_0("ANZSCO_1220.0_2006_V1.0");

        private final String value;

        OccupationCodeVersion(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    private OffsetDateTime lastUpdateTime;

    private String firstName;

    private String lastName;

    private List<String> middleNames;

    private String prefix;

    private String suffix;

    private String occupationCode;

    private OccupationCodeVersion occupationCodeVersion;

    /**
     * The date and time that this record was last updated by the customer.  If no update has occurred then this date should reflect the initial creation date for the data
     * @return lastUpdateTime
     */
    public OffsetDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(OffsetDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * For people with single names this field need not be present.  The single name should be in the lastName field
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * For people with single names the single name should be in this field
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Field is mandatory but array may be empty
     * @return middleNames
     */
    public List<String> getMiddleNames() {
        return middleNames;
    }

    public void setMiddleNames(List<String> middleNames) {
        this.middleNames = middleNames;
    }

    /**
     * Also known as title or salutation.  The prefix to the name (e.g. Mr, Mrs, Ms, Miss, Sir, etc)
     * @return prefix
     */
    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * Used for a trailing suffix to the name (e.g. Jr)
     * @return suffix
     */
    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    /**
     * Value is a valid <a href="http://www.abs.gov.au/ANZSCO">ANZCO v1.2</a> Standard Occupation classification code.
     * If the occupation code held by the data holder is not one of the supported
     * <a href="http://www.abs.gov.au/ANZSCO">ANZCO</a> versions, then it must not be supplied.
     * @return occupationCode
     */
    public String getOccupationCode() {
        return occupationCode;
    }

    public void setOccupationCode(String occupationCode) {
        this.occupationCode = occupationCode;
    }

    /**
     * The applicable <a href="http://www.abs.gov.au/ANZSCO">ANZCO</a> release version of the occupation code provided.
     * Mandatory if an occupationCode is supplied.
     * If occupationCode is supplied but occupationCodeVersion is absent, default is ANZSCO_1220.0_2013_V1.2
     * @return occupationCodeVersion
     */
    public OccupationCodeVersion getOccupationCodeVersion() {
        return occupationCodeVersion;
    }

    public void setOccupationCodeVersion(OccupationCodeVersion occupationCodeVersion) {
        this.occupationCodeVersion = occupationCodeVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CommonPerson commonPerson = (CommonPerson) o;
        return Objects.equals(this.lastUpdateTime, commonPerson.lastUpdateTime) &&
            Objects.equals(this.firstName, commonPerson.firstName) &&
            Objects.equals(this.lastName, commonPerson.lastName) &&
            Objects.equals(this.middleNames, commonPerson.middleNames) &&
            Objects.equals(this.prefix, commonPerson.prefix) &&
            Objects.equals(this.suffix, commonPerson.suffix) &&
            Objects.equals(this.occupationCode, commonPerson.occupationCode) &&
            Objects.equals(this.occupationCodeVersion, commonPerson.occupationCodeVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            lastUpdateTime,
            firstName,
            lastName,
            middleNames,
            prefix,
            suffix,
            occupationCode,
            occupationCodeVersion);
    }

    @Override
    public String toString() {
        return "class CommonPerson {\n" +
            "   lastUpdateTime: " + toIndentedString(lastUpdateTime) + "\n" + 
            "   firstName: " + toIndentedString(firstName) + "\n" + 
            "   lastName: " + toIndentedString(lastName) + "\n" + 
            "   middleNames: " + toIndentedString(middleNames) + "\n" + 
            "   prefix: " + toIndentedString(prefix) + "\n" + 
            "   suffix: " + toIndentedString(suffix) + "\n" + 
            "   occupationCode: " + toIndentedString(occupationCode) + "\n" + 
            "   occupationCodeVersion: " + toIndentedString(occupationCodeVersion) + "\n" +
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
