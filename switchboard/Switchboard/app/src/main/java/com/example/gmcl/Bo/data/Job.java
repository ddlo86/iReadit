package com.example.gmcl.Bo.data;

import java.io.Serializable;

/**
 * Created by ddlo86 on 09/10/2015.
 */
public class Job implements Serializable {

    //TODO files? Maybe? This is mostly for bundle transfers to fragments
    //TODO: Date should probably be a date
    String objectId;
    String dropoffAddress;
    String dropoffCity;
    String dropoffCompany;
    String dropoffCompanyNumber;
    String dropoffCountry;
    String dropoffDate;
    String dropoffPostalCode;
    String dropoffProvince;
    String jobId;
    String pickupAddress;
    String pickupCity;
    String pickupCompany;
    String pickupCompanyNumber;
    String pickupCountry;
    String pickupDate;

    public String getPickupPostalCode() {
        return pickupPostalCode;
    }

    public void setPickupPostalCode(String pickupPostalCode) {
        this.pickupPostalCode = pickupPostalCode;
    }

    String pickupPostalCode;
    String pickupProvince;
    String size;
    boolean assigned;
    int quantity, trailerType, weight;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getDropoffAddress() {
        return dropoffAddress;
    }

    public void setDropoffAddress(String dropoffAddress) {
        this.dropoffAddress = dropoffAddress;
    }

    public String getDropoffCity() {
        return dropoffCity;
    }

    public void setDropoffCity(String dropoffCity) {
        this.dropoffCity = dropoffCity;
    }

    public String getDropoffCompany() {
        return dropoffCompany;
    }

    public void setDropoffCompany(String dropoffCompany) {
        this.dropoffCompany = dropoffCompany;
    }

    public String getDropoffCompanyNumber() {
        return dropoffCompanyNumber;
    }

    public void setDropoffCompanyNumber(String dropoffCompanyNumber) {
        this.dropoffCompanyNumber = dropoffCompanyNumber;
    }

    public String getDropoffCountry() {
        return dropoffCountry;
    }

    public void setDropoffCountry(String dropoffCountry) {
        this.dropoffCountry = dropoffCountry;
    }

    public String getDropoffDate() {
        return dropoffDate;
    }

    public void setDropoffDate(String dropoffDate) {
        this.dropoffDate = dropoffDate;
    }

    public String getDropoffPostalCode() {
        return dropoffPostalCode;
    }

    public void setDropoffPostalCode(String dropoffPostalCode) {
        this.dropoffPostalCode = dropoffPostalCode;
    }

    public String getDropoffProvince() {
        return dropoffProvince;
    }

    public void setDropoffProvince(String dropoffProvince) {
        this.dropoffProvince = dropoffProvince;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public String getPickupCity() {
        return pickupCity;
    }

    public void setPickupCity(String pickupCity) {
        this.pickupCity = pickupCity;
    }

    public String getPickupCompany() {
        return pickupCompany;
    }

    public void setPickupCompany(String pickupCompany) {
        this.pickupCompany = pickupCompany;
    }

    public String getPickupCompanyNumber() {
        return pickupCompanyNumber;
    }

    public void setPickupCompanyNumber(String pickupCompanyNumber) {
        this.pickupCompanyNumber = pickupCompanyNumber;
    }

    public String getPickupCountry() {
        return pickupCountry;
    }

    public void setPickupCountry(String pickupCountry) {
        this.pickupCountry = pickupCountry;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getPickupProvince() {
        return pickupProvince;
    }

    public void setPickupProvince(String pickupProvince) {
        this.pickupProvince = pickupProvince;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTrailerType() {
        return trailerType;
    }

    public void setTrailerType(int trailerType) {
        this.trailerType = trailerType;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
