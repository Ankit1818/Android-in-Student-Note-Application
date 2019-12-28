package com.example.noticeboard.Admin;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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
import com.example.noticeboard.AlertDialogManager;
import com.example.noticeboard.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminNoteAddFragment extends Fragment
{

        View view;
ImageButton adminAddnote;

SessionManagement session1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view=inflater.inflate(R.layout.fragment_admin_note_add, container, false);
        final ProgressDialog  pd = new ProgressDialog(getActivity());
        pd.setMessage("Please wait...");
        session1 = new SessionManagement(getActivity());
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.add_note_design);
        dialog.setTitle("Title");
         final EditText   editname=dialog.findViewById(R.id.editname);
        HashMap<String, String> user = session1.getUserDetails();

        // name
        String name1 = user.get(SessionManagement.KEY_EMAIL);
        editname.setText(name1);




        adminAddnote=view.findViewById(R.id.adminAddnote);
adminAddnote.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {



        Button button = (Button) dialog.findViewById(R.id.editbtnadd);
        button.setText("Send");
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                EditText  editnotetitle=dialog.findViewById(R.id.editnotetitle);
                EditText   editnotesubject=dialog.findViewById(R.id.editnotesubject);
                EditText  editnotedetails=dialog.findViewById(R.id.editdetail);


                final String Name = editname.getText().toString();
                final String NoteTitle = editnotetitle.getText().toString().trim();
                final String   NoteSubject = editnotesubject.getText().toString().trim();
                final String NoteDetails = editnotedetails.getText().toString();
                                  // Toast.makeText(getActivity(), "deta: "+Name+NoteTitle+NoteDetails+NoteSubject, Toast.LENGTH_SHORT).show();


                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://decompressive-scrat.000webhostapp.com/NoticeBoard/AddNotes.php", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            pd.hide();

                            Toast.makeText(getActivity(),"Send..! ",Toast.LENGTH_LONG).show();

                            Intent i =new Intent(getActivity(),MainActivity.class);
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


        dialog.show();



    }
});




        return view;
    }

}
