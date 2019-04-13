/**
 * Daniel Moudatsos Strassacapa Rodrigues R.A 81716932
 */

package br.usjt.ciclodevidagpsemapas;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaLocaisActivity extends AppCompatActivity {

    private ListView locationsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_locais);
        Intent origemIntent = getIntent();
        final ArrayList<Localizacao> locations = (ArrayList<Localizacao>) origemIntent.getSerializableExtra("locations");

        locationsListView = findViewById(R.id.localizacoesListView);
        ArrayAdapter<Localizacao> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, locations);
        locationsListView.setAdapter(adapter);

        locationsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Localizacao location = locations.get(position);

                Uri gmmIntentUri = Uri.parse(String.format("geo:%f,%f", location.getLongitude(), location.getLatitude()));

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });


    }
}
