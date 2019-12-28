package com.example.noticeboard.Staff;

import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.noticeboard.Admin.SessionManagement;
import com.example.noticeboard.R;

import java.util.HashMap;

public class MainActivityStaff extends AppCompatActivity {
    FragmentManager FMs;
    FragmentTransaction FTs;
    SessionManagementStaff session1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_staff);
        Toolbar toolbar = (Toolbar) findViewById(R.id.stafftoolbar);
        setSupportActionBar(toolbar);
        FMs= getSupportFragmentManager();
        FTs= FMs.beginTransaction();
        FTs.replace(R.id.staffcontainerView, new TabFragmentStaff()).commit();

        session1 = new SessionManagementStaff(getApplicationContext());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.staff_logout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.staff_logout:
                Toast.makeText(getApplicationContext(),"Item 1 Selected Logout",Toast.LENGTH_LONG).show();
                session1.logoutUserStaff();
                return true;
           /* case R.id.item2:
                Toast.makeText(getApplicationContext(),"Item 2 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.item3:
                Toast.makeText(getApplicationContext(),"Item 3 Selected",Toast.LENGTH_LONG).show();
                return true;*/
            default:
                return super.onOptionsItemSelected(item);
    }
}}