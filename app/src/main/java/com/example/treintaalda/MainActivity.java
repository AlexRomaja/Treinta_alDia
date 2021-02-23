package com.example.treintaalda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.treintaalda.Adapter.EjerEleccionAdapter;
import com.example.treintaalda.Datos.EleccionDat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView ejermainRec;

    int[] imagenes = {R.drawable.sinaparato, R.drawable.conaparato};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ejermainRec = findViewById(R.id.mainRecycler);

        ejerOpcionces();
    }

    public void ejerOpcionces() {
        ArrayList<EleccionDat> eleccion = new ArrayList<>();
        eleccion.add(new EleccionDat(1, "sinEjercicio", imagenes[0]));
        eleccion.add(new EleccionDat(2, "conEjercicio", imagenes[1]));

        EjerEleccionAdapter adapter = new EjerEleccionAdapter(this);
        adapter.setEleccionEjercicios(eleccion);

        ejermainRec.setAdapter(adapter);
        ejermainRec.setLayoutManager(new GridLayoutManager(this, 2));


    }

}