/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 */
package au.org.consumerdatastandards.client.model;

import java.util.Objects;
/**
 * Australian address formatted according to the file format defined by the [PAF file format](https://auspost.com.au/content/dam/auspost_corp/media/documents/australia-post-data-guide.pdf)
 */
public class CommonPAFAddress {

    private String dpid;

    private Integer thoroughfareNumber1;

    private String thoroughfareNumber1Suffix;

    private Integer thoroughfareNumber2;

    private String thoroughfareNumber2Suffix;

    private String flatUnitType;

    private String flatUnitNumber;

    private String floorLevelType;

    private String floorLevelNumber;

    private String lotNumber;

    private String buildingName1;

    private String buildingName2;

    private String streetName;

    private String streetType;

    private String streetSuffix;

    private String postalDeliveryType;

    private Integer postalDeliveryNumber;

    private String postalDeliveryNumberPrefix;

    private String postalDeliveryNumberSuffix;

    private String localityName;

    private String postcode;

    private String state;

    /**
     * Unique identifier for an address as defined by Australia Post.  Also known as Delivery Point Identifier
     * @return dpid
     */
    public String getDpid() {
        return dpid;
    }

    public void setDpid(String dpid) {
        this.dpid = dpid;
    }

    /**
     * Thoroughfare number for a property (first number in a property ranged address)
     * @return thoroughfareNumber1
     */
    public Integer getThoroughfareNumber1() {
        return thoroughfareNumber1;
    }

    public void setThoroughfareNumber1(Integer thoroughfareNumber1) {
        this.thoroughfareNumber1 = thoroughfareNumber1;
    }

    /**
     * Suffix for the thoroughfare number. Only relevant is thoroughfareNumber1 is populated
     * @return thoroughfareNumber1Suffix
     */
    public String getThoroughfareNumber1Suffix() {
        return thoroughfareNumber1Suffix;
    }

    public void setThoroughfareNumber1Suffix(String thoroughfareNumber1Suffix) {
        this.thoroughfareNumber1Suffix = thoroughfareNumber1Suffix;
    }

    /**
     * Second thoroughfare number (only used if the property has a ranged address eg 23-25)
     * @return thoroughfareNumber2
     */
    public Integer getThoroughfareNumber2() {
        return thoroughfareNumber2;
    }

    public void setThoroughfareNumber2(Integer thoroughfareNumber2) {
        this.thoroughfareNumber2 = thoroughfareNumber2;
    }

    /**
     * Suffix for the second thoroughfare number. Only relevant is thoroughfareNumber2 is populated
     * @return thoroughfareNumber2Suffix
     */
    public String getThoroughfareNumber2Suffix() {
        return thoroughfareNumber2Suffix;
    }

    public void setThoroughfareNumber2Suffix(String thoroughfareNumber2Suffix) {
        this.thoroughfareNumber2Suffix = thoroughfareNumber2Suffix;
    }

    /**
     * Type of flat or unit for the address
     * @return flatUnitType
     */
    public String getFlatUnitType() {
        return flatUnitType;
    }

    public void setFlatUnitType(String flatUnitType) {
        this.flatUnitType = flatUnitType;
    }

    /**
     * Unit number (including suffix, if applicable)
     * @return flatUnitNumber
     */
    public String getFlatUnitNumber() {
        return flatUnitNumber;
    }

    public void setFlatUnitNumber(String flatUnitNumber) {
        this.flatUnitNumber = flatUnitNumber;
    }

    /**
     * Type of floor or level for the address
     * @return floorLevelType
     */
    public String getFloorLevelType() {
        return floorLevelType;
    }

    public void setFloorLevelType(String floorLevelType) {
        this.floorLevelType = floorLevelType;
    }

    /**
     * Floor or level number (including alpha characters)
     * @return floorLevelNumber
     */
    public String getFloorLevelNumber() {
        return floorLevelNumber;
    }

    public void setFloorLevelNumber(String floorLevelNumber) {
        this.floorLevelNumber = floorLevelNumber;
    }

