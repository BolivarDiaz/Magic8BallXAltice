package com.example.bolivar.magic8ballx;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class JugarActivity extends AppCompatActivity implements SensorEventListener,View.OnClickListener {

// variables

    float valores[]=new float[3];
    int vz;
    boolean respondiendo;
    boolean portrait;
    TextView resultado;
    int f;
    SensorManager sensorManager;
    Sensor sensor;
    MediaPlayer mp;
    Button botonnosensor;
    final long tiempo_respuesta=4000; //tiempo que tarda en recibir la respuesta


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        respondiendo=false;
       mp=MediaPlayer.create(this,R.raw.magicsound);


        // bloqueando orientacion de la pantalla
        if(getRotation(getApplicationContext()).equals("vertical")){ //es vertical o portrait.
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            portrait=true;

        }else{ // es horizontal o landscape.
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            portrait=false;
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);
        Typeface fuente1= Typeface.createFromAsset(getAssets(),"myfonts/chpfire.ttf");

        resultado=findViewById(R.id.iniciopreguntatext);
        resultado.setTypeface(fuente1);

       // efectos de movimiento con sensor

        String servicio = Context.SENSOR_SERVICE;
        sensorManager = (SensorManager) getSystemService(servicio);

        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI);

        if(MainActivity.sensor) {

            Toast.makeText(this, R.string.toast_consensor, Toast.LENGTH_SHORT).show();
        }else{
            // sin sensor
            Toast.makeText(this, R.string.toast_sinsensor, Toast.LENGTH_SHORT).show();
           botonnosensor=findViewById(R.id.boton_nosensor);

            botonnosensor.setOnClickListener(this);




        }







    }

// eventos del boton (sin sensor)
    @Override
    public void onClick(View view) {

        if(respondiendo==false) {
            resultado.setText("");
            respondiendo = true;

            if (MainActivity.sonido) {
                mp.start();
            }

            new CountDownTimer(tiempo_respuesta, 1000) {


                @Override
                public void onTick(long l) {
                    // do nothing
                }

                @Override
                public void onFinish() {
                    int numero = (int) (Math.random() * 14) + 1;

                    switch (numero){


                        case 1:
                            resultado.setText(R.string.respuesta1);
                            break;
                        case 2:
                            resultado.setText(R.string.respuesta2);
                            break;
                        case 3:
                            resultado.setText(R.string.respuesta3);
                            break;
                        case 4:
                            resultado.setText(R.string.respuesta4);
                            break;
                        case 5:
                            resultado.setText(R.string.respuesta5);
                            break;
                        case 6:
                            resultado.setText(R.string.respuesta6);
                            break;
                        case 7:
                            resultado.setText(R.string.respuesta7);

                            break;
                        case 8:
                            resultado.setText(R.string.respuesta8);
                            break;
                        case 9:
                            resultado.setText(R.string.respuesta9);
                            break;
                        case 10:
                            resultado.setText(R.string.respuesta10);
                            break;
                        case 11:
                            resultado.setText(R.string.respuesta11);
                            break;
                        case 12:
                            resultado.setText(R.string.respuesta12);
                            break;
                        case 13:
                            resultado.setText(R.string.respuesta13);
                            break;
                        case 14:
                            resultado.setText(R.string.respuesta14);
                            break;

                    }
                    respondiendo = false;
                }
            }.start();

        }
    }

// reunudando y deteniendo sensores

    @Override
    protected void onPause() {


            super.onPause();
            sensorManager.unregisterListener(this);

    }

    @Override
    protected void onResume() {


            super.onResume();
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI);

    }



    // identificando orientacion de la pantalla
    public String getRotation(Context context){
        final int rotation = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getOrientation();
        switch (rotation) {
            case Surface.ROTATION_0:
            case Surface.ROTATION_180:
                return "vertical";
            case Surface.ROTATION_90:
            default:
                return "horizontal";
        }
    }

// evento de los sensores
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(MainActivity.sensor) {

            // La lectura del sensor ha cambiado
            valores = sensorEvent.values;

//capturando los valores de aceleracion en z
            vz = (int) valores[2];

            if (vz >= 7 && respondiendo == false) {

                f++;
            }

            if (f >= 20) {
                resultado.setText("");
                respondiendo = true;

                if (MainActivity.sonido) {
                    mp.start();
                }

                new CountDownTimer(tiempo_respuesta, 1000) {


                    @Override
                    public void onTick(long l) {
                      // do nothing
                    }

                    @Override
                    public void onFinish() {
                       int numero = (int) (Math.random() * 14) + 1;

                       switch (numero){


                           case 1:
                               resultado.setText(R.string.respuesta1);
                               break;
                           case 2:
                               resultado.setText(R.string.respuesta2);
                               break;
                           case 3:
                               resultado.setText(R.string.respuesta3);
                               break;
                           case 4:
                               resultado.setText(R.string.respuesta4);
                               break;
                           case 5:
                               resultado.setText(R.string.respuesta5);
                               break;
                           case 6:
                               resultado.setText(R.string.respuesta6);
                               break;
                           case 7:
                               resultado.setText(R.string.respuesta7);

                               break;
                           case 8:
                               resultado.setText(R.string.respuesta8);
                               break;
                           case 9:
                               resultado.setText(R.string.respuesta9);
                               break;
                           case 10:
                               resultado.setText(R.string.respuesta10);
                               break;
                           case 11:
                               resultado.setText(R.string.respuesta11);
                               break;
                           case 12:
                               resultado.setText(R.string.respuesta12);
                               break;
                           case 13:
                               resultado.setText(R.string.respuesta13);
                               break;
                           case 14:
                               resultado.setText(R.string.respuesta14);
                               break;

                       }



                        respondiendo = false;
                    }
                }.start();

                f = 0;
            }

        }
    }
        @Override
        public void onAccuracyChanged (Sensor sensor,int accuracy){
            // La precisión del sensor ha cambiado
        }


    }


