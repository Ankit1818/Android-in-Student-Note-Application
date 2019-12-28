package com.example.noticeboard.Staff;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.noticeboard.Admin.MainActivity;
import com.example.noticeboard.Admin.MyAdapterViewNoteAdmin;
import com.example.noticeboard.Admin.SessionManagement;
import com.example.noticeboard.Admin.ViewNoteAdminModel;
import com.example.noticeboard.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewNoteStaffFragment extends Fragment {
    ListView listView;
    List<ViewNoteAdminModel> list;
    View  v;
    SessionManagementStaff sessionstaff;
    public ViewNoteStaffFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_view_note_staff, container, false);
        sessionstaff=new SessionManagementStaff(getActivity());
        listView=v.findViewById( R.id.viewStafflist );
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
                MyAdapterViewNoteStaff adapter = new MyAdapterViewNoteStaff(getContext(),list);
                listView.setAdapter(adapter);
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

        registerForContextMenu(listView);


        return v;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuItem m5=menu.add(0,7,0,"Update");
        MenuItem m6=menu.add(0,8,0,"Delete");

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo acm =(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

        int id=acm.position;

        if(item.getItemId()==7)
        {
            ViewNoteAdminModel mode=list.get(id);
            final String Id = mode.getId();
            final String name=mode.getName();
            final String NoteTitle=mode.getNoteTitle();
            final String NoteSubject=mode.getNoteSubject();
            final String NoteDetails=mode.getNoteDetails();
            final String txtnoteid=mode.getId();
            /*Toast.makeText(getActivity(), "demoooo"+name, Toast.LENGTH_SHORT).show();*/
            HashMap<String, String> user = sessionstaff.getUserDetails();
            String name1 = user.get(SessionManagementStaff.KEY_EMAIL1);
            if(name.compareTo(name1) == 0) {


                final Dialog dialogup = new Dialog(getActivity());
                dialogup.setContentView(R.layout.add_note_design);
                dialogup.setTitle("Title");


                final EditText editname = dialogup.findViewById(R.id.editname);
                final EditText editnotetitle = dialogup.findViewById(R.id.editnotetitle);
                final EditText editnotesubject = dialogup.findViewById(R.id.editnotesubject);
                final EditText editnotedetails = dialogup.findViewById(R.id.editdetail);

                Button btnadd = dialogup.findViewById(R.id.editbtnadd);

                btnadd.setText("Update");
                editname.setText(name);
                editnotetitle.setText(NoteTitle);
                editnotesubject.setText(NoteSubject);
                editnotedetails.setText(NoteDetails);

                dialogup.show();
                btnadd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final String txteditname = editname.getText().toString().trim();
                        final String txteditnotetitle = editnotetitle.getText().toString().trim();
                        final String txteditnotesubject = editnotesubject.getText().toString().trim();
                        final String txteditnotedetails = editnotedetails.getText().toString().trim();

                        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://decompressive-scrat.000webhostapp.com/NoticeBoard/UpdateNote.php", new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                Toast.makeText(getActivity(), "Update Sucessfully..!", Toast.LENGTH_LONG).show();

                                Intent i = new Intent(getActivity(), MainActivityStaff.class);
                                startActivity(i);

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getActivity(), "No Internet", Toast.LENGTH_SHORT).show();
                            }
                        }) {
                            @Override
                            protected Map<String, String> getParams() {
                                Map<String, String> params = new HashMap<String, String>();
                                params.put("Id", txtnoteid);
                                params.put("Name", txteditname);
                                params.put("NoteTitle", txteditnotetitle);
                                params.put("NoteSubject", txteditnotesubject);
                                params.put("NoteDetails", txteditnotedetails);


                                return params;
                            }


                        };

                        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                        requestQueue.add(stringRequest);

                        dialogup.dismiss();

                    }
                });
            }
            else
            {
                Toast.makeText(getActivity(), "can't updateee", Toast.LENGTH_SHORT).show();
            }


        }

        if(item.getItemId()==8) {
            ViewNoteAdminModel mode=list.get(id);
            final String name=mode.getName();
            final String Id = mode.getId();
            HashMap<String, String> user = sessionstaff.getUserDetails();
            String name1 = user.get(SessionManagementStaff.KEY_EMAIL1);
            if( name.compareTo(name1) == 0 ){
                AlertDialog.Builder alert=new AlertDialog.Builder(getActivity());
                alert.setTitle("Delete");
                alert.setMessage("Want to delete it?");
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        /*Toast.makeText(getActivity(), "Delete success"+Id, Toast.LENGTH_SHORT).show();*/
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://decompressive-scrat.000webhostapp.com/NoticeBoard/DeleteNote.php", new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                Intent intent =new Intent(getActivity(),MainActivityStaff.class);
                                startActivity(intent);
                                Toast.makeText(getActivity(), "Record Delete Sucess..!", Toast.LENGTH_LONG).show();


                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getActivity(), "No Internet", Toast.LENGTH_SHORT).show();

                            }
                        }) {
                            @Override
                            protected Map<String, String> getParams() {
                                Map<String, String> params = new HashMap<String, String>();
                                params.put("Id", Id);


                                return params;
                            }


                        };

                        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                        requestQueue.add(stringRequest);


                    }
                });
                alert.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alert.show();


            }
            else {
                Toast.makeText(getActivity(), "can't delete..!", Toast.LENGTH_SHORT).show();
            }

        }
        return super.onContextItemSelected(item);
    }
}
