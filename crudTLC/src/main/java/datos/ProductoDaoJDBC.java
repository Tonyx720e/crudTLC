package datos;
import dominiosJavaBeans.Producto;
import jakarta.ws.rs.DELETE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDaoJDBC {
  
    private static final String SQL_SELECT = "SELECT idproducto,nombre FROM producto;";
    private static final String SQL_POR_ID = "SELECT idproducto, nombre FROM producto WHERE idproducto = ?";
    private static final String SQL_INSERT = "INSERT INTO producto(nombre) values(?);";
    private static final String SQL__UPDATE = "UPDATE `producto` SET `nombre` = ? WHERE (`idproducto` = ?)";
    private static final String SQL_DELETE = "DELETE FROM `appmvcmodulo3`.`producto` WHERE (`idproducto` = ?)";
   
    public List<Producto> listar() {
        Connection conn = null;
        PreparedStatement stms = null;
        ResultSet rs = null;
        List<Producto> productos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_SELECT);
            rs = stms.executeQuery();
            while (rs.next()) {
                int idproducto = rs.getInt("idproducto");
                String nombre = rs.getString("nombre");
                System.out.println(nombre);
                productos.add(new Producto(idproducto, nombre));
            }
        } catch (SQLException e) {
                e.printStackTrace(System.out);
            } finally {
                Conexion.close(rs);
                Conexion.close(stms);
                Conexion.close(conn);
            }
            return productos;
        }
    public Producto buscar(Producto producto) {
        Connection conn = null;
        PreparedStatement stms = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_POR_ID);
            stms.setInt(1, producto.getIdproducto());
            rs = stms.executeQuery();
            rs.next();

            String nombre = rs.getString("nombre");
            producto.setNombre(nombre);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stms);
            Conexion.close(conn);
        }
        return producto;
    }
        public int insert(Producto producto) {
        Connection conn = null;
        PreparedStatement stms = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_INSERT);
            stms.setString(1, producto.getNombre());

            rows = stms.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stms);
            Conexion.close(conn);
        }
        return rows;
    }

    }








  



