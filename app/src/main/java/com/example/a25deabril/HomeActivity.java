package com.example.a25deabril;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView txtResultado;
    String nombre, apellido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        inicializarvistas();
        obtenerdatosprimerapantalla();
        mostrardatos();
    }

    private void mostrardatos() {
        txtResultado.setText(nombre+ " "+apellido);
    }

    private void obtenerdatosprimerapantalla() {
        nombre = this.getIntent().getExtras().getString("nombre_persona", "");
        apellido = this.getIntent().getExtras().getString("apellido_persona", "");

    }

    private void inicializarvistas() {
        txtResultado = findViewById(R.id.txtResultado);
    }
}