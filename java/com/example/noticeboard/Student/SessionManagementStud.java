package com.example.noticeboard.Student;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.example.noticeboard.AdminLoginActivity;
import com.example.noticeboard.Staff.MainActivityStaff;

import java.util.HashMap;

public class SessionManagementStud {
    // Shared Preferences
    SharedPreferences pref2;

    // Editor for Shared preferences
    Editor editor2;

    // Context
    Context _context2;

    // Shared pref mode
    int PRIVATE_MODE2 = 0;

    // Sharedpref file name
    private static final String PREF_NAME2 = "AndroidHivePrefss";

    // All Shared Preferences Keys
    private static final String IS_LOGIN_STUD= "IsLoggedIn";

    // User name (make variable public to access from outside)
    public static final String KEY_NAME2 = "name";

    // Email address (make variable public to access from outside)
    public static final String KEY_EMAIL2 = "email";

    // Constructor
    public SessionManagementStud(Context context){
        this._context2 = context;
        pref2 = _context2.getSharedPreferences(PREF_NAME2, PRIVATE_MODE2);
        editor2 = pref2.edit();
    }

    /**
     * Create login session
     * */
    public void createLoginSession2(String name, String email){
        // Storing login value as TRUE
        editor2.putBoolean(IS_LOGIN_STUD, true);

        // Storing name in pref
        editor2.putString(KEY_NAME2, name);

        // Storing email in pref
        editor2.putString(KEY_EMAIL2, email);

        // commit changes
        editor2.commit();
    }

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     * */
    public void checkLogin(){
        // Check login status
        if(!this.isLoggedInStud()){
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context2, MainActivityStudent.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            _context2.startActivity(i);
        }

    }



    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        // user name
        user.put(KEY_NAME2, pref2.getString(KEY_NAME2, null));

        // user email id
        user.put(KEY_EMAIL2, pref2.getString(KEY_EMAIL2, null));

        // return user
        return user;
    }

    /**
     * Clear session details
     * */
    public void logoutUserStud(){
        // Clearing all data from Shared Preferences
        editor2.clear();
        editor2.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(_context2, AdminLoginActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context2.startActivity(i);
    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedInStud(){
        boolean b=pref2.getBoolean(IS_LOGIN_STUD, false);
        if (b==true)
        {
            Intent i=new Intent(_context2,MainActivityStudent.class);
            _context2.startActivity(i);

        }

        return pref2.getBoolean(IS_LOGIN_STUD, false);
    }
}