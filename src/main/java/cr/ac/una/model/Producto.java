package cr.ac.una.model;

public class Producto {

    public Producto(String codigo, String nombre, Float costo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.costo = costo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Producto [codigo=" + codigo + ", costo=" + costo + ", nombre=" + nombre + "]";
    }

    private String codigo;
    private String nombre;
    private Float costo;
}
