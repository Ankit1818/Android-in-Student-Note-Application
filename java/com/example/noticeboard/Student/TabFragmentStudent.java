package com.example.noticeboard.Student;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.noticeboard.R;
import com.example.noticeboard.Staff.MyAdapterStaff;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragmentStudent extends Fragment {
    public  static TabLayout tabLayoutStud;
    public  static ViewPager viewPagerStud;
    public  static int int_Stud_items= 2;
View v;
    public TabFragmentStudent() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_tab_fragment_student, container, false);

        tabLayoutStud=(TabLayout)v.findViewById(R.id.Studtabs);
        viewPagerStud=(ViewPager)v.findViewById(R.id.Studviewpager);
        //set an adpater

        viewPagerStud.setAdapter(new MyAdapterStud( getChildFragmentManager()));


        tabLayoutStud.post(new Runnable() {
            @Override
            public void run() {
                tabLayoutStud.setupWithViewPager(viewPagerStud);

            }
        });




        return v;
    }

}
