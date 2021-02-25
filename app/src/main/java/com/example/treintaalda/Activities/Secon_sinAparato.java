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

import com.example.treintaalda.Adapter.sinAparatoAdapter;
import com.example.treintaalda.Datos.TipoEjerDat;
import com.example.treintaalda.Fragments.FragMedia;
import com.example.treintaalda.R;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class Secon_sinAparato extends AppCompatActivity {

    RecyclerView secondRec;

    int[] imagenes = {R.drawable.vector_brazo, R.drawable.vector_abdomen,R.drawable.vector_espalda,
            R.drawable.vector_pecho,R.drawable.vector_pierna};

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