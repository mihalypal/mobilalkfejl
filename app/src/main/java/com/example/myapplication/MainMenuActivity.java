package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainMenuActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainMenuActivity.class.getName();
    private static final String PREF_KEY = MainMenuActivity.class.getPackage().toString();
    private FirebaseUser user;

    private SharedPreferences preferences;

    private String emailStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null) {
            Log.d(LOG_TAG, "Authenticated user!");
        } else {
            Log.d(LOG_TAG, "Unauthenticated user!");
            finish();
        }

        preferences = getSharedPreferences(PREF_KEY, MODE_PRIVATE);
        emailStr = preferences.getString("email", "");
        String password = preferences.getString("password", "");
        //Log.i(LOG_TAG, email + ", " + password);
    }

    public void changeData(View view) {
        Intent intent = new Intent(this, AdatokActivity.class);
        intent.putExtra("email", emailStr);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}