package com.example.a25deabril;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Atributos que representen a sus views o vistas


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
        btnRegistrar.setOnClickListener(view -> {obtenerinformacion(); /*validar();*/pasarsegundaPantalla();});
        swEstudiante.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mostrarelmensaje(b);


            }
        });


    }
    private void pasarsegundaPantalla(){
            /*para pasa a 2da pantalla deben crear una clase intent,
            como parametros al contructor de esa clase va pasar  2 valores:
            1parametro de donde a donde van a ir
            2parametro a donde o a que pantalla va  a ir
            estos parametros deben representar el contexto o ambito de las clases que representas a esas pantallas
            en realidad el metodo de la pantalla se llama starActivity pero este necesita que el intent
            haya resuelto el paso de pantallas caso contrario fallará

             */
        Intent intencion = new Intent(this, HomeActivity.class); //o MainActivity.this
        /*las intenciones a enviar son datos primitivos que son string, int ,float, bool, char, etc*/
        /*
        1 el intent tien un archivo tempoal, pueden entender que el archivo
        2 el archivo contiene  registos del formato CLAVE(key) --> Valor
        3 elcada registro debe tener un dato especifico
        4 el dato solo puede ser de tipo primitivo
        5 cada registro se entiende como EXTRA
         */
        //generar registro Clave -->valor
        intencion.putExtra("nombre_persona", nombre);
        intencion.putExtra("apellido_persona", apellido);
        startActivity(intencion);
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