package com.example.noticeboard.Student;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.noticeboard.Admin.MyAdapterViewNoteAdmin;
import com.example.noticeboard.Admin.ViewNoteAdminModel;
import com.example.noticeboard.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewStudNoteFragment extends Fragment {
CheckBox checkBox;
    ListView listViewstaff;
    List<ViewNoteAdminModel> list;
    View v;
    public ViewStudNoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_view_stud_note, container, false);
        listViewstaff=v.findViewById( R.id.viewStafflist );
        list= new ArrayList<>(  );

StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://decompressive-scrat.000webhostapp.com/NoticeBoard/NoteView.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        ViewNoteAdminModel m1 = new ViewNoteAdminModel();
                        String Id = object.getString("Id");
                        String Name = object.getString("Name");
                        String NoteTitle = object.getString("NoteTitle");
                        String NoteSubject = object.getString("NoteSubject");
                        String NoteDetails	 = object.getString("NoteDetails");

                        m1.Id = Id;
                        m1.Name = Name;
                        m1.NoteTitle = NoteTitle;
                        m1.NoteSubject = NoteSubject;
                        m1.NoteDetails = NoteDetails;


                        list.add(m1);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                MyAdapterViewNoteStud adapter1 = new MyAdapterViewNoteStud(getActivity(),list);
                listViewstaff.setAdapter(adapter1);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {

                Toast.makeText(getActivity(), "No internet", Toast.LENGTH_SHORT).show();

            }
        });
        RequestQueue queue= Volley.newRequestQueue(getActivity());
        queue.add(stringRequest);



        return v;
    }

}
