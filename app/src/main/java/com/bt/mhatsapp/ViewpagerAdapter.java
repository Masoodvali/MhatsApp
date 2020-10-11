package com.bt.mhatsapp;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.bt.mhatsapp.chat.ChatFragment;

import java.sql.Array;
import java.util.ArrayList;

public class ViewpagerAdapter extends FragmentPagerAdapter {
    private static int PAGE_INT=3;
    private String[] screenNames={"chats","status","calls"};
    public ViewpagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            default:
               return new ChatFragment();
        }
       // return null;
    }

    @Override
    public int getCount() {
        return PAGE_INT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return screenNames[position];
    }
}
