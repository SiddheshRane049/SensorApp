package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sensorns_list extends AppCompatActivity {
    private Button button, button3, button4, button5, button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensorns_list);

        button =  findViewById(R.id.button);

        button3 = findViewById(R.id.button3);

        button4 = findViewById(R.id.button4);

        button5 = findViewById(R.id.button5);

        button6 = findViewById(R.id.button6);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Sensorns_list.this,sensors.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sensorns_list.this,Spressure.class);
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sensorns_list.this,Stemp.class);
                startActivity(intent);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(Sensorns_list.this,SGyro.class);
               startActivity(intent);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sensorns_list.this,Sacceloro.class);
                startActivity(intent);
            }
        });
    }
}