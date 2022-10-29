package com.example.quizbuilderv1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.Intent;
import android.net.Uri;//URLs
import android.view.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;


public class MainActivity extends AppCompatActivity {

    //Creating Controls
    Button btnChoice1, btnChoice2, btnChoice3, btnChoice4;
    TextView textViewCounts, textViewQuestion;

    ArrayList<String> keyA = new ArrayList<String>();
    Map<String,String> map = new HashMap<String,String>();//create map

    public int getRandomNumber (int min, int max){
return (int) ((Math.random() * (max - min))+min);
    };

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


        String str = null;
        BufferedReader br = null;
        try {
            InputStream is = getResources().openRawResource(R.raw.quiz);
            br = new BufferedReader(new InputStreamReader(is));
            System.out.println("File in RAW is open");

//            ArrayList<String> keyA = new ArrayList<String>();
            ArrayList<String> valueA = new ArrayList<String>();
            int i = 1;

            while ((str = br.readLine()) != null)  //just for testing read line
            {
                System.out.println(str);

                for (String actualElement : str.split(":") )
                {

                    String i1 = new String(actualElement);

                    if ( i % 2 == 0) {
                        valueA.add(i1);
                    }
                    else{
                        keyA.add(i1);
                    }
                    i++;


                }

            }
            System.out.println("The content of the Key Arraylist is: " + keyA);
            System.out.println("The content of the Valule Arraylist is: " + valueA);

//            Map<String,String> map = new HashMap<String,String>();//create map

            for (int j = 0; j <= 9; j++){
                //map.put("Key", "Value");
                String arrayIndexKey = keyA.get(j);
                String arrayIndexValue = valueA.get(j);
                map.put(arrayIndexKey, arrayIndexValue);
            }
            System.out.println("Map: "+map);

            is.close();
            System.out.println("File in RAW is closed");
        } catch (IOException e) {
            e.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }

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
            public void onClick(View v)
            {


//                String str = null;
//                BufferedReader br = null;
//                try {
//                    InputStream is = getResources().openRawResource(R.raw.quiz);
//                    br = new BufferedReader(new InputStreamReader(is));
//                    System.out.println("File in RAW is open");
//
//                    ArrayList<String> keyA = new ArrayList<String>();
//                    ArrayList<String> valueA = new ArrayList<String>();
//                    int i = 1;
//
//                    while ((str = br.readLine()) != null)  //just for testing read line
//                    {
//                        System.out.println(str);
//
//                        for (String actualElement : str.split(":") )
//                        {
//
//                            String i1 = new String(actualElement);
//
//                            if ( i % 2 == 0) {
//                                valueA.add(i1);
//                            }
//                            else{
//                                keyA.add(i1);
//                            }
//                            i++;
//
//
//                        }
//
//                    }
//                    System.out.println("The content of the Key Arraylist is: " + keyA);
//                    System.out.println("The content of the Valule Arraylist is: " + valueA);
//
//                    Map<String,String> map = new HashMap<String,String>();//create map
//
//                    for (int j = 0; j <= 9; j++){
//                        //map.put("Key", "Value");
//                        String arrayIndexKey = keyA.get(j);
//                        String arrayIndexValue = valueA.get(j);
//                        map.put(arrayIndexKey, arrayIndexValue);
//                    }
//                    System.out.println("Map: "+map);
//
//                    is.close();
//                    System.out.println("File in RAW is closed");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }catch(Exception e) {
//                    e.printStackTrace();
//                }
            }
        });//End Button

        btnChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
//                String arrayIndexKey = keyA.get(j);
//                String arrayIndexKey = Arrays.toString(keyA);
                String arrayIndexKey2 = keyA.get(1);
            textViewQuestion.setText(arrayIndexKey2);

            String rightChoice = map.get(arrayIndexKey2);
            btnChoice1.setText(rightChoice);

            int random = getRandomNumber(1,4);
            System.out.println("Random number is: "+random);
                if (random == 1)
                {
                    btnChoice1.setBackgroundColor(100);
                }
                else {
                    btnChoice2.setBackgroundColor(2);
                }
            }


        });
    }//end Oncreate

}//end Main

