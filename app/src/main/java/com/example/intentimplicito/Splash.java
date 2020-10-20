package com.example.intentimplicito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final TextView txt;
        txt = findViewById(R.id.txtSplash);
        Intent submit = new Intent(Splash.this,MainActivity.class);
        final String nombre = "Bienvenido Chaval";
        //TIMER
        final Intent finalSubmit = submit;
        new CountDownTimer(3000, 1000)
        {

            @Override
            public void onTick(long millisUntilFinished) {
                txt.setText("Restan:"+millisUntilFinished/1000+" Segundos");
            }

            @Override
            public void onFinish() {

                startActivity(finalSubmit.putExtra("valor", nombre ));
                finish();
                txt.setText("Listo");
            }
        }.start();
    }
}