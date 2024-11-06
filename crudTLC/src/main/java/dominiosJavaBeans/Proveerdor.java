package dominiosJavaBeans;

/**
 *
 * @author luisa
 */
public class Proveerdor {
    //Atributos
    private int idproveedor;
    private String nombre;
    
    //Constructores

    public Proveerdor() {
    }

    public Proveerdor(int idproveedor, String nombre) {
        this.idproveedor = idproveedor;
        this.nombre = nombre;
    }    
    //Getters
    public int getIdproveedor() {
        return idproveedor;
    }

    public String getNombre() {
        return nombre;
    }
    //Setters
    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //Métodos    

    @Override
    public String toString() {
        return "Proveerdor{" + "idproveedor=" + idproveedor + ", nombre=" + nombre + '}';
    }
    
}
