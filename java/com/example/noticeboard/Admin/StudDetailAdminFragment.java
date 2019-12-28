package com.example.noticeboard.Admin;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
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
public class StudDetailAdminFragment extends Fragment {
    View v;
    ListView listView;
    List<StudDetailAdminModel> list;

    public StudDetailAdminFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_stud_detail_admin, container, false);
        listView = v.findViewById(R.id.StudDetaiAdminList);
        list = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://decompressive-scrat.000webhostapp.com/NoticeBoard/studDetailView.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        StudDetailAdminModel m1 = new StudDetailAdminModel();
                        String StudentLogID = object.getString("StudentLogID");
                        String StudentPassword = object.getString("StudentPassword");
                        String StudentID = object.getString("StudentID");
                        String StudentName	 = object.getString("StudentName");

                        String StudentEmail = object.getString("StudentEmail");
                        String StudentRollno = object.getString("StudentRollno");

                        m1.StudentLogID = StudentLogID;
                        m1.StudentPassword = StudentPassword;
                        m1.StudentID = StudentID;
                        m1.StudentName = StudentName;
                        m1.StudentEmail = StudentEmail;
                        m1.StudentRollno = StudentRollno;

                        list.add(m1);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                MyAdapterStudDetails adapter = new MyAdapterStudDetails(getContext(),list);
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

        MenuItem m1=menu.add(0,1,0,"Update");
        MenuItem m2=menu.add(0,2,0,"Delete");

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo acm =(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

        int id=acm.position;

        if(item.getItemId()==1)
        {
            StudDetailAdminModel user=list.get(id);
            Intent i =new Intent(getActivity(),UpdateStudDetailActivity.class);
            i.putExtra("studid",user.getStudentID());
            i.putExtra("studname",user.getStudentName());
            i.putExtra("studpassword",user.getStudentPassword());
            i.putExtra("studmail",user.getStudentEmail());
            i.putExtra("studrollno",user.getStudentRollno());
            startActivity(i);

        }

        if(item.getItemId()==2) {
           StudDetailAdminModel mode=list.get(id);

            final String StudentID = mode.getStudentID();


 AlertDialog.Builder alert=new AlertDialog.Builder(getActivity());
            alert.setTitle("Delete");
            alert.setMessage("Want to delete it?");
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://decompressive-scrat.000webhostapp.com/NoticeBoard/volleyDeleteStudent.php", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Intent i =new Intent(getActivity(),MainActivity.class);
                            startActivity(i);
                            Toast.makeText(getActivity(), "Record Delete Sucess..!", Toast.LENGTH_LONG).show();


                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("StudentID", StudentID);


                            return params;
                        }


                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                    requestQueue.add(stringRequest);


                   /* StudDetailAdminFragment fragment = new StudDetailAdminFragment();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();*/
                }
            });
            alert.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            alert.show();

    }






        return super.onContextItemSelected(item);
    }
}
