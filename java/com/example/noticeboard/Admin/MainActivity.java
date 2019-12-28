package com.example.noticeboard.Admin;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.noticeboard.R;

import java.util.HashMap;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FragmentManager FM;
    FragmentTransaction FT;
    private ImageView imgNavHeaderBg, imgProfile;
    private TextView txtName, txtWebsite;
   /* private static final String urlNavHeaderBg = "https://decompressive-scrat.000webhostapp.com/image/back.jpg";
    private static final String urlProfileImg = "https://decompressive-scrat.000webhostapp.com/image/it_icon.png";*/
    SessionManagement session;
    private Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        session = new SessionManagement(getApplicationContext());
        mHandler = new Handler();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView= (NavigationView) findViewById(R.id.shitstuff);

        View view = navigationView.getHeaderView(0);
        txtName = (TextView) view.findViewById(R.id.nev_txtnm);
        txtWebsite = (TextView) view.findViewById(R.id.nev_txtemail);
        imgNavHeaderBg = (ImageView) view.findViewById(R.id.nev_img_header_bg);
        imgProfile = (ImageView) view.findViewById(R.id.nev_imageView);
        loadNavHeader();



        FM= getSupportFragmentManager();
        FT= FM.beginTransaction();
        FT.replace(R.id.containerView, new TabFragment()).commit();


        //get sesson data
        HashMap<String, String> user = session.getUserDetails();

        // name
        String name = user.get(SessionManagement.KEY_NAME);

        // email
        String email = user.get(SessionManagement.KEY_EMAIL);

        // displaying user data
        Toast.makeText(getApplicationContext(), "Sesson Data :"+name+email, Toast.LENGTH_SHORT).show();
       /* lblName.setText(Html.fromHtml("Name: <b>" + name + "</b>"));
        lblEmail.setText(Html.fromHtml("Email: <b>" + email + "</b>"));*/



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                if (item.getItemId()==R.id.nav_item_inbox)
                {
                    FragmentTransaction fragmentTransaction1=FM.beginTransaction();
                    fragmentTransaction1.replace(R.id.containerView,new TabFragment()).commit();

                }
                if (item.getItemId()== R.id.nav_item_add_stud) {
                    FragmentTransaction fragmentTransaction= FM.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new AddStudentFragment()).commit();
                }
                if (item.getItemId()== R.id.nav_item_add_stff) {
                    FragmentTransaction fragmentTransaction= FM.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new AddStaffFragment()).commit();
                }
                if (item.getItemId()== R.id.nav_item_logout) {


                    Toast.makeText(MainActivity.this, "Logout..!", Toast.LENGTH_SHORT).show();
                    session.logoutUser();
                    finish();
                }


                return false;
            }
        });


        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();




        }



    private void loadNavHeader() {

        HashMap<String, String> user = session.getUserDetails();

        // name
        String name1 = user.get(SessionManagement.KEY_NAME);

        // email
        String email1 = user.get(SessionManagement.KEY_EMAIL);

        // displaying user data
        txtName.setText(Html.fromHtml("Name: <b>" + email1 + "</b>"));
        txtWebsite.setText(Html.fromHtml("Email: <b>" + name1 + "</b>"));

        /*// loading header background image
        Glide.with(this).load(urlNavHeaderBg)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgNavHeaderBg);
*/
        // Loading profile image
       /* Glide.with(this).load(R.mipmap.ic_not)
                .crossFade()
                .thumbnail(0.5f)
                .bitmapTransform(new CircleTransform(this))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgProfile);*/

        // showing dot next to notifications label
        /*  navigationView.getMenu().getItem(3).setActionView(R.layout.menu_dot);*/
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.admin_logout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.admin_logout1:
                Toast.makeText(getApplicationContext(), "admin Logout", Toast.LENGTH_LONG).show();
                session.logoutUser();
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
    }

}
