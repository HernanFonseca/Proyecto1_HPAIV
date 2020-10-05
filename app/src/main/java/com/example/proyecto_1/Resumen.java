package com.example.proyecto_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Resumen extends AppCompatActivity {
    private ListView listaCompras;
    String lista;
    Button btnSiguiente;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resumen_compra);
        //listaCompras =findViewById(R.id.listaResumen);
        btnSiguiente =findViewById(R.id.btnConfirmar);
        lista=getIntent().getStringExtra("compras");
        // Averiguar cómo conseguir la información seleccionada en la página anterior
        //Evento de click del boton

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.pedido_confirmado);
            }
        });
    }
}
