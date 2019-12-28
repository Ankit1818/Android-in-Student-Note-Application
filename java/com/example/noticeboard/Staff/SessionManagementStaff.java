package com.example.noticeboard.Staff;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.example.noticeboard.Admin.MainActivity;
import com.example.noticeboard.AdminLoginActivity;

import java.util.HashMap;

public class SessionManagementStaff {
    // Shared Preferences
    SharedPreferences pref1;

    // Editor for Shared preferences
    Editor editor1;

    // Context
    Context _context1;

    // Shared pref mode
    int PRIVATE_MODE1 = 0;

    // Sharedpref file name
    private static final String PREF_NAME1 = "AndroidHivePrefs";

    // All Shared Preferences Keys
    private static final String IS_LOGIN_STAFF= "IsLoggedIn";

    // User name (make variable public to access from outside)
    public static final String KEY_NAME1 = "name";

    // Email address (make variable public to access from outside)
    public static final String KEY_EMAIL1 = "email";

    // Constructor
    public SessionManagementStaff(Context context){
        this._context1 = context;
        pref1 = _context1.getSharedPreferences(PREF_NAME1, PRIVATE_MODE1);
        editor1 = pref1.edit();
    }

    /**
     * Create login session
     * */
    public void createLoginSession1(String name, String email){
        // Storing login value as TRUE
        editor1.putBoolean(IS_LOGIN_STAFF, true);

        // Storing name in pref
        editor1.putString(KEY_NAME1, name);

        // Storing email in pref
        editor1.putString(KEY_EMAIL1, email);

        // commit changes
        editor1.commit();
    }

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     * */
    public void checkLogin(){
        // Check login status
        if(!this.isLoggedInstaff()){
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context1, MainActivityStaff.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            _context1.startActivity(i);
        }

    }



    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        // user name
        user.put(KEY_NAME1, pref1.getString(KEY_NAME1, null));

        // user email id
        user.put(KEY_EMAIL1, pref1.getString(KEY_EMAIL1, null));

        // return user
        return user;
    }

    /**
     * Clear session details
     * */
    public void logoutUserStaff(){
        // Clearing all data from Shared Preferences
        editor1.clear();
        editor1.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(_context1, AdminLoginActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context1.startActivity(i);
    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedInstaff(){
        boolean b=pref1.getBoolean(IS_LOGIN_STAFF, false);
        if (b==true)
        {
            Intent i=new Intent(_context1,MainActivityStaff.class);
            _context1.startActivity(i);

        }

        return pref1.getBoolean(IS_LOGIN_STAFF, false);
    }
}