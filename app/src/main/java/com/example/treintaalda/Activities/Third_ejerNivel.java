package com.example.treintaalda.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.treintaalda.Controlador.PageAdapter;
import com.example.treintaalda.Fragments.FragMedia;
import com.example.treintaalda.MainActivity;
import com.example.treintaalda.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Third_ejerNivel extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem tabBaja;
    TabItem tabMedia;
    TabItem tabAlta;
    PageAdapter pageAdapter;
    int pos;
    int aparato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_ejer_nivel);
        initComponents();

        //*******************************Get intent
        Intent intent = getIntent();
        int position = intent.getIntExtra("pos", 0);
        setPosition(position);
        //*******************************Get aparato
        int apar = intent.getIntExtra("aparato", 0);
        setAparato(apar);
        //*******************************ToolBar
        MaterialToolbar toolbar = findViewById(R.id.toolBarThird);
        setSupportActionBar(toolbar);

        ActionBar thirdActionBar = getSupportActionBar();
        if(thirdActionBar != null){
            thirdActionBar.setDisplayHomeAsUpEnabled(true);
        }
        //*******************************Tabs
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0) {
                    tabLayout.setBackgroundColor(ContextCompat.getColor(getApplication(),
                            R.color.colorBaja));
                } else if (tab.getPosition() == 1) {
                    tabLayout.setBackgroundColor(ContextCompat.getColor(getApplication(),
                            R.color.colorMedia));
                } else {
                    tabLayout.setBackgroundColor(ContextCompat.getColor(getApplication(),
                            R.color.colorAlta));
                }
                viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }
            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });
    }

    //*********sin/con Aparato
    public void setAparato(int aparato){
        this.aparato = aparato;
    }
    public int getAparato(){
        return aparato;
    }

    //*********Position
    public void setPosition(int pos){
        this.pos = pos;
    }
    public int getPosition(){
        return pos;
    }

    public void initComponents() {
        tabLayout = findViewById(R.id.TabLayout);
        viewPager = findViewById(R.id.viewPager);
        tabBaja = findViewById(R.id.tabBaja);
        tabMedia = findViewById(R.id.tabMedia);
        tabAlta = findViewById(R.id.tabAlta);

        pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);
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