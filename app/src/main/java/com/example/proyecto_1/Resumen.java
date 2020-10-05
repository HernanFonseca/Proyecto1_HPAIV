package com.example.proyecto_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.Calendar;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Resumen extends AppCompatActivity {
    private ListView listaCompras;
    String lista;
    Button btnSiguiente;
    private TextView fecha, hora;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resumen_compra);
        //listaCompras =findViewById(R.id.listaResumen);
        btnSiguiente =findViewById(R.id.btnConfirmar);
        lista=getIntent().getStringExtra("compras");
        fecha=findViewById(R.id.txtFecha);
        hora=findViewById(R.id.txtHora);
        // Averiguar cómo conseguir la información seleccionada en la página anterior
        //Evento de click del boton
        fecha.setText(Calendar.getInstance().DATE);
        hora.setText(Calendar.getInstance().HOUR_OF_DAY);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.pedido_confirmado);
            }
        });
    }
}
