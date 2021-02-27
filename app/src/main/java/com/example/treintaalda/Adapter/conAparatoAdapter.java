package com.example.treintaalda.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.treintaalda.Activities.Third_nivelCon;
import com.example.treintaalda.Datos.TipoEjerDat;
import com.example.treintaalda.R;

import java.util.ArrayList;

public class conAparatoAdapter extends RecyclerView.Adapter<conAparatoAdapter.ViewHolder> {

    private ArrayList<TipoEjerDat> tipoEjercicios = new ArrayList<>();
    private Context context;

    public conAparatoAdapter(Context context){ this.context = context; }

    @NonNull
    @Override
    public conAparatoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tipos_ejercicio_lista, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull conAparatoAdapter.ViewHolder holder, int position) {
        //setImagenes
        holder.image.setImageResource(tipoEjercicios.get(position).getImgURL());
        final int pos = position;
        //Clicker
        holder.cardParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Third_nivelCon.class);
                intent.putExtra("pos", pos);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tipoEjercicios.size();
    }

    public void setTipoEjercicios(ArrayList<TipoEjerDat> tipoEjercicios){
        this.tipoEjercicios = tipoEjercicios;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private CardView cardParent;
        private ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardParent = itemView.findViewById(R.id.cardTEL);
            image = itemView.findViewById(R.id.imageEjerCard);
        }
    }
}
