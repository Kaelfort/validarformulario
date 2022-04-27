package com.example.a25deabril;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etNombre, etApellido,etEmail,etCelular,etcodest;
    private Button btnRegistrar;
    private Switch swEstudiante;
    String nombre;
    String apellido;
    String email;
    String celular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();
        btnRegistrar.setOnClickListener(view -> {obtenerinformacion(); validar();});
        swEstudiante.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mostrarelmensaje(b);


            }
        });

    }

    private void mostrarelmensaje(boolean b) {
        String mensaje="noestoy marcado";
        if(b){
            mensaje="estoymarcado";
        }
        Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();
    }

    private void validar() {
        String mensaje;
        if ((nombre.equals("")) || (apellido.equals("")))
        {
            mensaje = "falta llenar datos";
            Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();

        }else
        {
            mensaje = "nombre: "+nombre+" apellido: "+apellido+" email "+email+" celular:" +celular;
            Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();
        }
    }

    private void obtenerinformacion() {
        nombre=etNombre.getText().toString();
        apellido=etApellido.getText().toString();
        email=etEmail.getText().toString();
        celular=etCelular.getText().toString();

    }

    private void inicializarVistas() {
        etNombre = findViewById(R.id.etNombre);
        etApellido= findViewById(R.id.etApellido);
        etEmail= findViewById(R.id.etEmail);
        etCelular = findViewById(R.id.etCelular);
        etcodest = findViewById(R.id.atcodest);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        swEstudiante= findViewById(R.id.swVerificar);
    }
}