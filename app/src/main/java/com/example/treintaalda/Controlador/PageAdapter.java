package com.example.treintaalda.Controlador;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.treintaalda.Fragments.FragAlta;
import com.example.treintaalda.Fragments.FragBaja;
import com.example.treintaalda.Fragments.FragMedia;

public class PageAdapter extends FragmentPagerAdapter {

    private int numofTabs;

    public PageAdapter(FragmentManager fm, int numofTabs){
        super(fm);
        this.numofTabs = numofTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragBaja();
            case 1:
                return new FragMedia();
            case 2:
                return new FragAlta();
            default:
            return null;
        }
    }

    @Override
    public int getCount() {
        return numofTabs;
    }
}
