package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getName();
    private static final String PREF_KEY = MainActivity.class.getPackage().toString();
    private static final int SECRET_KEY = 99;

    EditText userNameET;
    EditText passwordET;

    private SharedPreferences preferences;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(PREF_KEY, MODE_PRIVATE);
        mAuth = FirebaseAuth.getInstance();

        userNameET = findViewById(R.id.editTextUserName);
        passwordET = findViewById(R.id.editTextPassword);

        Log.i(LOG_TAG, "OnCreate");
    }

    public void login(View view) {
        String username = userNameET.getText().toString();
        String password = passwordET.getText().toString();

        // Log.i(LOG_TAG, "Bejelentkezett: " + username + ", jelszó: " + password);
        mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d(LOG_TAG, "User logged in successfully");
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("email", username);
                    editor.putString("password", password);
                    editor.apply();
                    useApplication();
                } else {
                    Log.d(LOG_TAG, "User login fail");
                    Toast.makeText(MainActivity.this, "User login fail: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void useApplication() {
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }

    public void register(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        intent.putExtra("SECRET_KEY", SECRET_KEY);
        // TODO
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(LOG_TAG, "OnStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(LOG_TAG, "OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(LOG_TAG, "OnDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("userName", userNameET.getText().toString());
        editor.putString("password", passwordET.getText().toString());
        editor.apply();

        Log.i(LOG_TAG, "OnPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LOG_TAG, "OnPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(LOG_TAG, "OnRestart");
    }
}