package com.bt.mhatsapp.contactsearch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bt.mhatsapp.R;

import java.util.ArrayList;
import java.util.List;

public class ContactSearchActivity extends AppCompatActivity {
    ContactSearchViewModel contactSearchViewModel;
    List<ContactSearchDataModel> contactSearchDataModelList=new ArrayList<>();
    RecyclerView recyclerView;
    ContactSearchListAdapter contactSearchListAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_search);
        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getSupportActionBar().setIcon(R.drawable.ic_description_black_24dp);


        contactSearchViewModel= ViewModelProviders.of(this).get(ContactSearchViewModel.class);


        contactSearchViewModel.getContactForSearch().observe(this, new Observer<List<ContactSearchDataModel>>() {
            @Override
            public void onChanged(List<ContactSearchDataModel> contactSearchDataModels) {
                contactSearchDataModelList=contactSearchDataModels;
                contactSearchListAdapter=new ContactSearchListAdapter(ContactSearchActivity.this,contactSearchDataModelList);

                recyclerView.setAdapter(contactSearchListAdapter);

            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add()
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
