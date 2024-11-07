package datos;

import dominiosJavaBeans.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoJDBC {

    private static final String SQL_SELECT = "SELECT idcliente, nombre FROM cliente";
    private static final String SQL_POR_ID = "SELECT idcliente, nombre FROM cliente WHERE id_persona = ?";
    private static final String SQL_INSERT = "INSERT INTO cliente (nombre) VALUES(?)";
    private static final String SQL_UPDATE = "UPDATE cliente SET nombre= ? WHERE id_cliente = ? ";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_cliente = ?";

    public List<Cliente> listar() {
        Connection conn = null;
        PreparedStatement stms = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_SELECT);
            rs = stms.executeQuery();
            while (rs.next()) {
                int idcliente = rs.getInt("idcliente");
                String nombre = rs.getString("nombre");
                System.out.println(nombre);
                clientes.add(new Cliente(idcliente, nombre));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stms);
            Conexion.close(conn);
        }
        return clientes;
    }

    public Cliente buscar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stms = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_POR_ID);
            stms.setInt(1, cliente.getIdcliente());
            rs = stms.executeQuery();
            rs.next();

            String nombre = rs.getString("nombre");
            cliente.setNombre(nombre);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stms);
            Conexion.close(conn);
        }
        return cliente;
    }

    public int insert(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stms = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_INSERT);
            stms.setString(1, cliente.getNombre());

            rows = stms.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stms);
            Conexion.close(conn);
        }
        return rows;
    }

    public int update(Cliente cliente) {

        Connection conn = null;
        PreparedStatement stms = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_UPDATE);

            stms.setString(1, cliente.getNombre());
            stms.setInt(2, cliente.getIdcliente());

            rows = stms.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stms);
            Conexion.close(conn);
        }
        return rows;
    }
    public int delete(Cliente cliente){
    Connection conn = null;
        PreparedStatement stms = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_DELETE);
            stms.setInt(1, cliente.getIdcliente());

            rows = stms.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stms);
            Conexion.close(conn);
        }
        return rows;
    }
    public static void main(String[] args){
    ClienteDaoJDBC cliente = new ClienteDaoJDBC();
    cliente.listar();
       
    }
}
