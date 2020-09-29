package com.example.proyecto_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TipoPedido extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tipo_pedido);
        final RadioButton rdbCombo=findViewById(R.id.rdbCombo);
        final RadioButton rdbAGusto=findViewById(R.id.rdbAGusto);
        Button btnSiguiente=findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rdbCombo.isChecked()){
                    Intent myIntent = new Intent(view.getContext(), MenuCombo.class);
                    startActivity(myIntent);
                }else if (rdbAGusto.isChecked()){
                    Intent myIntent = new Intent(view.getContext(), MenuAGusto.class);
                    startActivity(myIntent);
                }else{
                    Toast.makeText(getApplicationContext(), "F en el chat",
                            Toast.LENGTH_SHORT)
                            .show();
                }

            }
        });
    }
}
