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
    private float total;
    Button btnSiguiente;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_combo);
        menuCombo=findViewById(R.id.listaCombos);
        btnSiguiente=findViewById(R.id.btnSiguiente);
        menu=new ArrayList<Combo>();
        total=0;
        menu.add(new Combo(1, "Hamburgueson","Doble carne con queso y bacon, con papas y  cerveza",15,4, R.drawable.combo1));
        menu.add(new Combo(2, "Pizza delicia","Pimenton, cebolla morada, hongos y peperoni y cerveza",16, 4, R.drawable.combo2));
        menu.add(new Combo(3, "Team Hotdog","2 HD con salsas, papas trituradas y bacon y 2 cervezas",18,(float)2.5, R.drawable.combo3));
        menu.add(new Combo(4, "Combo amigos","3 HD con pepinillo, guacamoles y papas y 3 cervezas",25,3, R.drawable.comboamigos));
        Adaptador adapter = new Adaptador(this, menu);
        menuCombo.setAdapter(adapter);

        final String user = getIntent().getStringExtra("user");
        //Evento de click del boton
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Combo item:menu) {
                    if (item.isOrdered()){
                        total+=item.getPrecio();
                    }
                }
                Intent myIntent = new Intent(view.getContext(), Resumen.class);
                myIntent.putExtra("total",total);
                myIntent.putExtra("user", user);
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
