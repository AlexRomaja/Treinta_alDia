package com.example.treintaalda.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.treintaalda.Activities.Secon_conAparato;
import com.example.treintaalda.Activities.Secon_sinAparato;
import com.example.treintaalda.Datos.EleccionDat;
import com.example.treintaalda.R;

import java.util.ArrayList;

public class EjerEleccionAdapter extends RecyclerView.Adapter<EjerEleccionAdapter.ViewHolder>{
    private ArrayList<EleccionDat> eleccionEjercicios = new ArrayList<>();
    private Context context;

    public EjerEleccionAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.seleccion_ejercicio, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final int aux = position + 1;
        //setImagenes
        holder.image.setImageResource(eleccionEjercicios.get(position).getImageURL());

        //Clicker
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aux == 1) {
                    Intent intent = new Intent(context, Secon_sinAparato.class);
                    context.startActivity(intent);
                }else{
                    Intent intent = new Intent(context, Secon_conAparato.class);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return eleccionEjercicios.size();
    }

    public void setEleccionEjercicios(ArrayList<EleccionDat> eleccionEjercicios) {
        this.eleccionEjercicios = eleccionEjercicios;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private CardView cardView;
        private ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardSEJ);
            image = itemView.findViewById(R.id.imageSelecCard);
        }
    }

}
