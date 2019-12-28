package com.example.noticeboard.Staff;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.noticeboard.Admin.ViewAdminFragment;

import static com.example.noticeboard.Staff.TabFragmentStaff.int_staff_items;


public class MyAdapterStaff extends FragmentPagerAdapter {


    public MyAdapterStaff(FragmentManager fms)
    {
        super(fms);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ViewNoteStaffFragment();
            case 1:
                return new AddNoteStaffFragment();



        }
        return null;
    }

    @Override
    public int getCount() {


        return int_staff_items;
    }

    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "View";
            case 1:
                return "Note";



        }

        return null;
    }
}
