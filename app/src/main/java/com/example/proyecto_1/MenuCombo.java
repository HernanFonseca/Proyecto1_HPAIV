package com.example.proyecto_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MenuCombo extends AppCompatActivity {
    private ListView menuCombo;
    ArrayList<Combo> menu, compras;
    Button btnSiguiente;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_combo);
        menuCombo=findViewById(R.id.listaCombos);
        btnSiguiente=findViewById(R.id.btnSiguiente);
        compras=new ArrayList<Combo>();
        menu=new ArrayList<Combo>();
        menu.add(new Combo(1, "Hamburgueson","Hamburguesa de doble carne con queso americano y bacon, acompañado de papas y una cerveza",4, R.drawable.combo1));
        menu.add(new Combo(2, "Pizza delicia","Pizza para una persona con pimenton, cebolla morada, hongos y peperoni, acompañado de una cerveza",5, R.drawable.combo2));
        menu.add(new Combo(3, "Team Hotdog","2 hotdogs con salsas, papas trituradas y bacon, acompañado de 2 cervezas",(float)2.5, R.drawable.combo3));
        menu.add(new Combo(4, "Combo amigos","3 hotdogs con pepinillo, guacamoles y papas trituradas, acompañado de 3 cervezas",3, R.drawable.comboamigos));
        Adaptador adapter = new Adaptador(this, menu);
        menuCombo.setAdapter(adapter);
        //Evento de click del boton
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Combo item:menu) {
                    if (item.isOrdered()){
                        compras.add(item);
                    }
                }
                Gson gson=new Gson();
                String factura=gson.toJson(compras);
                Intent myIntent = new Intent(view.getContext(), Resumen.class);
                myIntent.putExtra("compras",factura);
                startActivity(myIntent);

            }
        });

        //Seleccionar un combo
        menuCombo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                menu.get(i).setOrdered(true);
            }
        });
    }
}
