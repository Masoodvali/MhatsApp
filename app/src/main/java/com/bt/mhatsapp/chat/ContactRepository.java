package com.bt.mhatsapp.chat;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ContactRepository {

    private Context context;

    public ContactRepository(Context context) {
        this.context = context;

    }

    public List<ContactDataModel> getContacts() {
        List<ContactDataModel> contactList = new ArrayList<>();
        try {
            Cursor c = context.getContentResolver().query(ContactsContract.Data.CONTENT_URI, null, null, null, null);
            if (c != null && c.getCount() > 0) {
                while (c.moveToNext()) {
                    String contactName = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    String contactMobile = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//                  String displayImage=c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Photo));
                    if (contactMobile != null) {
                        ContactDataModel contactDataModel = new ContactDataModel(contactName, contactMobile, null);
                        Log.d("" + contactName, "" + contactMobile);
                        contactList.add(contactDataModel);
                    }
                }

            }
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return contactList;
    }


}
