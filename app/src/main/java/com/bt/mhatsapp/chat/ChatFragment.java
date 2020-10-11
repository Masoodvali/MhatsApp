package com.bt.mhatsapp.chat;

import android.content.Intent;
import android.os.Bundle;
import android.util.LayoutDirection;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bt.mhatsapp.R;
import com.bt.mhatsapp.contactsearch.ContactSearchActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatFragment extends Fragment {

    private String TAG = ChatFragment.class.getSimpleName();
    RecyclerView rvContactsList;
    FloatingActionButton fabChat;

    private ChatFragmentViewModel chatFragmentViewModel;
    List<ContactDataModel> contactList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.chat_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        rvContactsList = view.findViewById(R.id.recycler_view);
        fabChat = view.findViewById(R.id.fab_chat);

        fabChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ContactSearchActivity.class);
                startActivity(intent);
            }
        });


        chatFragmentViewModel = ViewModelProviders.of(this).get(ChatFragmentViewModel.class);

        chatFragmentViewModel.getContactsFromPhone().observe(Objects.requireNonNull(getActivity()),
                new Observer<List<ContactDataModel>>() {
                    @Override
                    public void onChanged(List<ContactDataModel> contactDataModels) {
                        Log.d(TAG, "" + contactDataModels);
                        contactList = contactDataModels;
                    }
                });


        ContactsListAdapter contactsListAdapter = new ContactsListAdapter(getActivity(), contactList);
        rvContactsList.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvContactsList.setAdapter(contactsListAdapter);


    }

}
