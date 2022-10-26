package com.example.quizbuilderv1;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.Intent;
import android.net.Uri;//URLs

public class MainActivity2 extends AppCompatActivity {

    Button btnStartQuizz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnStartQuizz = findViewById(R.id.btnStartQuizz);

        btnStartQuizz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("MainActivity");
                Bundle extras = new Bundle();
                extras.putString("Key", "Information to send, like variables");
                i.putExtras(extras);
                startActivityForResult(i,1);
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String s = extras.getString("Key");

        }
    }
}