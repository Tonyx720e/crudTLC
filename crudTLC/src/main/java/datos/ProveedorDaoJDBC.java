package datos;
import java.util.ArrayList;
import dominiosJavaBeans.Proveedor;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import datos.Conexion;
import java.sql.Connection;
import java.sql.SQLException;


/**
 *
 * @author luisa
 */
public class ProveedorDaoJDBC {

    public static final String SELECT = "SELECT idproveedor,nombre FROM proveedor;";
    public static final String INSERT = "INSERT INTO `appmvcmodule3`.`proveedor` (`idproveedor`, `nombre`) VALUES ('202411701', 'Tony')";
    public static final String BUSCAR_POR_ID = "";
    public static final String UPDATE = "";
    public static final String DELETE = "";
    
    //Crear metodo para ingrasar personas
public static List<Proveedor> listar(){
Connection conn = null;
Statement st = null;
ResultSet rs = null;

List<Proveedor> proveedores = new ArrayList<>();
try{
    conn = Conexion.getConnection();
    st = conn.prepareStatement(SELECT);
    rs = st.executeQuery(SELECT);
    
    while(rs.next()){
       int idProveedor = rs.getInt("idproveedor");
       
       
        System.out.println( rs.getString("nombre"));
    }
}catch(SQLException ex) {
    ex.printStackTrace();    
}
return proveedores;

}
}

