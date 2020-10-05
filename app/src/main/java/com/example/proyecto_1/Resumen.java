package com.example.proyecto_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

public class Resumen extends AppCompatActivity {
    private ListView listaCompras;
    String lista;
    Button btnSiguiente;
    private TextView fecha, monto, tvUser;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resumen_compra);
        //listaCompras =findViewById(R.id.listaResumen);
        btnSiguiente =findViewById(R.id.btnConfirmar);
        lista=getIntent().getStringExtra("compras");
        fecha=findViewById(R.id.txtFecha);
        tvUser = findViewById(R.id.txtusuario);
        String user=getIntent().getStringExtra("user");
        tvUser.setText(user);
        monto=findViewById(R.id.txtmonto);
        monto.setText(monto.getText().toString()+getIntent().getFloatExtra("total",0));

        // Averiguar cómo conseguir la información seleccionada en la página anterior
        //Evento de click del boton
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        fecha.setText(currentDateTimeString);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.pedido_confirmado);
            }
        });
    }
}
