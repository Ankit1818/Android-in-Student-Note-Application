package com.example.noticeboard.Staff;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.noticeboard.Admin.MyAdapter;
import com.example.noticeboard.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragmentStaff extends Fragment {
    public  static TabLayout tabLayoutstaff;
    public  static ViewPager viewPagerstaff;
    public  static int int_staff_items= 2;
View v;
    public TabFragmentStaff() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       v= inflater.inflate(R.layout.fragment_tab_fragment_staff, container, false);
        tabLayoutstaff=(TabLayout)v.findViewById(R.id.stafftabs);
        viewPagerstaff=(ViewPager)v.findViewById(R.id.staffviewpager);
        //set an adpater

        viewPagerstaff.setAdapter(new MyAdapterStaff( getChildFragmentManager()));

        tabLayoutstaff.post(new Runnable() {
            @Override
            public void run() {
                tabLayoutstaff.setupWithViewPager(viewPagerstaff);

            }
        });

       return v;
    }

}
