package datos;

import dominio.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDaoJDBC {

    private static final String SQL_SELECT = "SELECT id_persona, nombre FROM persona";
    private static final String SQL_POR_ID = "SELECT id_persona, nombre FROM persona WHERE id_persona = ?";
    private static final String SQL_INSERT = "INSERT INTO persona (nombre) VALUES(?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre= ? WHERE id_persona = ? ";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";

    public List<Persona> listar() {
        Connection conn = null;
        PreparedStatement stms = null;
        ResultSet rs = null;
        List<Persona> personas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_SELECT);
            rs = stms.executeQuery();
            while (rs.next()) {
                int id_persona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                System.out.println(nombre);
                personas.add(new Persona(id_persona, nombre));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stms);
            Conexion.close(conn);
        }
        return personas;
    }

    public Persona buscar(Persona persona) {
        Connection conn = null;
        PreparedStatement stms = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_POR_ID);
            stms.setInt(1, persona.getId_persona());
            rs = stms.executeQuery();
            rs.next();

            String nombre = rs.getString("nombre");
            persona.setNombre(nombre);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stms);
            Conexion.close(conn);
        }
        return persona;
    }

    public int insert(Persona persona) {
        Connection conn = null;
        PreparedStatement stms = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_INSERT);
            stms.setString(1, persona.getNombre());

            rows = stms.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stms);
            Conexion.close(conn);
        }
        return rows;
    }

    public int update(Persona persona) {

        Connection conn = null;
        PreparedStatement stms = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_UPDATE);

            stms.setString(1, persona.getNombre());
            stms.setInt(2, persona.getId_persona());

            rows = stms.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stms);
            Conexion.close(conn);
        }
        return rows;
    }
    public int delete(Persona persona){
    Connection conn = null;
        PreparedStatement stms = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_DELETE);
            stms.setInt(1, persona.getId_persona());

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
    PersonaDaoJDBC persona = new PersonaDaoJDBC();
    persona.listar();
       
    }
}
