package com.example.noticeboard.Admin;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import static com.example.noticeboard.Admin.TabFragment.int_items;


public class MyAdapter  extends FragmentPagerAdapter {


    public MyAdapter(FragmentManager fm)
    {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ViewAdminFragment();
            case 1:
                return new AdminNoteAddFragment();
            case 2:
                return new StudDetailAdminFragment();
            case 3:
                return new AdminViewStaffDetailFragment();


        }
        return null;
    }

    @Override
    public int getCount() {


        return int_items;
    }

    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "View";
            case 1:
                return "Note";
            case 2:
                return "Stud Detail";
            case 3:
                return "Staff Detail";


        }

        return null;
    }
}
