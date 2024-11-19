package Clase_12.Actividad_4;

class Usuario {
    private int id;
    private String nombre;


    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


    public int getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }


    @Override
    public String toString() {
        return nombre + " (ID: " + id + ")";
    }
}