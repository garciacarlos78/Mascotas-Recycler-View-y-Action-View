package com.cgrdev.petagram;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;

    // Con este booleano controlamos si el adaptador ha sido llamado desde MainActivity o desde UltimasFavoritas
    // Si ha sido llamado desde MainActivity asignamos listener al botón del hueso, si no (main=false), no lo asignamos
    boolean main;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, boolean main) {
        this.mascotas = mascotas;
        this.main = main;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_mascota, viewGroup, false);

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, int i) {

        final Mascota mascota = mascotas.get(i);

        mascotaViewHolder.imgMascota.setImageResource(mascota.getPictureId());
        mascotaViewHolder.tvName.setText(mascota.getName());
        mascotaViewHolder.tvRating.setText(String.valueOf(mascota.getRating()));

        // Alternamos el color de fondo de la imagen de mascota
        if (i % 2 == 0)
            mascotaViewHolder.imgMascota.setBackgroundColor(ContextCompat.getColor(mascotaViewHolder.btBone.getContext(), R.color.cardviewPar));
        else
            mascotaViewHolder.imgMascota.setBackgroundColor(ContextCompat.getColor(mascotaViewHolder.btBone.getContext(), R.color.cardviewImpar));

        // Lo ideal sería modificar el fondo del CardView, pero al hacerlo deja de tener efecto el CornerRadius
        // Se haría con las siguientes líneas comentadas
//        if (i % 2 == 0) mascotaViewHolder.cvMascota.setBackgroundColor(ContextCompat.getColor(mascotaViewHolder.btBone.getContext(), R.color.cardviewPar));
//        else mascotaViewHolder.cvMascota.setBackgroundColor(ContextCompat.getColor(mascotaViewHolder.btBone.getContext(), R.color.cardviewImpar));

        // Únicamente añadimos el listener al botón si se ha invocado el adaptador desde MainActivity (this.main=true)
        if (this.main) {
            mascotaViewHolder.btBone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int rate = mascota.getRating();
                    mascota.setRating(++rate);
                    mascotaViewHolder.tvRating.setText(String.valueOf(mascota.getRating()));
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgMascota;
        private TextView tvName;
        private TextView tvRating;
        private CardView cvMascota;
        private ImageButton btBone;

        public MascotaViewHolder(@NonNull View v) {

            super(v);

            imgMascota = (ImageView) v.findViewById(R.id.imgMascota);
            tvName = (TextView) v.findViewById(R.id.tvName);
            tvRating = (TextView) v.findViewById(R.id.tvRating);
            cvMascota = (CardView) v.findViewById(R.id.cvMascota);
            btBone = (ImageButton) v.findViewById(R.id.btBone);
        }
    }
}
