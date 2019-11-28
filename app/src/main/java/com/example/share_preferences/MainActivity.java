package com.example.share_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//allow activities and applications to keep preferences in the form of key values pair similar to a map that will persist even when thw user close the application
//android stores share preferances setting as xml file in share pref folder under Data/data/packagename/Shared prefes/filename.xml
public class MainActivity extends AppCompatActivity {
EditText e1,e2;
Button b1,b2,b3,b4;
SharedPreferences pref;
String prefname="Mansi";
String s1,s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                pref=getSharedPreferences(prefname,MODE_PRIVATE);
                SharedPreferences.Editor edit1=pref.edit();
                edit1.putString("Name",s1);
                edit1.putInt("Pass",Integer.parseInt(s2));
                edit1.commit();
                Toast.makeText(MainActivity.this, "Save", Toast.LENGTH_SHORT).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                pref=getSharedPreferences(prefname,MODE_PRIVATE);
                SharedPreferences.Editor edit1=pref.edit();
                edit1.putString("Name",s1);
                edit1.putInt("Pass",Integer.parseInt(s2));
                edit1.commit();
                Toast.makeText(MainActivity.this, "Update", Toast.LENGTH_SHORT).show();

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                pref=getSharedPreferences(prefname,MODE_PRIVATE);
                String s11=pref.getString("Name","Mansi");
                String s12=String.valueOf(pref.getInt("Pass",100));
                e1.setText(s11);
                e2.setText(s12);
                Toast.makeText(MainActivity.this, "Fetch", Toast.LENGTH_SHORT).show();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                pref=getSharedPreferences(prefname,MODE_PRIVATE);
                SharedPreferences.Editor edit1=pref.edit();
                edit1.clear();
                e1.setText(" ");
                e2.setText(" ");
                edit1.commit();
            }
        });
    }
}
