package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class AdatokActivity extends AppCompatActivity {

    private String emailStr;
    private String targyak;
    private CollectionReference Hallgatok;
    private FirebaseFirestore mFirestore;

    private EditText nev;
    private EditText kar;
    private EditText szak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adatok);
        mFirestore = FirebaseFirestore.getInstance();
        nev = findViewById(R.id.nevBeviteliMezo);
        kar = findViewById(R.id.karBeviteliMezo);
        szak = findViewById(R.id.szakBeviteliMezo);

        emailStr = getIntent().getStringExtra("email");

        Hallgatok = mFirestore.collection("Hallgato");

        Hallgatok.whereEqualTo("email",emailStr).get().addOnSuccessListener(queryDocumentSnapshots -> {
            for(QueryDocumentSnapshot document : queryDocumentSnapshots){

                Hallgato hallgato = document.toObject(Hallgato.class);
                nev.setText(hallgato.getNev());
                kar.setText(hallgato.getKar());
                szak.setText(hallgato.getSzak());
                targyak = hallgato.getTargyak();

            }
        });
    }

    public void modositas(View view) {
        String nevStr = nev.getText().toString();
        String karStr = kar.getText().toString();
        String szakStr = szak.getText().toString();

        Hallgato halogato = new Hallgato(nevStr, emailStr, karStr, szakStr, targyak);
        Hallgatok.document(emailStr).set(halogato);
        finish();
    }

    public void torles(View view) {
        Hallgatok.document(emailStr).delete();
        finish();
    }
}