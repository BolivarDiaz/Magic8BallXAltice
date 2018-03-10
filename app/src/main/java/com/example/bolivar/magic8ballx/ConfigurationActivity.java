package com.example.bolivar.magic8ballx;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class ConfigurationActivity extends AppCompatActivity implements View.OnClickListener{
     ToggleButton botonsonido;
     ToggleButton botonsensor;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mp=MediaPlayer.create(this,R.raw.sonidoboton);
        Typeface fuente1= Typeface.createFromAsset(getAssets(),"myfonts/chpfire.ttf");
       botonsonido=findViewById(R.id.toggleButton_desactivarsonido);
       botonsensor=findViewById(R.id.toggleButton_desactivarsensor);
        TextView textosonido=findViewById(R.id.textDesactivarsonido);
        TextView textosensor=findViewById(R.id.textDesactivarsensor);
        TextView textosobre=findViewById(R.id.textCreditos);
        TextView textoautor=findViewById(R.id.textautor);
        textoautor.setTypeface(fuente1);
        textosobre.setTypeface(fuente1);
        textosonido.setTypeface(fuente1);
        textosensor.setTypeface(fuente1);

        if(MainActivity.sonido!=botonsonido.isSelected()){

            botonsonido.toggle();
            if(MainActivity.sonido){
                botonsonido.setTextColor(Color.WHITE);
                botonsonido.setBackgroundColor(Color.RED);
            }else{

                botonsonido.setTextColor(Color.BLACK);
                botonsonido.setBackgroundColor(getResources().getColor(R.color.morado));
            }

        }
        if(MainActivity.sensor!=botonsensor.isChecked()){

            botonsensor.toggle();
            if(MainActivity.sensor){
                botonsensor.setTextColor(Color.WHITE);
                botonsensor.setBackgroundColor(Color.RED);
            }else{

                botonsensor.setTextColor(Color.BLACK);
                botonsensor.setBackgroundColor(getResources().getColor(R.color.morado));
            }

        }


        botonsonido.setOnClickListener(this);
        botonsensor.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.toggleButton_desactivarsonido:

                if(MainActivity.sonido){

                    MainActivity.sonido=false;
                    botonsonido.setTextColor(Color.BLACK);
                    botonsonido.setBackgroundColor(getResources().getColor(R.color.morado));

                }else{

                    mp.start();
                    MainActivity.sonido=true;
                    botonsonido.setTextColor(Color.WHITE);
                    botonsonido.setBackgroundColor(Color.RED);
                }



                break;

            case R.id.toggleButton_desactivarsensor:

                if(MainActivity.sonido){ mp.start(); }

                if(MainActivity.sensor){


                    MainActivity.sensor=false;
                    botonsensor.setTextColor(Color.BLACK);
                    botonsensor.setBackgroundColor(getResources().getColor(R.color.morado));

                }else{

                    MainActivity.sensor=true;
                    botonsensor.setTextColor(Color.WHITE);
                    botonsensor.setBackgroundColor(Color.RED);

                }



                break;





        }




    }

}
