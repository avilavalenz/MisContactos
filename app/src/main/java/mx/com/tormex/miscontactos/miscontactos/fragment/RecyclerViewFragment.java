package mx.com.tormex.miscontactos.miscontactos.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.com.tormex.miscontactos.miscontactos.R;
import mx.com.tormex.miscontactos.miscontactos.adapter.ContactoAdaptador;
import mx.com.tormex.miscontactos.miscontactos.pojo.Contacto;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {

    ArrayList<Contacto> contactos;
    private RecyclerView rvContactos;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        /*Llenado del Recycler View*/
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        rvContactos = (RecyclerView) v.findViewById(R.id.rvContactos);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvContactos.setLayoutManager(manager);
        inicializarLista();
        inicializarAdaptador();
        return v;
    }

    public void inicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, getActivity());
        rvContactos.setAdapter(adaptador);
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
