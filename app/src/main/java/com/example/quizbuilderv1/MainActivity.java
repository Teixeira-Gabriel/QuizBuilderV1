package com.example.quizbuilderv1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.Intent;
import android.net.Uri;//URLs
import android.view.*;
import java.io.*;
import java.util.StringTokenizer;


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
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                Bundle extras = new Bundle();
                extras.putString("Key", "Information to send, like variables");
                i.putExtras(extras);
                startActivity(i,extras);
                //registerForActivityResult(i,1);
            }
        });

        btnChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String str = null;
                BufferedReader br = null;
                try {
                    InputStream is = getResources().openRawResource(R.raw.quiz);
                    br = new BufferedReader(new InputStreamReader(is));
                    System.out.println("File in RAW is open");
                    while ((str = br.readLine()) != null) {
                        System.out.println(str);

                        //StringTokenizer
                        StringTokenizer stringTokenizer = new StringTokenizer(str);
                        while (stringTokenizer.hasMoreTokens()){
                            System.out.println(" "+stringTokenizer.nextToken(":"));
                        }
                    }
                    is.close();
                    System.out.println("File in RAW is closed");
                } catch (IOException e) {
                    e.printStackTrace();
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }//end Oncreate

//File Reading



}//end Main