package com.example.treintaalda.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.treintaalda.Fragments.FragAltaCon;
import com.example.treintaalda.Fragments.FragAltaSin;
import com.example.treintaalda.Fragments.FragBajaCon;
import com.example.treintaalda.Fragments.FragBajaSin;
import com.example.treintaalda.Fragments.FragMediaCon;
import com.example.treintaalda.Fragments.FragMediaSin;
import com.example.treintaalda.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class Third_nivelCon extends AppCompatActivity {

    MaterialToolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;

    FragBajaCon fragBaja;
    FragMediaCon fragMedia;
    FragAltaCon fragAlta;

    int pos;

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
        //*******************************Tabs
        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdater viewPagerAdater = new ViewPagerAdater(getSupportFragmentManager(), 0);
        viewPagerAdater.addFragment(fragBaja, "Baja");
        viewPagerAdater.addFragment(fragMedia, "Media");
        viewPagerAdater.addFragment(fragAlta, "Alta");
        viewPager.setAdapter(viewPagerAdater);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0){
                    tabLayout.setBackgroundColor(ContextCompat.getColor(getApplication(), R.color.colorBaja));
                }else if (tab.getPosition() == 1){
                    tabLayout.setBackgroundColor(ContextCompat.getColor(getApplication(), R.color.colorMedia));
                }else{
                    tabLayout.setBackgroundColor(ContextCompat.getColor(getApplication(), R.color.colorAlta));
                }
                viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initComponents() {
        toolbar = findViewById(R.id.toolBarThirdCon);
        viewPager = findViewById(R.id.viewPagerCon);
        tabLayout = findViewById(R.id.tabLayoutCon);

        fragBaja = new FragBajaCon();
        fragMedia = new FragMediaCon();
        fragAlta = new FragAltaCon();
    }

    //*********Tabs
    private class ViewPagerAdater extends FragmentPagerAdapter{
        private ArrayList<Fragment> fragments = new ArrayList<>();
        private ArrayList<String> fragTitle = new ArrayList<>();

        public ViewPagerAdater(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        public void addFragment(Fragment fragment, String title){
            fragments.add(fragment);
            fragTitle.add(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragTitle.get(position);
        }
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