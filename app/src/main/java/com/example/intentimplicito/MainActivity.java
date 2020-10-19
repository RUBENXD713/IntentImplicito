package com.example.intentimplicito;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
    }
    public void Onclick(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/RUBENXD713"));
        startActivity(intent);
    }

}