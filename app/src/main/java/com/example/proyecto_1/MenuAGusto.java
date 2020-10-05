package com.example.proyecto_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuAGusto extends AppCompatActivity {
    Spinner spnPrincipal, spnAcom, spnBebida;
    Button btnSiguiente;
    TextView txtprecio1,txtprecio2,txtprecio3;
    Float total, principal,acompa,bebida;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_tu_gusto);
        total=(float)0.0;
        principal=(float)0.0;
        acompa=(float)0.0;
        bebida=(float)0.0;

        final String user = getIntent().getStringExtra("user");
        //Spinners
        spnPrincipal = findViewById(R.id.spnPrincipal);
        spnAcom= findViewById(R.id.spnAcom);
        spnBebida = findViewById(R.id.spnBebida);
        //Boton
        btnSiguiente = findViewById(R.id.btnSiguiente);
        txtprecio1=findViewById(R.id.txtprecio1);
        txtprecio2=findViewById(R.id.txtprecio2);
        txtprecio3=findViewById(R.id.txtprecio3);

        //Poblando los spinners
        String[] principales = {"-","Pizza", "Hot Dog", "Hamburguesa"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android
                .R.layout.simple_spinner_item, principales);
        spnPrincipal.setAdapter(adapter);
        spnPrincipal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==1){
                    txtprecio1.setText("El precio es: B/.5.00");
                    principal=(float)5;
                }else if (i==2){
                    txtprecio1.setText("El precio es: B/.3.00");
                    principal=(float)3;
                }else if (i==3){
                    txtprecio1.setText("El precio es: B/.7.00");
                    principal=(float)7;
                }
                total=principal+bebida+acompa;

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        final String[] acom = {"-","Papitas", "Papas fritas", "Yuca"};
        adapter = new ArrayAdapter<String>(this, android
                .R.layout.simple_spinner_item, acom);
        spnAcom.setAdapter(adapter);
        spnAcom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==1){
                    txtprecio2.setText("El precio es: B/.2.00" );
                    acompa=(float)2;
                }else if (i==2){
                    txtprecio2.setText("El precio es: B/.3.00" );
                    acompa=(float)3;
                }else if (i==3){
                    txtprecio2.setText("El precio es: B/.2.50" );
                    acompa=(float)2.5;
                }
                total=principal+bebida+acompa;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        final String[] bebidas = {"-","Agua", "Heineken", "Coca-Cola"};
        adapter = new ArrayAdapter<String>(this, android
                .R.layout.simple_spinner_item, bebidas);
        spnBebida.setAdapter(adapter);
        spnBebida.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==1){
                    txtprecio3.setText("El precio es: B/.1.50" );
                    bebida=(float)1.5;
                }else if (i==2){
                    txtprecio3.setText("El precio es: B/.2.00" );
                    bebida=(float)2;
                }else if (i==3){
                    txtprecio3.setText("El precio es: B/.1.00" );
                    bebida=(float)1;
                }
                total=principal+bebida+acompa;

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //Evento de click del boton
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Resumen.class);
                myIntent.putExtra("total", total);
                myIntent.putExtra("user", user);
                startActivity(myIntent);
            }
        });
    }
}
