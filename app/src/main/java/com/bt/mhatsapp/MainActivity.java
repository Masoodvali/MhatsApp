package com.bt.mhatsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity    {

    //    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    ViewPager viewPager;

    ViewpagerAdapter viewpagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.viewpager);

        addNamesToTabs();
        addScreenToViewPager();
    }

    private void addNamesToTabs() {
        tabLayout.addTab(tabLayout.newTab().setText("chats"));
        tabLayout.addTab(tabLayout.newTab().setText("status"));
        tabLayout.addTab(tabLayout.newTab().setText("calls"));


    }

    private void addScreenToViewPager() {
        viewpagerAdapter=new ViewpagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewpagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
