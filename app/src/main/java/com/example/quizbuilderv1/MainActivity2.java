package com.example.quizbuilderv1;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.Intent;
import android.net.Uri;//URLs
import java.util.*;

public class MainActivity2 extends AppCompatActivity {

    Button btnStartQuizz;
    TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnStartQuizz = findViewById(R.id.btnStartQuizz);
        textViewResult = findViewById(R.id.textViewResult);

        btnStartQuizz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("MainActivity");
                Bundle extras = new Bundle();
                extras.putString("Key", "Information to send, like variables");
                i.putExtras(extras);
            //    startActivityForResult(i,1);
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String s = extras.getString("Key");
            textViewResult.setText(s);


        }
    }
}

////Array List Demonstration
//import android.app.Activity;
//        import android.os.*;
//        import android.view.*;
//        import android.app.*;
//        import java.util.ArrayList;
//public class MainActivity extends Activity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ArrayList<Object> arl = new ArrayList<Object>();
//        Integer i1 = new Integer(10);
//        Integer i2 = new Integer(20);
//        Integer i3 = new Integer(30);
//        Integer i4 = new Integer(40);
//        String s1 = "my string";
//        System.out.println("The conent of the Arraylist is: " + arl);
//        System.out.println("The size of the Arraylist is: " + arl.size());
//        arl.add(i1);
//        arl.add(i2);
//        arl.add(i3);
//        System.out.println("The conent of the Arraylist is: " + arl);
//        System.out.println("The size of the Arraylist is: " + arl.size());
//        arl.add(i1);
//        arl.add(i2);
//        arl.add(i3);
//        arl.add(i4);
//        Integer i5 = new Integer(50);
//        arl.add(i5);
//        System.out.println("The conent of the Arraylist is: " + arl);
//        System.out.println("The size of the Arraylist is: " + arl.size());
//        arl.remove(3);
//        System.out.println("The conent of the Arraylist is: " + arl);
//        System.out.println("The size of the Arraylist is: " + arl.size());
//        ArrayList<Object> a=new ArrayList<Object>();//a new list
//        a = (ArrayList<Object>)arl.clone();
//        System.out.println("The content of clone A is: " + a);
//        System.out.println("The size arrayList A is: "+a.size());
//        System.out.println("The content of arrayList B is: "+arl);
//        System.out.println("The size of arrayList B is: "+arl.size());
//    }//end onCreate
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//// Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//// Handle action bar item clicks here. The action bar will
//// automatically handle clicks on the Home/Up button, so long
//// as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
////noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//}





///A hash map is a data structure that uses a mathematical hash function
////to map identifying value, known as keys, to associate values
////e.g. mapping a name to a telephone number
//        import android.app.Activity;
//        import android.os.*;
//        import android.view.*;
//        import android.widget.*;
//        import java.util.HashMap;
//        import java.util.Map;
//        import java.util.Iterator;
//        import android.content.*;
//public class MainActivity extends Activity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Map<String,String> map = new HashMap<String,String>();//create map
//        map.put("Color1","Red");//place key and associate data in map
//        map.put("Color2","Blue");
//        map.put("Color3","Green");
//        map.put("Color4","White");
//        Iterator<String> myIterator=map.values().iterator();//create iterator
//        Context context = getApplicationContext();
//        while(myIterator.hasNext())//display colors using toast
//        {
////Toast.makeText(getBaseContext(),myIterator.next(),Toast.LENGTH_SHORT).show();
//            CharSequence text = myIterator.next();
//            int duration = Toast.LENGTH_LONG;
//            Toast toast = Toast.makeText(context,text,duration);
//            toast.show();
//        }//end while
//        map.get("Color1");//to take a key and grab an associate value back
//    }//end onCreate

//    //Demo of an Internal Write, Internal Read, and a res/raw read (read only)
//// To create a RAW folder: Right click on app. click 'new' on popup then click on android
//    resource director
//// (a new window will be appear) change resource type to raw - Create a text file
//"text.txt" with content and
//// place it in the raw folder.
//// It is usually best to let the OS decide where to store your files is Res/raw is not
//        being used.
//        package com.example.iome;
//        import androidx.appcompat.app.AppCompatActivity;
//        import android.os.*;
//        import android.widget.*;
//        import android.view.*;
//        import java.io.*;
//public class MainActivity extends AppCompatActivity {
//    Button btnWriteInternal;
//    Button btnReadInternal;
//    Button btnReadInternalRaw;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        btnWriteInternal = findViewById(R.id.btnWriteInternal);
//        btnReadInternal = findViewById(R.id.btnReadInternal);
//        btnReadInternalRaw = findViewById(R.id.btnReadInternalRaw);
////WRITE to INTERNAL storage
//        btnWriteInternal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                try {
////FileOutputStream fileout=openFileOutput("mytextfile.txt",
//                    MODE_PRIVATE);
//                    FileOutputStream fileout=openFileOutput("mytextfile.txt",
//                            MODE_APPEND);
//                    OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
//                    System.out.println("File open for write");
//                    outputWriter.write("I woz here!");
//                    outputWriter.close();
////display file saved message
//                    System.out.println("File saved and closed");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }//end onClick
//        });////end btn Listener
////READ INTERNAL
//        btnReadInternal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final int READ_BLOCK_SIZE = 100;
//                try {
//                    FileInputStream fileIn=openFileInput("mytextfile.txt");
//                    InputStreamReader InputRead= new InputStreamReader(fileIn);
//                    char[] inputBuffer= new char[READ_BLOCK_SIZE];
//                    String s="";
//                    int charRead;
//                    while ((charRead=InputRead.read(inputBuffer))>0) {
//// char to string conversion
//                        String readstring=String.copyValueOf(inputBuffer,0,charRead);
//                        s +=readstring;
//                    }
//                    InputRead.close();
//                    System.out.println(s);
////Toast.makeText(getBaseContext(),
//                    s,Toast.LENGTH_SHORT).show();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }//end onClick
//        });//end btn listener
////READ INTERNAL using RAW & Buffered Reader - note res/raw is read only in
//        Android
//        btnReadInternalRaw.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String str = null;
//                BufferedReader br = null;
//                try {
//                    InputStream is = getResources().openRawResource(R.raw.text);
//                    br = new BufferedReader(new InputStreamReader(is));
//                    System.out.println("File in RAW is open");
//                    while ((str = br.readLine()) != null) {
//                        System.out.println(str);
//                    }
//                    is.close();
//                    System.out.println("File in RAW is closed");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }catch(Exception e){
//                    e.printStackTrace();
//                }
//            }
//        });//end btn Listener
//    }//end onCreate