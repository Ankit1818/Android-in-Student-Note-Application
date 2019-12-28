package com.example.noticeboard.Admin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.noticeboard.R;

import java.util.HashMap;
import java.util.Map;

public class UpdateStaffDetailActivity extends AppCompatActivity {
    EditText editupstaffid,editupstaffname,editupstaffemail,editupstaffpass;
    Button btnupStaffDetail1;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pd = new ProgressDialog(getApplicationContext());
        pd.setMessage("please wait...");
        setContentView(R.layout.activity_update_staff_detail);
        editupstaffid=findViewById(R.id.upstaffid);
        editupstaffname=findViewById(R.id.upstaffname);
        editupstaffemail=findViewById(R.id.upstaffemail);
        editupstaffpass=findViewById(R.id.upstaffpass);

        btnupStaffDetail1=findViewById(R.id.btnupstaffDetail);

        Bundle bundle1=getIntent().getExtras();

        editupstaffid.setText(bundle1.getString("StaffID"));
        editupstaffname.setText(bundle1.getString("StaffName"));
        editupstaffemail.setText(bundle1.getString("StaffEmail"));
        editupstaffpass.setText(bundle1.getString("StaffPassword"));

        btnupStaffDetail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String txtupstaffid=editupstaffid.getText().toString().trim();
                final String txpstaffname=editupstaffname.getText().toString().trim();
                final String txtupstaffemail=editupstaffemail.getText().toString().trim();
                final String txtupstaffpass=editupstaffpass.getText().toString().trim();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://decompressive-scrat.000webhostapp.com/NoticeBoard/volleyUpdateStaff.php", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(getApplicationContext(),"Update Sucessfully..!",Toast.LENGTH_LONG).show();

                        Intent i =new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UpdateStaffDetailActivity.this, "No Internet", Toast.LENGTH_SHORT).show();
                    }
                }){
                    @Override
                    protected Map<String,String> getParams(){
                        Map<String,String> params = new HashMap<String, String>();
                        params.put("StaffID",txtupstaffid);
                        params.put("StaffName",txpstaffname);
                        params.put("StaffEmail", txtupstaffemail);
                        params.put("StaffPassword", txtupstaffpass);


                        return params;
                    }



                };

                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);

            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();
        if(id==android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
