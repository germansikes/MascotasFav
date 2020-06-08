package com.dreamsense.mascotafav;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

/**
 * Created by Gabriel on 06/07/2016.
 */
public class ListaMascotas extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private RecyclerView listaMascotas;
    public MascotaAdaptador adaptador;
    ArrayList<Mascota> mascotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_mascotas);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
        respaldo();


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "ListaMascotas Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.dreamsense.courseramascotas/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "ListaMascotas Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.dreamsense.courseramascotas/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.dog1, "Coco", "0"));
        mascotas.add(new Mascota(R.drawable.dog2, "Manchas", "5"));
        mascotas.add(new Mascota(R.drawable.dog3, "Simona", "2"));
        mascotas.add(new Mascota(R.drawable.dog4, "Bruno", "3"));
        mascotas.add(new Mascota(R.drawable.dog5, "Molli", "1"));
        mascotas.add(new Mascota(R.drawable.dog6, "Coqui", "0"));
        mascotas.add(new Mascota(R.drawable.dog7, "Chelo", "6"));
        mascotas.add(new Mascota(R.drawable.dog8, "Chikis", "4"));
        mascotas.add(new Mascota(R.drawable.dog9, "Blaki", "2"));
        mascotas.add(new Mascota(R.drawable.dog10, "Bibi","1"));
        mascotas.add(new Mascota(R.drawable.dog11, "Firulais", "0"));
    }


    public void respaldo(){
        if(!MascotaAdaptador.mascotasFavs.isEmpty()) {
            for (int x = 0, y=0; x < mascotas.size() && y < MascotaAdaptador.mascotasFavs.size(); x++) {
                if (mascotas.get(x).getNombre() == MascotaAdaptador.mascotasFavs.get(y).getNombre()) {
                    mascotas.get(x).setLikes(MascotaAdaptador.mascotasFavs.get(x).getLikes());
                    y++;
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.resources, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_fav:
                //Al presionar el botón de favoritos se muestra el nuevo activity con los favs seleccionados
                if(MascotaAdaptador.mascotasFavs.size() > 0) {
                    Intent intent = new Intent(ListaMascotas.this, MascotasFavoritos.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(ListaMascotas.this, "No es posible acceder a esta ventana, no tienes favoritos.", Toast.LENGTH_LONG).show();
                }
                return true;

                default:
                    return super.onOptionsItemSelected(item);
        }
    }
}