    /**
     * Allotment number for the address
     * @return lotNumber
     */
    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    /**
     * Building/Property name 1
     * @return buildingName1
     */
    public String getBuildingName1() {
        return buildingName1;
    }

    public void setBuildingName1(String buildingName1) {
        this.buildingName1 = buildingName1;
    }

    /**
     * Building/Property name 2
     * @return buildingName2
     */
    public String getBuildingName2() {
        return buildingName2;
    }

    public void setBuildingName2(String buildingName2) {
        this.buildingName2 = buildingName2;
    }

    /**
     * The name of the street
     * @return streetName
     */
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * The street type. Valid enumeration defined by Australia Post PAF code file
     * @return streetType
     */
    public String getStreetType() {
        return streetType;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }

    /**
     * The street type suffix. Valid enumeration defined by Australia Post PAF code file
     * @return streetSuffix
     */
    public String getStreetSuffix() {
        return streetSuffix;
    }

    public void setStreetSuffix(String streetSuffix) {
        this.streetSuffix = streetSuffix;
    }

    /**
     * Postal delivery type. (eg. PO BOX). Valid enumeration defined by Australia Post PAF code file
     * @return postalDeliveryType
     */
    public String getPostalDeliveryType() {
        return postalDeliveryType;
    }

    public void setPostalDeliveryType(String postalDeliveryType) {
        this.postalDeliveryType = postalDeliveryType;
    }

    /**
     * Postal delivery number if the address is a postal delivery type
     * @return postalDeliveryNumber
     */
    public Integer getPostalDeliveryNumber() {
        return postalDeliveryNumber;
    }

    public void setPostalDeliveryNumber(Integer postalDeliveryNumber) {
        this.postalDeliveryNumber = postalDeliveryNumber;
    }

    /**
     * Postal delivery number prefix related to the postal delivery number
     * @return postalDeliveryNumberPrefix
     */
    public String getPostalDeliveryNumberPrefix() {
        return postalDeliveryNumberPrefix;
    }

    public void setPostalDeliveryNumberPrefix(String postalDeliveryNumberPrefix) {
        this.postalDeliveryNumberPrefix = postalDeliveryNumberPrefix;
    }

    /**
     * Postal delivery number suffix related to the postal delivery number
     * @return postalDeliveryNumberSuffix
     */
    public String getPostalDeliveryNumberSuffix() {
        return postalDeliveryNumberSuffix;
    }

    public void setPostalDeliveryNumberSuffix(String postalDeliveryNumberSuffix) {
        this.postalDeliveryNumberSuffix = postalDeliveryNumberSuffix;
    }

    /**
     * Full name of locality
     * @return localityName
     */
    public String getLocalityName() {
        return localityName;
    }

    public void setLocalityName(String localityName) {
        this.localityName = localityName;
    }

