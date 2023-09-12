package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

     Button jett;
    //private ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //imageView2 =findViewById(R.id.imageView2);

        jett = findViewById(R.id.jett);

       jett.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Intent intent = new Intent(MainActivity.this,Sensorns_list.class);
               startActivity(intent);
           }
       });

        };
    }
