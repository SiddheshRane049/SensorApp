package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;


public class Spressure extends AppCompatActivity {
    private SensorManager sensorManager;
    private Sensor pressureSensor;
    private TextView textPressureValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spressure);

        textPressureValue = findViewById(R.id.textPressureValue);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        pressureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        if (pressureSensor == null) {
            textPressureValue.setText("Pressure Sensor Not Available");
        } else {
            sensorManager.registerListener(pressureSensorListener, pressureSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    private final SensorEventListener pressureSensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float pressureValue = event.values[0];

            textPressureValue.setText("Pressure Value: " + pressureValue + " hPa");
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        if (pressureSensor != null) {
            sensorManager.unregisterListener(pressureSensorListener);
        }
    }
}
