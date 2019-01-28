package com.radik.testing.testapplication.domain.model.query;

import android.support.annotation.NonNull;

public class AccountRecord {


    private RecordAttributes attributes;
    private String AccountId__c;
    private String ConnectionReceivedId;
    private String ConnectionSentId;
    private String CreatedById;
    private String CreatedDate;
    private String CurrencyIsoCode;
    private String Description__c;
    private String EndDate__c;
    private String Geolocation__c;
    private String Id;
    private String IsApproved__c;
    private String IsDeleted;
    private String IsDone__c;
    private String IsLocked__c;
    private String LastActivityDate;
    private String LastModifiedById;
    private String LastModifiedDate;
    private String LastReferencedDate;
    private String LastViewedDate;
    private String Name;
    private String OwnerId;
    private String RecordTypeId;
    private String StartDate__c;
    private String Status__c;
    private String Subject__c;
    private String SystemModstamp;

    public AccountRecord() {
    }

    public String getAccountId__c() {
        return AccountId__c;
    }

    public void setAccountId__c(String accountId__c) {
        AccountId__c = accountId__c;
    }

    public String getConnectionReceivedId() {
        return ConnectionReceivedId;
    }

    public void setConnectionReceivedId(String connectionReceivedId) {
        ConnectionReceivedId = connectionReceivedId;
    }

    public String getConnectionSentId() {
        return ConnectionSentId;
    }

    public void setConnectionSentId(String connectionSentId) {
        ConnectionSentId = connectionSentId;
    }

    public String getCreatedById() {
        return CreatedById;
    }

    public void setCreatedById(String createdById) {
        CreatedById = createdById;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }

    public String getCurrencyIsoCode() {
        return CurrencyIsoCode;
    }

    public void setCurrencyIsoCode(String currencyIsoCode) {
        CurrencyIsoCode = currencyIsoCode;
    }

    public String getDescription__c() {
        return Description__c;
    }

    public void setDescription__c(String description__c) {
        Description__c = description__c;
    }

    public String getEndDate__c() {
        return EndDate__c;
    }

    public void setEndDate__c(String endDate__c) {
        EndDate__c = endDate__c;
    }

    public String getGeolocation__c() {
        return Geolocation__c;
    }

    public void setGeolocation__c(String geolocation__c) {
        Geolocation__c = geolocation__c;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getIsApproved__c() {
        return IsApproved__c;
    }

    public void setIsApproved__c(String isApproved__c) {
        IsApproved__c = isApproved__c;
    }

    public String getIsDeleted() {
        return IsDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        IsDeleted = isDeleted;
    }

    public String getIsDone__c() {
        return IsDone__c;
    }

    public void setIsDone__c(String isDone__c) {
        IsDone__c = isDone__c;
    }

    public String getIsLocked__c() {
        return IsLocked__c;
    }

    public void setIsLocked__c(String isLocked__c) {
        IsLocked__c = isLocked__c;
    }

    public String getLastActivityDate() {
        return LastActivityDate;
    }

    public void setLastActivityDate(String lastActivityDate) {
        LastActivityDate = lastActivityDate;
    }

    public String getLastModifiedById() {
        return LastModifiedById;
    }

    public void setLastModifiedById(String lastModifiedById) {
        LastModifiedById = lastModifiedById;
    }

    public String getLastModifiedDate() {
        return LastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        LastModifiedDate = lastModifiedDate;
    }

    public String getLastReferencedDate() {
        return LastReferencedDate;
    }

    public void setLastReferencedDate(String lastReferencedDate) {
        LastReferencedDate = lastReferencedDate;
    }

    public String getLastViewedDate() {
        return LastViewedDate;
    }

    public void setLastViewedDate(String lastViewedDate) {
        LastViewedDate = lastViewedDate;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getOwnerId() {
        return OwnerId;
    }

    public void setOwnerId(String ownerId) {
        OwnerId = ownerId;
    }

    public String getRecordTypeId() {
        return RecordTypeId;
    }

    public void setRecordTypeId(String recordTypeId) {
        RecordTypeId = recordTypeId;
    }

    public String getStartDate__c() {
        return StartDate__c;
    }

    public void setStartDate__c(String startDate__c) {
        StartDate__c = startDate__c;
    }

    public String getStatus__c() {
        return Status__c;
    }

    public void setStatus__c(String status__c) {
        Status__c = status__c;
    }

    public String getSubject__c() {
        return Subject__c;
    }

    public void setSubject__c(String subject__c) {
        Subject__c = subject__c;
    }

    public String getSystemModstamp() {
        return SystemModstamp;
    }

    public void setSystemModstamp(String systemModstamp) {
        SystemModstamp = systemModstamp;
    }

    public RecordAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(RecordAttributes attributes) {
        this.attributes = attributes;
    }

    @NonNull
    @Override
    public String toString() {
        return Name;
    }
}
