package Modelo;

public class producto {

    private int código;
    private String nombre;
    private double precio;

    public producto() {
    }

    public producto(int código, String nombre, double precio) {
        this.código = código;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getCódigo() {
        return código;
    }

    public void setCódigo(int código) {
        this.código = código;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
