package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class Sacceloro extends AppCompatActivity {
    private SensorManager sensorManager;
    private Sensor accelerometerSensor;
    private TextView textAccelerometerValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sacceloro);
        textAccelerometerValues = findViewById(R.id.textAccelerometerValues);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (accelerometerSensor == null) {
            textAccelerometerValues.setText("Accelerometer Sensor Not Available");
        } else {
            sensorManager.registerListener(accelerometerSensorListener, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    private final SensorEventListener accelerometerSensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float xValue = event.values[0];
            float yValue = event.values[1];
            float zValue = event.values[2];

            textAccelerometerValues.setText("Accelerometer Values:\nX: " + xValue + "\nY: " + yValue + "\nZ: " + zValue);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        if (accelerometerSensor != null) {
            sensorManager.unregisterListener(accelerometerSensorListener);
        }
    }
}

