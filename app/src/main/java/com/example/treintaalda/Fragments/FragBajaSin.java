package com.example.treintaalda.Fragments;

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

import com.example.treintaalda.Activities.Third_nivelCon;
import com.example.treintaalda.Activities.Third_nivelSin;
import com.example.treintaalda.Datos.MockDat;
import com.example.treintaalda.R;
import com.example.treintaalda.sqlDB.DatabaseHelper;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragBajaSin#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragBajaSin extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragBajaSin() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragBaja.
     */
    // TODO: Rename and change types and number of parameters
    public static FragBajaSin newInstance(String param1, String param2) {
        FragBajaSin fragment = new FragBajaSin();
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

    //**************************************************////TODO:Tab_Baja
    //**************************************************
    //**************************************************
    //**************************************************

    ListView listView;
    ArrayList<String> listDat;
    ArrayList<MockDat> listMock;

    int position;
    int aparato;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag_baja, container, false);
        listView = view.findViewById(R.id.listBaja);
        Third_nivelSin act_sinAparto = (Third_nivelSin) getActivity();
        position = act_sinAparto.getPosition();
        consultaDatos();


        final ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, listDat);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                int aux = listMock.get(pos).getId();
            }
        });


        return view;
    }

    private void consultaDatos(){
        DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        MockDat mockDat = null;
        listMock = new ArrayList<MockDat>();

        //TODO: Choose BD
//        if (aparato == 0) {
            if (position == 0) {
                Cursor cursor = db.query("brazo", null, null, null,
                        null, null, null);
                while (cursor.moveToNext()) {
                    mockDat = new MockDat();
                    mockDat.setId(cursor.getInt(0));
                    mockDat.setName(cursor.getString(1));

                    listMock.add(mockDat);
                }
            } else if (position == 1){
                Cursor cursor = db.query("abdomen", null, null, null,
                        null, null, null);
                while (cursor.moveToNext()) {
                    mockDat = new MockDat();
                    mockDat.setId(cursor.getInt(0));
                    mockDat.setName(cursor.getString(1));

                    listMock.add(mockDat);
                }
            }
//        }else if (aparato == 1) {
//            Cursor cursor = db.query("abdomen", null, null, null,
//                    null, null, null);
//            while (cursor.moveToNext()) {
//                mockDat = new MockDat();
//                mockDat.setId(cursor.getInt(0));
//                mockDat.setName(cursor.getString(1));
//
//                listMock.add(mockDat);
//            }
//        }
        obtenerLista();
    }

    private void obtenerLista() {
        listDat = new ArrayList<>();
        for (int i=0; i < listMock.size(); i++){
            listDat.add(""+listMock.get(i).getName());
        }
    }

}