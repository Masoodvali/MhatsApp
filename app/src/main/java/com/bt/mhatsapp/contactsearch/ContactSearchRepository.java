package com.bt.mhatsapp.contactsearch;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;

public class ContactSearchRepository {

    private Context context;
    private List<ContactSearchDataModel> contactList = new ArrayList<>();

    public ContactSearchRepository(Context context) {
        this.context = context;
    }

    public List<ContactSearchDataModel> getContactsListData() {
        Cursor cursor = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null, null, null, null, null);
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String contactMobile = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                if (contactMobile != null) {
                    ContactSearchDataModel contactDataModel = new ContactSearchDataModel(contactName, contactMobile, null);
                    contactList.add(contactDataModel);
                }
            }
        }
        if(cursor!=null){
            cursor.close();
        }
        return contactList;
    }
}
