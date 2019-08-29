package com.cgrdev.petagram;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // static para poder utilizar en UltimasFavoritas
    static ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    // static para que conserve su valor al volver de UltimasFavoritas
    private static boolean mascotasInicializadas = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.mainActivityActionBar);
        setSupportActionBar(miActionBar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        if (!mascotasInicializadas) inicializaMascotas();
        inicializarAdaptador();
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {

        int id = item.getItemId();

        // Si hemos presionado el botón de la estrella
        if (id == R.id.btFavoritos) {

            // Creamos intent
            Intent intent = new Intent(this, UltimasFavoritas.class);

            // Iniciamos la nueva Activity
            startActivity(new Intent(this,UltimasFavoritas.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
     }

    private void inicializarAdaptador() {
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(mascotas, true);
        listaMascotas.setAdapter(mascotaAdaptador);
    }

    private void inicializaMascotas() {

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(1, R.drawable.dog_3,"Tobías"));
        mascotas.add(new Mascota(2, R.drawable.dog_2,"Jeremías"));
        mascotas.add(new Mascota(3, R.drawable.dog_gimp,"Gimpy"));
        mascotas.add(new Mascota(4, R.drawable.beaver_1,"Alvin"));
        mascotas.add(new Mascota(5, R.drawable.ghost_1,"Casper"));

        mascotasInicializadas = true;
    }

}
