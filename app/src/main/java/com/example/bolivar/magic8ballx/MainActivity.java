package com.example.bolivar.magic8ballx;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    MediaPlayer mp;
Button boton1;
Button boton2;
TextView portada;
Intent i;
static boolean sensor;
static boolean sonido;
static  boolean comenzar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mp=MediaPlayer.create(this,R.raw.sonidoboton);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(comenzar==false){
            sensor=true;
            sonido=true;
            comenzar=true;

        }



         boton1= findViewById(R.id.botonmenu1);
         boton2=findViewById(R.id.botonmenu2);
         portada=findViewById(R.id.textportada);
        Typeface fuente1= Typeface.createFromAsset(getAssets(),"myfonts/chpfire.ttf");
        Typeface fuente2=Typeface.createFromAsset(getAssets(),"myfonts/fuenteportada.TTF");

        portada.setTypeface(fuente2);
        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);

        boton1.setTypeface(fuente1);
        boton2.setTypeface(fuente1);

    }

    @Override
    public void onClick(View view) {



switch (view.getId()){

    case R.id.botonmenu1:

        i=new Intent(this,JugarActivity.class);
        if(sonido){
            mp.start();
        }
        startActivity(i);

        break;

    case R.id.botonmenu2:
        i=new Intent(this,ConfigurationActivity.class
        );
        if(sonido){

            mp.start();
        }
        startActivity(i);
        break;




}



    }
}


