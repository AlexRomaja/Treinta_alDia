package com.example.treintaalda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.treintaalda.Adapter.EjerEleccionAdapter;
import com.example.treintaalda.Datos.EleccionDat;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView ejermainRec;

    int[] imagenes = {R.drawable.sinaparato, R.drawable.conaparato};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ejermainRec = findViewById(R.id.mainRecycler);

        MaterialToolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_bar_general, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.icon_Ayuda:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Bienvenido");
                builder.setMessage(
                        "En esta pantalla podrás elegir el estilo de ejercicio que gustes." +
                        "\nA la izquierda tienes los ejercicios sin aparatos o herramientas." +
                        "\nDel lado derecho tienes los ejercicios con aparatos y herramientas." +
                        "\nAprieta en cualquiera de las imagenes para continuar."
                );
                builder.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}