package com.example.myapplication.ui.main;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplication.R;
import com.example.myapplication.User;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
    private final Context mContext;
    private  User user;

    public SectionsPagerAdapter(Context context, FragmentManager fm, User user) {
        super(fm);
        mContext = context;
        this.user=user;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch (position){
            case 0:
                Bundle b =new Bundle();
                b.putSerializable("current_user",user);
                return  PlaceholderFragment.newInstance(position, b);
            case 2:
                Bundle bundle =new Bundle();
                bundle.putSerializable("current_user",user);
                return  PlaceholderFragment.newInstance(position, bundle);
            /*case 3:
                Bundle bundle1 =new Bundle();
                bundle1.putSerializable("current_user",user);
                PlaceholderFragment frg1= new PlaceholderFragment();
                frg1.setArguments(bundle1);
                return frg1;*/

        }
        return PlaceholderFragment.newInstance(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return TAB_TITLES.length;
    }
}