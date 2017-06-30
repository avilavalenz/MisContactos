package mx.com.tormex.miscontactos.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);

        setSupportActionBar(miActionBar);
        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(manager);

        inicializarLista();
        inicializarAdaptador();


        /*
        ArrayList<String> nombresContacto = new ArrayList<String>();
        for (Contacto contacto:contactos) {
            nombresContacto.add(contacto.getNombre());
        }
        
        ListView lstContactos = (ListView)findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetalleContactoActivity.class);
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(i).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(i).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(i).getEmail());
                startActivity(intent);

                //Finalizar actividad anterior
                finish();

            }
        });
        */
    }

    public void inicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, this);
        listaContactos.setAdapter(adaptador);
    }

    public void inicializarLista(){
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto(R.drawable.pamarillo, "Manuel Ávila", "8717370105", "manuel@gamil.com"));
        contactos.add(new Contacto(R.drawable.pamarillo2, "Ani Acosta", "7292215", "ani@gamil.com"));
        contactos.add(new Contacto(R.drawable.projo, "Alberto Valenzuela", "8711915018", "alberto@gamil.com"));
        contactos.add(new Contacto(R.drawable.pamarillo, "Sofía Ayala", "8712125481", "sofia@gamil.com"));
        contactos.add(new Contacto(R.drawable.pamarillo2, "Jorge Ávila", "8712125471", "jorge@gamil.com"));
    }
}
