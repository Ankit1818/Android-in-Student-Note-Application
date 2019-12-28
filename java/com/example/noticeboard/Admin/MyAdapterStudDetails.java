package com.example.noticeboard.Admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.noticeboard.R;

import java.util.ArrayList;
import java.util.List;

class MyAdapterStudDetails extends BaseAdapter {


    Context context;
    List<StudDetailAdminModel> list;

    MyAdapterStudDetails(Context context, List<StudDetailAdminModel> list)
    {
        this.context=context;
        this.list=list;

    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater in=LayoutInflater.from(context);
        view=in.inflate(R.layout.stud_detail_admin_design,viewGroup,false);

        TextView textView=view.findViewById(R.id.txtStudentLogID);
        TextView textView2=view.findViewById(R.id.txtStudentPassword);

        StudDetailAdminModel m=list.get(i);
        textView.setText(m.StudentLogID);
        textView2.setText(m.StudentPassword);


        return view;
    }
}
