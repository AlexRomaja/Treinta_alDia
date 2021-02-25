package com.example.treintaalda.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.treintaalda.Adapter.conAparatoAdapter;
import com.example.treintaalda.Datos.TipoEjerDat;
import com.example.treintaalda.R;
import com.google.android.material.appbar.MaterialToolbar;

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

        MaterialToolbar toolbar = findViewById(R.id.toolBarSecond);
        setSupportActionBar(toolbar);

        ActionBar secondActionBar = getSupportActionBar();
        if(secondActionBar != null){
            secondActionBar.setDisplayHomeAsUpEnabled(true);
        }

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_bar_general, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.icon_Ayuda:
                Toast.makeText(this, "Clicked ayuda", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}