    /**
     * Postcode for the locality
     * @return postcode
     */
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * State in which the address belongs. Valid enumeration defined by Australia Post PAF code file [State Type Abbreviation](https://auspost.com.au/content/dam/auspost_corp/media/documents/australia-post-data-guide.pdf). NSW, QLD, VIC, NT, WA, SA, TAS, ACT, AAT
     * @return state
     */
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CommonPAFAddress commonPAFAddress = (CommonPAFAddress) o;
        return Objects.equals(this.dpid, commonPAFAddress.dpid) &&
            Objects.equals(this.thoroughfareNumber1, commonPAFAddress.thoroughfareNumber1) &&
            Objects.equals(this.thoroughfareNumber1Suffix, commonPAFAddress.thoroughfareNumber1Suffix) &&
            Objects.equals(this.thoroughfareNumber2, commonPAFAddress.thoroughfareNumber2) &&
            Objects.equals(this.thoroughfareNumber2Suffix, commonPAFAddress.thoroughfareNumber2Suffix) &&
            Objects.equals(this.flatUnitType, commonPAFAddress.flatUnitType) &&
            Objects.equals(this.flatUnitNumber, commonPAFAddress.flatUnitNumber) &&
            Objects.equals(this.floorLevelType, commonPAFAddress.floorLevelType) &&
            Objects.equals(this.floorLevelNumber, commonPAFAddress.floorLevelNumber) &&
            Objects.equals(this.lotNumber, commonPAFAddress.lotNumber) &&
            Objects.equals(this.buildingName1, commonPAFAddress.buildingName1) &&
            Objects.equals(this.buildingName2, commonPAFAddress.buildingName2) &&
            Objects.equals(this.streetName, commonPAFAddress.streetName) &&
            Objects.equals(this.streetType, commonPAFAddress.streetType) &&
            Objects.equals(this.streetSuffix, commonPAFAddress.streetSuffix) &&
            Objects.equals(this.postalDeliveryType, commonPAFAddress.postalDeliveryType) &&
            Objects.equals(this.postalDeliveryNumber, commonPAFAddress.postalDeliveryNumber) &&
            Objects.equals(this.postalDeliveryNumberPrefix, commonPAFAddress.postalDeliveryNumberPrefix) &&
            Objects.equals(this.postalDeliveryNumberSuffix, commonPAFAddress.postalDeliveryNumberSuffix) &&
            Objects.equals(this.localityName, commonPAFAddress.localityName) &&
            Objects.equals(this.postcode, commonPAFAddress.postcode) &&
            Objects.equals(this.state, commonPAFAddress.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            dpid,
            thoroughfareNumber1,
            thoroughfareNumber1Suffix,
            thoroughfareNumber2,
            thoroughfareNumber2Suffix,
            flatUnitType,
            flatUnitNumber,
            floorLevelType,
            floorLevelNumber,
            lotNumber,
            buildingName1,
            buildingName2,
            streetName,
            streetType,
            streetSuffix,
            postalDeliveryType,
            postalDeliveryNumber,
            postalDeliveryNumberPrefix,
            postalDeliveryNumberSuffix,
            localityName,
            postcode,
            state);
    }

    @Override
    public String toString() {
        return "class CommonPAFAddress {\n" +
            "   dpid: " + toIndentedString(dpid) + "\n" + 
            "   thoroughfareNumber1: " + toIndentedString(thoroughfareNumber1) + "\n" + 
            "   thoroughfareNumber1Suffix: " + toIndentedString(thoroughfareNumber1Suffix) + "\n" + 
            "   thoroughfareNumber2: " + toIndentedString(thoroughfareNumber2) + "\n" + 
            "   thoroughfareNumber2Suffix: " + toIndentedString(thoroughfareNumber2Suffix) + "\n" + 
            "   flatUnitType: " + toIndentedString(flatUnitType) + "\n" + 
            "   flatUnitNumber: " + toIndentedString(flatUnitNumber) + "\n" + 
            "   floorLevelType: " + toIndentedString(floorLevelType) + "\n" + 
            "   floorLevelNumber: " + toIndentedString(floorLevelNumber) + "\n" + 
            "   lotNumber: " + toIndentedString(lotNumber) + "\n" + 
            "   buildingName1: " + toIndentedString(buildingName1) + "\n" + 
            "   buildingName2: " + toIndentedString(buildingName2) + "\n" + 
            "   streetName: " + toIndentedString(streetName) + "\n" + 
            "   streetType: " + toIndentedString(streetType) + "\n" + 
            "   streetSuffix: " + toIndentedString(streetSuffix) + "\n" + 
            "   postalDeliveryType: " + toIndentedString(postalDeliveryType) + "\n" + 
            "   postalDeliveryNumber: " + toIndentedString(postalDeliveryNumber) + "\n" + 
            "   postalDeliveryNumberPrefix: " + toIndentedString(postalDeliveryNumberPrefix) + "\n" + 
            "   postalDeliveryNumberSuffix: " + toIndentedString(postalDeliveryNumberSuffix) + "\n" + 
            "   localityName: " + toIndentedString(localityName) + "\n" + 
            "   postcode: " + toIndentedString(postcode) + "\n" + 
            "   state: " + toIndentedString(state) + "\n" + 
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
