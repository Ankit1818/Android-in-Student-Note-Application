package com.example.noticeboard.Admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.noticeboard.R;

import java.util.List;

class MyAdapterStaffDetails extends BaseAdapter {
    Context context;
    List<StaffDetailAdminModel> list1;
    public MyAdapterStaffDetails(Context context, List<StaffDetailAdminModel> list1) {
        this.context=context;
        this.list1=list1;
    }

    @Override
    public int getCount() {
        return list1.size();
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
        view=in.inflate(R.layout.admin_view_staff_detail_design,viewGroup,false);

        TextView textView=view.findViewById(R.id.txtStaffEmail);
        TextView textView2=view.findViewById(R.id.txtStaffPassword);

        StaffDetailAdminModel staffModel=list1.get(i);
        textView.setText(staffModel.StaffEmail);
        textView2.setText(staffModel.StaffPassword);
        return view;
    }
}
