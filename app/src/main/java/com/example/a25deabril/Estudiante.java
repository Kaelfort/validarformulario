package com.example.a25deabril;
//clases POJO Plane of java object
public class Estudiante {
    private String Nombre;
    private String Apellido;
    private String Email;
    private int Celular;
    private int Nota;

    public Estudiante(String nombre, String apellido, String email, int celular, int nota) {
        
        Nombre = nombre;
        Apellido = apellido;
        Email = email;
        Celular = celular;
        Nota = nota;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getEmail() {
        return Email;
    }

    public int getCelular() {
        return Celular;
    }

    public int getNota() {
        return Nota;
    }
}
