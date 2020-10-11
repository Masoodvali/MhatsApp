package com.bt.mhatsapp.contactsearch;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ContactSearchViewModel extends AndroidViewModel {
    private ContactSearchRepository contactSearchRepository;
    public MutableLiveData<List<ContactSearchDataModel>> liveContactData = new MutableLiveData<>();


    public ContactSearchViewModel(@NonNull Application application) {
        super(application);
        contactSearchRepository = new ContactSearchRepository(application);

    }

    public MutableLiveData<List<ContactSearchDataModel>> getContactForSearch() {
        liveContactData.setValue(contactSearchRepository.getContactsListData());
        return liveContactData;
    }
}
