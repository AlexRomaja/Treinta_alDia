package com.example.treintaalda.Fragments;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.treintaalda.Activities.Fourth_Ejercicio;
import com.example.treintaalda.Activities.Third_nivelSin;
import com.example.treintaalda.Datos.EjercicioDat;
import com.example.treintaalda.R;
import com.example.treintaalda.sqlDB.DBHelper;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragAltaSin#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragAltaSin extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragAltaSin() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragAlta.
     */
    // TODO: Rename and change types and number of parameters
    public static FragAltaSin newInstance(String param1, String param2) {
        FragAltaSin fragment = new FragAltaSin();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    //**************************************************////TODO:Tab_sinAlta
    //**************************************************
    //**************************************************
    //**************************************************

    ListView listView;
    ArrayList<String> listDat;
    ArrayList<EjercicioDat> listEjer;
    int position;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag_alta, container, false);
        listView = view.findViewById(R.id.listAltasin);
        Third_nivelSin act_sinAparato = (Third_nivelSin) getActivity();
        position = act_sinAparato.getPosition();
        consultaDatos();

        final ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, listDat);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                int img = listEjer.get(pos).getImagURL();
                String titulo = listEjer.get(pos).getName();
                int series = listEjer.get(pos).getSeries();
                int rept = listEjer.get(pos).getRepeticiones();
                String desc = listEjer.get(pos).getDescripcion();
                Intent intent = new Intent(getActivity(), Fourth_Ejercicio.class);
                intent.putExtra("img", img);
                intent.putExtra("titulo", titulo);
                intent.putExtra("series", series);
                intent.putExtra("rept", rept);
                intent.putExtra("desc", desc);
                startActivity(intent);
            }
        });
        return view;
    }

    private void consultaDatos(){
        DBHelper dbHelper = new DBHelper(getActivity());
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        EjercicioDat ejerDat = null;
        listEjer = new ArrayList<EjercicioDat>();

        //TODO: Choose DB
        if(position == 0){
            Cursor cursor = db.query("alta_brazo", null, null, null,
                    null, null, null);
            while(cursor.moveToNext()){
                ejerDat = new EjercicioDat();
                ejerDat.setId(cursor.getInt(0));
                ejerDat.setName(cursor.getString(1));
                ejerDat.setSeries(cursor.getInt(2));
                ejerDat.setRepeticiones(cursor.getInt(3));
                ejerDat.setDescripcion(cursor.getString(4));
                ejerDat.setImagURL(cursor.getInt(5));
                listEjer.add(ejerDat);
            }
        }else if (position == 1){
            Cursor cursor = db.query("alta_abdomen", null, null, null,
                    null, null, null);
            while(cursor.moveToNext()){
                ejerDat = new EjercicioDat();
                ejerDat.setId(cursor.getInt(0));
                ejerDat.setName(cursor.getString(1));
                ejerDat.setSeries(cursor.getInt(2));
                ejerDat.setRepeticiones(cursor.getInt(3));
                ejerDat.setDescripcion(cursor.getString(4));
                ejerDat.setImagURL(cursor.getInt(5));
                listEjer.add(ejerDat);
            }
        }else if (position == 2){
            Cursor cursor = db.query("alta_espalda", null, null, null,
                    null, null, null);
            while(cursor.moveToNext()){
                ejerDat = new EjercicioDat();
                ejerDat.setId(cursor.getInt(0));
                ejerDat.setName(cursor.getString(1));
                ejerDat.setSeries(cursor.getInt(2));
                ejerDat.setRepeticiones(cursor.getInt(3));
                ejerDat.setDescripcion(cursor.getString(4));
                ejerDat.setImagURL(cursor.getInt(5));
                listEjer.add(ejerDat);
            }
        }else if (position == 3){
            Cursor cursor = db.query("alta_pecho", null, null, null,
                    null, null, null);
            while(cursor.moveToNext()){
                ejerDat = new EjercicioDat();
                ejerDat.setId(cursor.getInt(0));
                ejerDat.setName(cursor.getString(1));
                ejerDat.setSeries(cursor.getInt(2));
                ejerDat.setRepeticiones(cursor.getInt(3));
                ejerDat.setDescripcion(cursor.getString(4));
                ejerDat.setImagURL(cursor.getInt(5));
                listEjer.add(ejerDat);
            }
        }else if (position == 4){
            Cursor cursor = db.query("alta_pierna", null, null, null,
                    null, null, null);
            while(cursor.moveToNext()){
                ejerDat = new EjercicioDat();
                ejerDat.setId(cursor.getInt(0));
                ejerDat.setName(cursor.getString(1));
                ejerDat.setSeries(cursor.getInt(2));
                ejerDat.setRepeticiones(cursor.getInt(3));
                ejerDat.setDescripcion(cursor.getString(4));
                ejerDat.setImagURL(cursor.getInt(5));
                listEjer.add(ejerDat);
            }
        }
        obtenerList();
    }

    private void obtenerList(){
        listDat = new ArrayList<>();
        for (int i=0; i<listEjer.size(); i++){
            listDat.add(""+listEjer.get(i).getName());
        }
    }
}