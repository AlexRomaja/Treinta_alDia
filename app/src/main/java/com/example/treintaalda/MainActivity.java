package com.example.treintaalda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.treintaalda.Act_drawer.About_Us;
import com.example.treintaalda.Act_drawer.Recomendaciones;
import com.example.treintaalda.Adapter.EjerEleccionAdapter;
import com.example.treintaalda.Datos.EleccionDat;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView ejermainRec;
    MaterialToolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    int[] imagenes = {R.drawable.vector_brazo, R.drawable.conaparato};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ejermainRec = findViewById(R.id.mainRecycler);
        toolbar = findViewById(R.id.toolBar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navView);

        setSupportActionBar(toolbar);

        //*********************************NavigationDrawer
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        ejerOpcionces();
    }



    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.drawReco:
                Intent intent = new Intent(MainActivity.this, Recomendaciones.class);
                startActivity(intent);
                break;
            case R.id.drawInfo:
                Intent intent1 = new Intent(MainActivity.this, About_Us.class);
                startActivity(intent1);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}