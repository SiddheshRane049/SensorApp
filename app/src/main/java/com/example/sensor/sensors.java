package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class sensors extends AppCompatActivity {
    private SensorManager sensorManager;
    private Sensor proximitySensor;
    private TextView textProximityValue;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);

        textProximityValue = findViewById(R.id.textProximityValue);

            sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);


            proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
            if (proximitySensor == null) {
                textProximityValue.setText("Proximity Sensor Not Available");
            } else {
                sensorManager.registerListener(proximitySensorListener, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
            }
        }

        private final SensorEventListener proximitySensorListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float proximityValue = event.values[0];

                textProximityValue.setText("Proximity Value: " +proximityValue);
            }


            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
        };

        @Override
        protected void onPause() {
            super.onPause();
            if (proximitySensor != null) {
                sensorManager.unregisterListener(proximitySensorListener);
            }
        }

    }