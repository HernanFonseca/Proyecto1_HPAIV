package com.example.proyecto_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MenuAGusto extends AppCompatActivity {
    Spinner spnPrincipal, spnAcom, spnBebida;
    Button btnSiguiente;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_tu_gusto);
        //Spinners
        spnPrincipal = findViewById(R.id.spnPrincipal);
        spnAcom= findViewById(R.id.spnAcom);
        spnBebida = findViewById(R.id.spnBebida);
        //Boton
        btnSiguiente = findViewById(R.id.btnSiguiente);

        //Poblando los spinners
        String[] principales = {"Pizza", "Hot Dog", "Hamburguesa"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android
                .R.layout.simple_spinner_item, principales);
        spnPrincipal.setAdapter(adapter);

        String[] acom = {"Papitas", "Papas fritas", "Yuca"};
        adapter = new ArrayAdapter<String>(this, android
                .R.layout.simple_spinner_item, acom);
        spnAcom.setAdapter(adapter);

        String[] bebidas = {"Agua", "Heineken", "Coca-Cola"};
        adapter = new ArrayAdapter<String>(this, android
                .R.layout.simple_spinner_item, bebidas);
        spnBebida.setAdapter(adapter);

        //Evento de click del boton
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Resumen.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
}
