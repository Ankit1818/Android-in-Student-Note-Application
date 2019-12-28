package com.example.noticeboard.Staff;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.noticeboard.Admin.MainActivity;
import com.example.noticeboard.Admin.SessionManagement;
import com.example.noticeboard.R;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddNoteStaffFragment extends Fragment {

View v;
ImageButton staffAddnote;
SessionManagementStaff sessionstaff;
    public AddNoteStaffFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_add_note_staff, container, false);
        final ProgressDialog pd = new ProgressDialog(getActivity());
        pd.setMessage("please wait...");
sessionstaff=new SessionManagementStaff(getActivity());

        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.add_note_design);
        dialog.setTitle("Title");

        final EditText editnamestaff=dialog.findViewById(R.id.editname);

        HashMap<String, String> user = sessionstaff.getUserDetails();

        // name
        String name1 = user.get(SessionManagementStaff.KEY_EMAIL1);
        editnamestaff.setText(name1);
        staffAddnote=v.findViewById(R.id.staffAddnote);
        staffAddnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               dialog.show();
                Button send = (Button) dialog.findViewById(R.id.editbtnadd);
                send.setText("Send");

                send.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText  editnotetitle=dialog.findViewById(R.id.editnotetitle);
                        EditText   editnotesubject=dialog.findViewById(R.id.editnotesubject);
                        EditText  editnotedetails=dialog.findViewById(R.id.editdetail);


                        final String Name = editnamestaff.getText().toString();
                        final String NoteTitle = editnotetitle.getText().toString().trim();
                        final String   NoteSubject = editnotesubject.getText().toString().trim();
                        final String NoteDetails = editnotedetails.getText().toString();
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://decompressive-scrat.000webhostapp.com/NoticeBoard/AddNotes.php", new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                pd.hide();

                                Toast.makeText(getActivity(),"Send..! ",Toast.LENGTH_LONG).show();

                                Intent i =new Intent(getActivity(), MainActivityStaff.class);
                                startActivity(i);
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }){
                            @Override
                            protected Map<String,String> getParams(){
                                Map<String,String> params = new HashMap<String, String>();
                                params.put("Name",Name);
                                params.put("NoteTitle",NoteTitle);
                                params.put("NoteSubject", NoteSubject);
                                params.put("NoteDetails", NoteDetails);


                                return params;
                            }



                        };

                        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                        requestQueue.add(stringRequest);

                        dialog.dismiss();

                    }
                });

            }
        });
        return v;
    }

}
