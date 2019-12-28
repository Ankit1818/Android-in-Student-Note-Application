package com.example.noticeboard.Admin;


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
public class AdminViewStaffDetailFragment extends Fragment {
    View v;
    ListView listViewstaff;
    List<StaffDetailAdminModel> liststaff;


    public AdminViewStaffDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_admin_view_staff_detail, container, false);

        listViewstaff = v.findViewById(R.id.Adminstaffdelist);
        liststaff = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://decompressive-scrat.000webhostapp.com/NoticeBoard/staffdetailview.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        StaffDetailAdminModel  m1 = new StaffDetailAdminModel ();
                        String StaffEmail = object.getString("StaffEmail");
                        String StaffPassword = object.getString("StaffPassword");
                        String StaffID = object.getString("StaffID");
                        String StaffName = object.getString("StaffName");



                        m1.StaffEmail = StaffEmail;
                        m1.StaffPassword = StaffPassword;
                        m1.StaffID = StaffID;
                        m1.StaffName = StaffName;

                        liststaff.add(m1);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                MyAdapterStaffDetails adapter = new MyAdapterStaffDetails(getContext(),liststaff);
                listViewstaff.setAdapter(adapter);
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
        registerForContextMenu(listViewstaff);
        return v;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuItem staffm1=menu.add(0,3,0,"Update");
        MenuItem staffm2=menu.add(0,4,0,"Delete");

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {


        AdapterView.AdapterContextMenuInfo acm1 =(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

        int id=acm1.position;

        if(item.getItemId()==3)
        {
            StaffDetailAdminModel userstaff=liststaff.get(id);
            Intent istaff =new Intent(getActivity(),UpdateStaffDetailActivity.class);
            istaff.putExtra("StaffID",userstaff.getStaffID());
            istaff.putExtra("StaffName",userstaff.getStaffName());
            istaff.putExtra("StaffEmail",userstaff.getStaffEmail());
            istaff.putExtra("StaffPassword",userstaff.getStaffPassword());

            startActivity(istaff);

        }

        if(item.getItemId()==4)
        {
            StaffDetailAdminModel mode=liststaff.get(id);

            final String StaffID = mode.getStaffID();

            AlertDialog.Builder alert=new AlertDialog.Builder(getActivity());
            alert.setTitle("Delete");
            alert.setMessage("Want to delete it?");
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://decompressive-scrat.000webhostapp.com/NoticeBoard/volleyDeleteStaff.php", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

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
                            params.put("StaffID", StaffID);


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


        return super.onContextItemSelected(item);
    }

}
