package com.example.treintaalda.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.treintaalda.Adapter.sinAparatoAdapter;
import com.example.treintaalda.Datos.TipoEjerDat;
import com.example.treintaalda.Fragments.FragMedia;
import com.example.treintaalda.R;

import java.util.ArrayList;

public class Secon_sinAparato extends AppCompatActivity {

    RecyclerView secondRec;

    int[] imagenes = {R.drawable.brazo_100x100, R.drawable.abdomen_100x100,
            R.drawable.espalda_100x100, R.drawable.pecho_100x100, R.drawable.pierna_100x100};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_consinaparato);
        secondRec = findViewById(R.id.secondRecycler);

        TablaDatos();
    }

    private void TablaDatos() {
        ArrayList<TipoEjerDat> tipoEjercicios = new ArrayList<>();

        tipoEjercicios.add(new TipoEjerDat(1, "Brazos", imagenes[0]));
        tipoEjercicios.add(new TipoEjerDat(2, "Abdomen", imagenes[1]));
        tipoEjercicios.add(new TipoEjerDat(3, "Espalda", imagenes[2]));
        tipoEjercicios.add(new TipoEjerDat(4, "Pecho", imagenes[3]));
        tipoEjercicios.add(new TipoEjerDat(5, "Pierna", imagenes[4]));

        sinAparatoAdapter adapter = new sinAparatoAdapter(this);
        adapter.setTipoEjercicios(tipoEjercicios);

        secondRec.setAdapter(adapter);
        secondRec.setLayoutManager(new GridLayoutManager(this, 2));
    }
}