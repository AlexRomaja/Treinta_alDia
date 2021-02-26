package com.example.treintaalda.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.treintaalda.R;
import com.google.android.material.appbar.MaterialToolbar;

public class Third_nivelSin extends AppCompatActivity {

    int pos;
    MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_nivel_sin);
        initComponents();

        //*******************************getPosition
        Intent intent = getIntent();
        int position = intent.getIntExtra("pos", 0);
        setPosition(position);
        //*******************************ToolBar
        setSupportActionBar(toolbar);
        ActionBar thirdActionBar = getSupportActionBar();
        if(thirdActionBar != null){
            thirdActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initComponents() {
        toolbar = findViewById(R.id.toolBarThirdSin);
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
                Toast.makeText(this, "Clicked ayuda", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}