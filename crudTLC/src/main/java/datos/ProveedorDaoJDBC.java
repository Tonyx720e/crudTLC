package datos;

import java.util.ArrayList;
import dominiosJavaBeans.Proveedor;
import java.sql.ResultSet;
import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author luisa
 */
public class ProveedorDaoJDBC {

    public static final String SELECT = "SELECT idproveedor,nombre FROM proveedor;";
    public static final String INSERT = "INSERT INTO proveedor(nombre) values(?);";
    public static final String BUSCAR_POR_ID = "";
    public static final String UPDATE = "";
    public static final String DELETE = "";

    //Crear metodo para mostrar los proveedores de la BD
    public static ArrayList<Proveedor> mostrarProveedores() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        ArrayList<Proveedor> proveedores = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            st = conn.prepareStatement(SELECT);
            rs = st.executeQuery(SELECT);

            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setIdproveedor(rs.getInt("idproveedor"));
                proveedor.setNombre(rs.getString("nombre"));

                proveedores.add(proveedor);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(st);
            Conexion.close(conn);
        }
        return proveedores;
    }
    public static int insertProveerdores(Proveedor proveedores){
        Connection conn = null;
        PreparedStatement st = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            st = conn.prepareStatement(INSERT);
             st.setString(1,proveedores.getNombre()); 
            rows = st.executeUpdate();        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            Conexion.close(st);
            Conexion.close(conn);
        }
        
        return rows; 
    }
   
}
