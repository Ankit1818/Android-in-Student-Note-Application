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

public class UpdateStudDetailActivity extends AppCompatActivity {
    EditText editupstuid,editupstudname,editupstudRollno,editupstudemail,editupstudpass;
    Button btnupStudDetail1;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_stud_detail);
        pd = new ProgressDialog(getApplicationContext());
        pd.setMessage("please wait...");
        editupstuid=findViewById(R.id.upstuid);
        editupstudname=findViewById(R.id.upstudname);
        editupstudRollno=findViewById(R.id.upeditstudRollno);
        editupstudemail=findViewById(R.id.upstudemail);
        editupstudpass=findViewById(R.id.upstudpass);

        btnupStudDetail1=findViewById(R.id.btnupstudDetail);
        Bundle bundle =getIntent().getExtras();


        editupstuid.setText(bundle.getString("studid"));
        editupstudname.setText(bundle.getString("studname"));
        editupstudemail.setText(bundle.getString("studmail"));
        editupstudpass.setText(bundle.getString("studpassword"));
        editupstudRollno.setText(bundle.getString("studrollno"));



        btnupStudDetail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String txtupstuid=editupstuid.getText().toString().trim();
                final String txpupstudname=editupstudname.getText().toString().trim();
                final String txtupstudpass=editupstudpass.getText().toString().trim();
                final String txtupstudRollno=editupstudRollno.getText().toString().trim();
                final String txtStudentLogID=txpupstudname+"@"+txtupstudRollno;
                final String txtStudentEmail=editupstudemail.getText().toString().trim();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://decompressive-scrat.000webhostapp.com/NoticeBoard/volleyUpdateStudent.php", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(getApplicationContext(),"Update Sucessfully..!",Toast.LENGTH_LONG).show();

                        Intent i =new Intent(getApplicationContext(),MainActivity.class);
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
                        params.put("StudentID",txtupstuid);
                        params.put("StudentName",txpupstudname);
                        params.put("StudentPassword", txtupstudpass);
                        params.put("StudentRollno", txtupstudRollno);
                        params.put("StudentLogID", txtStudentLogID);
                        params.put("StudentEmail", txtStudentEmail);

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
