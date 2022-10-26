package com.example.quizbuilderv1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.Intent;
import android.net.Uri;//URLs


public class MainActivity extends AppCompatActivity {

    //Creating Controls
    Button btnChoice1, btnChoice2, btnChoice3, btnChoice4;
    TextView textViewCounts, textViewQuestion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Conecting
        btnChoice1 = findViewById(R.id.btnChoice1);
        btnChoice2 = findViewById(R.id.btnChoice2);
        btnChoice3 = findViewById(R.id.btnChoice3);
        btnChoice4 = findViewById(R.id.btnChoice4);
        textViewCounts = findViewById(R.id.textViewCounts);
        textViewQuestion = findViewById(R.id.textViewQuestion);

        //Events
        btnChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://www.globo.com"));
            startActivity(i);
            }
        });

        btnChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("MainActivity2");
                Bundle extras = new Bundle();
                extras.putString("Key", "Information to send, like variables");
                i.putExtras(extras);
                //startActivity(i,extras);
                startActivityForResult(i,1);
            }
        });
    }//end Oncreate













}//end Main