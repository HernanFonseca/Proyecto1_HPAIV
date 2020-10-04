package com.example.proyecto_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MenuCombo extends AppCompatActivity {
    private ListView menuCombo;
    ArrayList<Combo> menu;
    Button btnSiguiente;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_combo);
        menuCombo=findViewById(R.id.listaCombos);
        btnSiguiente=findViewById(R.id.btnSiguiente);
        menu=new ArrayList<Combo>();
        menu.add(new Combo(1, "Cool","Coolness and spice",4, R.drawable.combo_1));
        menu.add(new Combo(2, "Very Cool","Coolness and spice",5, R.drawable.combo_1));
        menu.add(new Combo(3, "Hot","Coolness and spice",(float)2.5, R.drawable.combo_1));
        menu.add(new Combo(4, "Very Hot","Coolness and spice",3, R.drawable.combo_1));
        Adaptador adapter = new Adaptador(this, menu);
        menuCombo.setAdapter(adapter);
        //Evento de click del boton
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Resumen.class);
                startActivityForResult(myIntent, 0);
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
