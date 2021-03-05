package com.example.treintaalda.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.treintaalda.R;

public class Fourth_Ejercicio extends AppCompatActivity {

    ImageView imageView;
    TextView titulo, series, repeticiones, descripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth__ejercicio);
        initComponents();

        Intent intent = getIntent();
        int img = intent.getIntExtra("img", 0);
        String titu = intent.getStringExtra("titulo");
        int serie = intent.getIntExtra("series", 0);
        int rept = intent.getIntExtra("rept", 0);
        String desc = intent.getStringExtra("desc");

        imageView.setImageResource(img);
        titulo.setText(titu);
        series.setText(String.valueOf(serie));
        repeticiones.setText(String.valueOf(rept));
        descripcion.setText(String.valueOf(desc));
    }

    public void initComponents() {
        imageView = findViewById(R.id.image_Ejercicio);
        titulo = findViewById(R.id.ejerTitulo);
        series = findViewById(R.id.seriesNum);
        repeticiones = findViewById(R.id.repeticionesNum);
        descripcion = findViewById(R.id.despTxt);
    }
}