package com.example.noticeboard.Admin;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddStaffFragment extends Fragment {
View v;
    EditText editstudname,editstudpass,editstudemail;
    ImageButton imgstaffregister;
    ProgressDialog pd;
    ProgressDialog progressDialog;
    AlertDialogManager alert = new AlertDialogManager();
    public AddStaffFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_add_staff, container, false);
        pd = new ProgressDialog(getActivity());
        pd.setMessage("please wait...");
        editstudemail=v.findViewById(R.id.stafemailunm);
        editstudname=v.findViewById(R.id.stafreginame);
        editstudpass=v.findViewById(R.id.stafpass);
        imgstaffregister=v.findViewById(R.id.staffimgregi);
        imgstaffregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                final String username = editstudname.getText().toString().trim();
                final String password = editstudpass.getText().toString().trim();
                final String email = editstudemail.getText().toString().trim();
                if(username.trim().length() > 0 && password.trim().length() > 0 && email.trim().length()>0) {
                    if (password.trim().length()==4)
                    {
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://decompressive-scrat.000webhostapp.com/NoticeBoard/vollyregisterstaff.php", new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                pd.hide();
                                /*progressDialog = ProgressDialog.show(getActivity(),"Loading Data",null,true,true);*/
                                Toast.makeText(getActivity(),"Registration done",Toast.LENGTH_LONG).show();

                                Intent i =new Intent(getActivity(),MainActivity.class);
                                startActivity(i);

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getActivity(), "No Internet", Toast.LENGTH_SHORT).show();
                            }
                        }){
                            @Override
                            protected Map<String,String> getParams(){
                                Map<String,String> params = new HashMap<String, String>();
                                params.put("name",username);
                                params.put("pass",password);
                                params.put("email", email);


                                return params;
                            }



                        };

                        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                        requestQueue.add(stringRequest);


                    }
                    else
                    {
                        alert.showAlertDialog(getActivity(), "Login failed Incurrect Password..", "Username/Password is incorrect", false);

                    }

                }
                else {
                    alert.showAlertDialog(getActivity(), "Login failed..", "Username/Password is incorrect", false);
                }

            }
        });

        return v;
    }

}
