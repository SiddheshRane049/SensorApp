package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SGyro extends AppCompatActivity {
    private SensorManager sensorManager;
    private Sensor gyroscopeSensor;
    private TextView textGyroscopeValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sgyro);
        textGyroscopeValues = findViewById(R.id.textGyroscopeValues);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);


        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if (gyroscopeSensor == null) {

            textGyroscopeValues.setText("Gyroscope Sensor Not Available");
        } else {

            sensorManager.registerListener(gyroscopeSensorListener, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    private final SensorEventListener gyroscopeSensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            textGyroscopeValues.setText("Gyroscope Values (x, y, z): "
                    + String.format("%.2f, %.2f, %.2f", x, y, z));
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };

    @Override
    protected void onPause() {
        super.onPause();

        if (gyroscopeSensor != null) {
            sensorManager.unregisterListener(gyroscopeSensorListener);
        }
    }
}
