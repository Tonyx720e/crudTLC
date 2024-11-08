
package dominiosJavaBeans;

/**
 *
 * @author tonym
 */
public class Cliente {
    private int idcliente;
    private String nombre;

    public Cliente(int idcliente, String nombre) {
        this.idcliente = idcliente;
        this.nombre = nombre;
    }


    public Cliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public Cliente(String nombre) {
        this.nombre = nombre;
    }
    
    public Cliente() {
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
