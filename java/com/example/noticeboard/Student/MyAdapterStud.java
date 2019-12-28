package com.example.noticeboard.Student;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.noticeboard.Admin.AdminNoteAddFragment;
import com.example.noticeboard.Admin.ViewAdminFragment;

import static com.example.noticeboard.Student.TabFragmentStudent.int_Stud_items;

public class MyAdapterStud extends FragmentPagerAdapter {


    public MyAdapterStud(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ViewStudNoteFragment();
            case 1:
                return new FavoriteNoteFragment();



        }
        return null;
    }

    @Override
    public int getCount() {


        return int_Stud_items;
    }

    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "View";
            case 1:
                return "Favorite";



        }

        return null;
    }
}

