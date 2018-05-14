package com.example.henry.a52sensores_acelermetro;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private Sensor mysensor;
    private SensorManager senman;
    TextView ejex,ejey,ejez,cont;
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        senman = (SensorManager) getSystemService(SENSOR_SERVICE);
        mysensor=senman.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        ejex = findViewById(R.id.ejex);
        ejey = findViewById(R.id.ejey);
        ejez =  findViewById(R.id.ejez);
        cont = findViewById(R.id.tvpasos);

        senman.registerListener(this,mysensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        ejex.setText("X:"+event.values[0]);
        ejey.setText("Y:"+event.values[1]);
        ejez.setText("Z:"+event.values[2]);
        //contador++;
        //cont.setText(contador);


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
//hacer nada
    }
}
