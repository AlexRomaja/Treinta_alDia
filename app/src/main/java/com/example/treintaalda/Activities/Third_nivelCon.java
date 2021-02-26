package com.example.treintaalda.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.treintaalda.R;
import com.google.android.material.appbar.MaterialToolbar;

public class Third_nivelCon extends AppCompatActivity {

    int pos;
    MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_nivel_con);
        initComponents();

        //*******************************getPosition
        Intent intent = getIntent();
        int position = intent.getIntExtra("pos", 0);
        setPosition(position);
        //*******************************ToolBar
        setSupportActionBar(toolbar);
        ActionBar thirActionBar = getSupportActionBar();
        if (thirActionBar != null){
            thirActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initComponents() {
        toolbar = findViewById(R.id.toolBarThirdCon);
    }

    //*********Position
    public void setPosition(int pos){
        this.pos = pos;
    }
    public int getPosition(){
        return pos;
    }

    //*********ToolBar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_bar_general, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.icon_Ayuda:
                AlertDialog.Builder builder = new AlertDialog.Builder(Third_nivelCon.this);
                builder.setTitle("Intensidades de ejercicio");
                builder.setMessage(
                        "En esta pantalla podrás elegir el ejercicio que deseas realizar." +
                        "\nLos ejercicios están separados en tres intensidades de esfuerzo:" +
                        " baja, media y alta. Aprieta en las pestañas para desplazarte entre las intensidades." +
                        "\nDebajo de cada intensidad verás una lista donde se encuentran los ejercicios por nombre." +
                                " Aprieta en cualquier nombre para que te lleve al ejercicio y continuar."
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