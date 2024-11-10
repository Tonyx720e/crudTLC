package webVistas;

import datos.ProveedorDaoJDBC;
import dominiosJavaBeans.Proveedor;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 *
 * @author luisa
 */
@WebServlet(name = "ServletUpdateProveedor", urlPatterns = {"/ServletUpdateProveedor"})
public class ServletUpdateProveedor extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);        
        Proveedor proveedor = new Proveedor();
        int idproveedor = 4;
        String nombre = "Martin";
        
        proveedor.setNombre(nombre);
        proveedor.setIdproveedor(idproveedor);
        
        int isUpdated = ProveedorDaoJDBC.updateProveerdor(proveedor);
        
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
