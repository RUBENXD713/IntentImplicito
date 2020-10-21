package com.example.intentimplicito;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView text;
    final private int CodigoPermisos=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        text=findViewById(R.id.textView2);
        Bundle extras = getIntent().getExtras();
        String textoIni = extras.getString("valor");
        text.setText(textoIni);
        solicitarPermisos();
    }

    private void solicitarPermisos() {
        int permisoAlmacenamiento = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE);
        int permisoCamara= ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CAMERA);

        if (permisoAlmacenamiento!= PackageManager.PERMISSION_GRANTED || permisoCamara!=PackageManager.PERMISSION_GRANTED){
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
                requestPermissions(new  String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.CAMERA},CodigoPermisos);
        }
    }

    public void Onclick(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/RUBENXD713"));
        startActivity(intent);
    }


}