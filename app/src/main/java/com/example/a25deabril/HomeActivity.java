package com.example.a25deabril;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class HomeActivity extends AppCompatActivity {
    private TextView txtResultado;
    private Button btnCalcular;
    private Spinner spOpciones;
    String nombre, apellido;
    int random;
    ArrayList opciones = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);//R clase que registra sus recursos
        inicializarvistas();
        obtenerdatosprimerapantalla();
        mostrardatos();
        //cargar y configurará el spiner
        obtenerFuentedeDAtos();
        cargarDatosSpinner();
        btnCalcular.setOnClickListener(view -> {procesarDatosSpinner();});
    }
    private void procesarDatosSpinner() {
        //su valor en formato en String
        String valor = spOpciones.getSelectedItem().toString();
        //2 su pocision en el Spinner, salvo el indice del spinner coinsida con el indice del array
        int posicion = spOpciones.getSelectedItemPosition();

        /*
        switch (valor){
            case "Notas":
                break;
        }*/
        //mejor a usar
        switch (posicion){
            case 0:
            break;
            case 1:
                break;
            case 2:
                break;
            case 3: figonacci();
                break;
            case 4:
                break;
            default:
                break;

        }
    }

    private void figonacci() {

        double Rand;
        Rand = Math.floor(Math.random() * (10 - 0 + 1)) + 0;





    }

    private void obtenerFuentedeDAtos() {

        opciones = new ArrayList<>(Arrays.asList("seleccione la opción","notas","faltas"));//otra forma de añadir
        //agregar un elemento a la lista .add
        //agregar la lista a un bucle que registre todos sus registros de la consulta
        opciones.add("mejor opción");//una forma de añadir
    }

    private void cargarDatosSpinner() {
        /*
        para cargar datos al spinner donde cada elemento u opcion del espiner se conoce como ITEM...
        necesitan un adaptador -> un transformador que convirte una funte de datos en elementos visuales
        views es como un puente donde el extremo inicial es la estructura de datos con su informacion y
        el otro lado del puente es el componente visual
        spinner que recibe sus datos convertidos en vistas
        Hay adaptadores por defectos ya diseñados y hay adpatadores que tienen que configurar desde cero.
        por cada elemnto de su lista se genera un avista gracias al adapted . Array(10) => adaptador genera 10 vistas
         */
        //array adpater necesita unos parametros de configuracion para realizar el proceso de transformaciion
        //1. contexto de pantalla  dibujar estos elementos visulaes
        /*
        2. referencia a l componente visual o layout que se ha diseñado o usara para dibujar cada item o elemento
        que diseño quieres que se dibuje con cada elemento de tuarray
        3. la estructura que contiene su fuente de datos
         */

        ArrayAdapter<String> Adaptador = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                opciones
        );
        // el espiner necesita un adaptador para que este me diga cuantas vitas va a acoplar a su structutra
        spOpciones.setAdapter(Adaptador);
    }

    private void mostrardatos() {
        txtResultado.setText(nombre+ "  "+apellido);
    }

    private void obtenerdatosprimerapantalla() {
        nombre = this.getIntent().getExtras().getString("nombre_persona", "");
        apellido = this.getIntent().getExtras().getString("apellido_persona", "");

    }

    private void inicializarvistas() {
        txtResultado = findViewById(R.id.txtResultado);
        spOpciones = findViewById(R.id.spOpciones);
        btnCalcular = findViewById(R.id.btnCalcular);
    }
}