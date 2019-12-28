package com.example.noticeboard;

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
import com.example.noticeboard.Admin.DetailAdminModel;
import com.example.noticeboard.Admin.MainActivity;
import com.example.noticeboard.Admin.SessionManagement;
import com.example.noticeboard.Staff.MainActivityStaff;
import com.example.noticeboard.Staff.SessionManagementStaff;
import com.example.noticeboard.Student.MainActivityStudent;
import com.example.noticeboard.Student.SessionManagementStud;

import org.json.JSONArray;
import org.json.JSONObject;

public class AdminLoginActivity extends AppCompatActivity {
Button adminlogin;
EditText editnm,editpass;
    AlertDialogManager alert = new AlertDialogManager();



    // Session Manager Class
    SessionManagement session;
    SessionManagementStaff session1;
    SessionManagementStud session2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        session = new SessionManagement(getApplicationContext());
        session1 = new SessionManagementStaff(getApplicationContext());
        session2= new SessionManagementStud(getApplicationContext());

        Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), "User Login Status: " + session1.isLoggedInstaff(), Toast.LENGTH_LONG).show();
         session2.isLoggedInStud();

        editnm=findViewById(R.id.adminloginname);
        editpass=findViewById(R.id.adminloginpass);
        adminlogin=findViewById(R.id.adminlogin);
        adminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String username = editnm.getText().toString();
                final String password = editpass.getText().toString();

                if(username.trim().length() > 0 && password.trim().length() > 0) {

                    StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://decompressive-scrat.000webhostapp.com/NoticeBoard/AllLogin.php?AdminEmail=" + username + "&AdminPassword=" + password, new Response.Listener<String>() {
                    @Override

                    public void onResponse(String response) {
                        try {



                                if(response.equals("0"))
                                {
                                    alert.showAlertDialog(AdminLoginActivity.this, "Login failed..", "Username/Password is incorrect", false);

                                    Toast.makeText(getApplicationContext(), "fail", Toast.LENGTH_LONG).show();
                                }
                                else {

                                    JSONArray jsonArray = new JSONArray(response);

                                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                                    String code = jsonObject.getString("code");
                                    if(code.equals("admin"))
                                    {

                                        DetailAdminModel md=new DetailAdminModel();
                                        String AdminID=jsonObject.getString("AdminID");
                                        String AdminName=jsonObject.getString("AdminName");
                                        String AdminEmail=jsonObject.getString("AdminEmail");
                                        String AdminPassword=jsonObject.getString("AdminPassword");
                                        md.AdminID = AdminID;
                                        md.AdminName = AdminName;
                                        md.AdminEmail = AdminEmail;
                                        md.AdminPassword = AdminPassword;

                                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                                        session.createLoginSession(AdminEmail,AdminName );
                                        Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_LONG).show();
                                        //  i.putExtras(bundle);
                                        AdminLoginActivity.this.finish();
                                        startActivity(i);

                                    }
                                    else if (code.equals("staff"))
                                    {
                                        String StaffID=jsonObject.getString("StaffID");
                                        String StaffName=jsonObject.getString("StaffName");
                                        String StaffPassword=jsonObject.getString("StaffPassword");
                                        String StaffEmail=jsonObject.getString("StaffEmail");


                                        session1.createLoginSession1(StaffEmail,StaffName );

                                        Intent i = new Intent(getApplicationContext(), MainActivityStaff.class);
                                        startActivity(i);
                                        Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_LONG).show();
                                        finish();

                                        Toast.makeText(AdminLoginActivity.this, "staff login success", Toast.LENGTH_SHORT).show();
                                    }
                                    else if (code.equals("stud"))
                                    {
                                        String StudentID=jsonObject.getString("StudentID");
                                        String StudentName=jsonObject.getString("StudentName");
                                        String StudentLogID=jsonObject.getString("StudentLogID");
                                        String StudentPassword=jsonObject.getString("StudentPassword");
                                        String StudentEmail=jsonObject.getString("StudentEmail");
                                        String StudentRollno=jsonObject.getString("StudentRollno");
                                        session2.createLoginSession2(StudentEmail,StudentName );
                                        Intent i = new Intent(getApplicationContext(), MainActivityStudent.class);
                                        startActivity(i);
                                        Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_LONG).show();
                                        finish();
                                        Toast.makeText(AdminLoginActivity.this, "Stud login success", Toast.LENGTH_SHORT).show();
                                    }

                                    }




                                }
                        catch (Exception e) {
                            e.printStackTrace();
                        }

                           //session.createLoginSession("Android rajiya", "narejarajiya1154@gmail.com");

                            //String MainActivity





                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AdminLoginActivity.this, "No Internet", Toast.LENGTH_SHORT).show();
                    }



                });
                RequestQueue rq = Volley.newRequestQueue(AdminLoginActivity.this);
                rq.add(stringRequest);
            }
                else {
                alert.showAlertDialog(AdminLoginActivity.this, "Login failed..", "Username/Password is incorrect", false);
            }



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
