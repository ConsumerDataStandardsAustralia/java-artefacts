/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 */
package au.org.consumerdatastandards.client.model;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Objects;

public class CommonOrganisation {

    public enum OrganisationType {
        COMPANY,
        GOVERNMENT_ENTITY,
        PARTNERSHIP,
        SOLE_TRADER,
        TRUST,
        OTHER
    }

    public enum IndustryCodeVersion {
        ANZSIC_1292_0_2006_V2_0("ANZSIC_1292.0_2006_V2.0"),
        ANZSIC_1292_0_2006_V1_0("ANZSIC_1292.0_2006_V1.0");

        private final String value;

        IndustryCodeVersion(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    private OffsetDateTime lastUpdateTime;

    private String agentFirstName;

    private String agentLastName;

    private String agentRole;

    private String businessName;

    private String legalName;

    private String shortName;

    private String abn;

    private String acn;

    private Boolean isACNCRegistered;

    private String industryCode;

    private IndustryCodeVersion industryCodeVersion;

    private OrganisationType organisationType;

    private String registeredCountry;

    private LocalDate establishmentDate;

    /**
     * The date and time that this record was last updated by the customer. If no update has occurred then this date should reflect the initial creation date for the data
     * @return lastUpdateTime
     */
    public OffsetDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(OffsetDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * The first name of the individual providing access on behalf of the organisation. For people with single names this field need not be present.  The single name should be in the lastName field
     * @return agentFirstName
     */
    public String getAgentFirstName() {
        return agentFirstName;
    }

    public void setAgentFirstName(String agentFirstName) {
        this.agentFirstName = agentFirstName;
    }

    /**
     * The last name of the individual providing access on behalf of the organisation. For people with single names the single name should be in this field
     * @return agentLastName
     */
    public String getAgentLastName() {
        return agentLastName;
    }

    public void setAgentLastName(String agentLastName) {
        this.agentLastName = agentLastName;
    }

    /**
     * The role of the individual identified as the agent who is providing authorisation.  Expected to be used for display. Default to Unspecified if the role is not known
     * @return agentRole
     */
    public String getAgentRole() {
        return agentRole;
    }

    public void setAgentRole(String agentRole) {
        this.agentRole = agentRole;
    }

    /**
     * Name of the organisation
     * @return businessName
     */
    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    /**
     * Legal name, if different to the business name
     * @return legalName
     */
    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    /**
     * Short name used for communication, if different to the business name
     * @return shortName
     */
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * Australian Business Number for the organisation
     * @return abn
     */
    public String getAbn() {
        return abn;
    }

    public void setAbn(String abn) {
        this.abn = abn;
    }

    /**
     * Australian Company Number for the organisation. Required only if an ACN is applicable for the organisation type
     * @return acn
     */
    public String getAcn() {
        return acn;
    }

    public void setAcn(String acn) {
        this.acn = acn;
    }

    /**
     * True if registered with the ACNC.  False if not. Absent or null if not confirmed.
     * @return isACNCRegistered
     */
    public Boolean getIsACNCRegistered() {
        return isACNCRegistered;
    }

    public void setIsACNCRegistered(Boolean isACNCRegistered) {
        this.isACNCRegistered = isACNCRegistered;
    }

    /**
     * A valid <a href="http://www.abs.gov.au/anzsic">ANZSIC</a> code for the organisation.
     * If the industry code held by the data holder is not one of the supported
     * <a href="http://www.abs.gov.au/anzsic">ANZSIC</a> versions, then it must not be supplied.
     * @return industryCode
     */
    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    /**
     * The applicable <a href="http://www.abs.gov.au/ANZSIC">ANZSIC</a> release version of the industry code provided.
     * Should only be supplied if industryCode is also supplied. If industryCode is supplied but industryCodeVersion
     * is absent, default is ANZSIC_1292.0_2006_V2.0
     * @return industryCodeVersion
     */
    public IndustryCodeVersion getIndustryCodeVersion() {
        return industryCodeVersion;
    }

    public void setIndustryCodeVersion(IndustryCodeVersion industryCodeVersion) {
        this.industryCodeVersion = industryCodeVersion;
    }

    /**
     * Legal organisation type
     * @return organisationType
     */
    public OrganisationType getOrganisationType() {
        return organisationType;
    }

    public void setOrganisationType(OrganisationType organisationType) {
        this.organisationType = organisationType;
    }

    /**
     * Enumeration with values from [ISO 3166 Alpha-3](https://www.iso.org/iso-3166-country-codes.html) country codes.  Assumed to be AUS if absent
     * @return registeredCountry
     */
    public String getRegisteredCountry() {
        return registeredCountry;
    }

    public void setRegisteredCountry(String registeredCountry) {
        this.registeredCountry = registeredCountry;
    }

    /**
     * The date the organisation described was established
     * @return establishmentDate
     */
    public LocalDate getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(LocalDate establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CommonOrganisation commonOrganisation = (CommonOrganisation) o;
        return Objects.equals(this.lastUpdateTime, commonOrganisation.lastUpdateTime) &&
            Objects.equals(this.agentFirstName, commonOrganisation.agentFirstName) &&
            Objects.equals(this.agentLastName, commonOrganisation.agentLastName) &&
            Objects.equals(this.agentRole, commonOrganisation.agentRole) &&
            Objects.equals(this.businessName, commonOrganisation.businessName) &&
            Objects.equals(this.legalName, commonOrganisation.legalName) &&
            Objects.equals(this.shortName, commonOrganisation.shortName) &&
            Objects.equals(this.abn, commonOrganisation.abn) &&
            Objects.equals(this.acn, commonOrganisation.acn) &&
            Objects.equals(this.isACNCRegistered, commonOrganisation.isACNCRegistered) &&
            Objects.equals(this.industryCode, commonOrganisation.industryCode) &&
            Objects.equals(this.industryCodeVersion, commonOrganisation.industryCodeVersion) &&
            Objects.equals(this.organisationType, commonOrganisation.organisationType) &&
            Objects.equals(this.registeredCountry, commonOrganisation.registeredCountry) &&
            Objects.equals(this.establishmentDate, commonOrganisation.establishmentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            lastUpdateTime,
            agentFirstName,
            agentLastName,
            agentRole,
            businessName,
            legalName,
            shortName,
            abn,
            acn,
            isACNCRegistered,
            industryCode,
            industryCodeVersion,
            organisationType,
            registeredCountry,
            establishmentDate);
    }

    @Override
    public String toString() {
        return "class CommonOrganisation {\n" +
            "   lastUpdateTime: " + toIndentedString(lastUpdateTime) + "\n" + 
            "   agentFirstName: " + toIndentedString(agentFirstName) + "\n" + 
            "   agentLastName: " + toIndentedString(agentLastName) + "\n" + 
            "   agentRole: " + toIndentedString(agentRole) + "\n" + 
            "   businessName: " + toIndentedString(businessName) + "\n" + 
            "   legalName: " + toIndentedString(legalName) + "\n" + 
            "   shortName: " + toIndentedString(shortName) + "\n" + 
            "   abn: " + toIndentedString(abn) + "\n" + 
            "   acn: " + toIndentedString(acn) + "\n" + 
            "   isACNCRegistered: " + toIndentedString(isACNCRegistered) + "\n" + 
            "   industryCode: " + toIndentedString(industryCode) + "\n" + 
            "   industryCodeVersion: " + toIndentedString(industryCodeVersion) + "\n" +
            "   organisationType: " + toIndentedString(organisationType) + "\n" +
            "   registeredCountry: " + toIndentedString(registeredCountry) + "\n" + 
            "   establishmentDate: " + toIndentedString(establishmentDate) + "\n" + 
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
