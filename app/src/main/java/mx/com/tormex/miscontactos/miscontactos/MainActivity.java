package mx.com.tormex.miscontactos.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Manuel Ávila", "8717370105", "manuel@gamil.com"));
        contactos.add(new Contacto("Ani Acosta", "7292215", "ani@gamil.com"));
        contactos.add(new Contacto("Alberto Valenzuela", "8711915018", "alberto@gamil.com"));
        contactos.add(new Contacto("Sofía Ayala", "8712125481", "sofia@gamil.com"));
        contactos.add(new Contacto("Jorge Ávila", "8712125471", "jorge@gamil.com"));

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
    }
}
