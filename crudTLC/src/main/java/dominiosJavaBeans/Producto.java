package dominiosJavaBeans;

public class Producto {

    private int idproducto;
    private String nombre;

    public Producto(int idproducto, String nombre) {
        this.idproducto = idproducto;
        this.nombre = nombre;
    }

    public Producto(int idproducto) {
        this.idproducto = idproducto;
    }

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public Producto() {
    }

    public int getProducto() {
        return idproducto;
    }

    public void setProducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    @Override
    public String toString() {
        return "Producto{" + "idproducto=" + idproducto + ", nombre=" + nombre + '}';
    }

}
