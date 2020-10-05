package com.example.proyecto_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;
public class Adaptador extends BaseAdapter {
    Context contexto;
    List<Combo> ListaObjetos;
    //alt + ins me genera el constructor y selecciona los datos
    public Adaptador(Context contexto, List<Combo> listaObjetos) { this.contexto = contexto;
        ListaObjetos = listaObjetos;
    }
    public int getCount() {
        return ListaObjetos.size();
    }
    @Override
    //retorna el objeto q usas puntual en el momento
    public Object getItem(int position) {
        return ListaObjetos.get(position);
    }
    @Override
//usas lista de objeto de Id
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View vista = convertView;
        LayoutInflater inflate = LayoutInflater.from(contexto); vista= inflate.inflate(R.layout.combo, null);

        ImageView imagen =(ImageView)vista.findViewById(R.id.img1);
        TextView titulo=(TextView)vista.findViewById(R.id.txtTitulo);
        TextView detalle =(TextView)vista.findViewById(R.id.txtContenido);

        titulo.setText(ListaObjetos.get(position).getNombre());
        detalle.setText(ListaObjetos.get(position).getDetalle());
        imagen.setImageResource(ListaObjetos.get(position).getImagen());

        RatingBar ratingBar = vista.findViewById(R.id.ratingBar);
        ratingBar.setRating(ListaObjetos.get(position).getRating());

        final CheckBox ordered = vista.findViewById(R.id.cbAdd);
        ordered.setChecked(ListaObjetos.get(position).isOrdered());
        ordered.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                ListaObjetos.get(position).setOrdered(b);
            }
        });
        return vista;
    }
}