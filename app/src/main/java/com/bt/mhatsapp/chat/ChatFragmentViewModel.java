package com.bt.mhatsapp.chat;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class ChatFragmentViewModel extends AndroidViewModel {
    public ContactRepository contactRepository;

    public MutableLiveData<List<ContactDataModel>> liveContactData = new MutableLiveData<>();

    public ChatFragmentViewModel(@NonNull Application application) {
        super(application);

        contactRepository = new ContactRepository(application);
    }

    public MutableLiveData<List<ContactDataModel>> getContactsFromPhone() {
        liveContactData.setValue(contactRepository.getContacts());


        return liveContactData;
    }
}
