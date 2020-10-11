package com.bt.mhatsapp.chat;

public class ContactDataModel {

    private  String contactName;
    private  String contactMobile;
    private  String contactImage;

    public ContactDataModel(String contactName, String contactMobile, String contactImage) {
        this.contactName = contactName;
        this.contactMobile = contactMobile;
        this.contactImage = contactImage;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getContactImage() {
        return contactImage;
    }

    public void setContactImage(String contactImage) {
        this.contactImage = contactImage;
    }


}
