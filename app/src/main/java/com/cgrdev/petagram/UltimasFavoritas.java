package com.cgrdev.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.Collections;

import static com.cgrdev.petagram.MainActivity.mascotas;

public class UltimasFavoritas extends AppCompatActivity {

    private RecyclerView listaMascotasFavoritas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultimas_favoritas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.ultimasFavoritasActivityActionBar);
        // Modificamos el dibujo de la flecha de subir
        miActionBar.setNavigationIcon(R.drawable.back);
        setSupportActionBar(miActionBar);

        // Hacemos que la flecha de subir se muestre
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotasFavoritas = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotasFavoritas.setLayoutManager(llm);

        // Como es una lista 'dummy', simplemente reordenamos al azar e inicializamos adaptador
        Collections.shuffle(mascotas);
        inicializarAdaptador(mascotas);
    }

    private void inicializarAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(mascotas, false);
        listaMascotasFavoritas.setAdapter(mascotaAdaptador);
    }
}
