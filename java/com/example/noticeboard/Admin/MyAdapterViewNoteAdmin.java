package com.example.noticeboard.Admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.noticeboard.Admin.StudDetailAdminModel;
import com.example.noticeboard.Admin.ViewNoteAdminModel;
import com.example.noticeboard.R;

import java.util.List;

public class MyAdapterViewNoteAdmin extends BaseAdapter {
    Context context;
    List<ViewNoteAdminModel> list;

    public MyAdapterViewNoteAdmin(Context context, List<ViewNoteAdminModel> list)
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
        view=in.inflate(R.layout.view_note_admin_design,viewGroup,false);

        TextView textView=view.findViewById(R.id.txtViewname);
        TextView textView2=view.findViewById(R.id.txtnotetitle);

        TextView textView3=view.findViewById(R.id.txtnotesubject);
        TextView textView4=view.findViewById(R.id.txtdetails);



        ViewNoteAdminModel m=list.get(i);
        textView.append(m.Name);
        textView2.append(m.NoteTitle);
        textView3.append(m.NoteSubject);
                textView4.append(m.NoteDetails);

        return view;
    }
}
