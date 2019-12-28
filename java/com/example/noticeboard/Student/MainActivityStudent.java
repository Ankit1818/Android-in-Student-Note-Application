package com.example.noticeboard.Student;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.example.noticeboard.R;

public class MainActivityStudent extends AppCompatActivity {
    FragmentManager FMstud;
    FragmentTransaction FTstud;
    SessionManagementStud session2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_student);
        Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbarStud);
        setSupportActionBar(toolbar1);
        FMstud= getSupportFragmentManager();
        FTstud= FMstud.beginTransaction();
        FTstud.replace(R.id.containerViewStud, new TabFragmentStudent()).commit();

session2=new SessionManagementStud(getApplicationContext());

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.stud_logout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.stud_logout:
                Toast.makeText(getApplicationContext(), "Item 1 Selected Logout", Toast.LENGTH_LONG).show();
                session2.logoutUserStud();
                return true;
            case R.id.stud_fev:
                Toast.makeText(getApplicationContext(), "Item 2 Selected", Toast.LENGTH_LONG).show();
                return true;
                /*
            case R.id.item3:
                Toast.makeText(getApplicationContext(),"Item 3 Selected",Toast.LENGTH_LONG).show();
                return true;*/
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
