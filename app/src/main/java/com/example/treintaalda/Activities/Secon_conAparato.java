package com.example.treintaalda.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.treintaalda.Adapter.conAparatoAdapter;
import com.example.treintaalda.Datos.TipoEjerDat;
import com.example.treintaalda.R;

import java.util.ArrayList;

public class Secon_conAparato extends AppCompatActivity {

    RecyclerView secondRec;

    int[] imagenes = {R.drawable.mancuernasybarra, R.drawable.ballyoga, R.drawable.bandaelastica,
            R.drawable.abroller, R.drawable.trx};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_consinaparato);
        secondRec = findViewById(R.id.secondRecycler);

        TablaDatos();

    }

    private void TablaDatos(){
        ArrayList<TipoEjerDat> tipoEjercicios = new ArrayList<>();

        tipoEjercicios.add(new TipoEjerDat(1, "Mancuernas y Barras", imagenes[0]));
        tipoEjercicios.add(new TipoEjerDat(2, "Bola de Yoga", imagenes[1]));
        tipoEjercicios.add(new TipoEjerDat(3, "Banda Elastica", imagenes[2]));
        tipoEjercicios.add(new TipoEjerDat(4, "Rueda Abdominal", imagenes[3]));
        tipoEjercicios.add(new TipoEjerDat(5, "TRX", imagenes[4]));

        conAparatoAdapter adapter = new conAparatoAdapter(this);
        adapter.setTipoEjercicios(tipoEjercicios);

        secondRec.setAdapter(adapter);
        secondRec.setLayoutManager(new GridLayoutManager(this, 2));
    }
}