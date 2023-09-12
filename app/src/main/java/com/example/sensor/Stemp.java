package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import android.os.Bundle;

public class Stemp extends AppCompatActivity {
    private SensorManager sensorManager;
    private Sensor temperatureSensor;
    private TextView textTemperatureValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stemp);

        textTemperatureValue = findViewById(R.id.textTemperatureValue);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        temperatureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if (temperatureSensor == null) {
            textTemperatureValue.setText("Temperature Sensor Not Available");
        } else {
            sensorManager.registerListener(temperatureSensorListener, temperatureSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    private final SensorEventListener temperatureSensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float temperatureValue = event.values[0];

            textTemperatureValue.setText("Temperature Value: " + temperatureValue + " °C");
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        if (temperatureSensor != null) {
            sensorManager.unregisterListener(temperatureSensorListener);
        }
    }
}


