package webVistas;

import datos.ProveedorDaoJDBC;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import dominiosJavaBeans.Proveedor;

/**
 *
 * @author luisa
 */
@WebServlet(name = "ServletControladorProveedor", urlPatterns = {"/ServletControladorProveedor"})
public class ServletControladorProveedor extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }
       @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Proveedor> proveedores =  ProveedorDaoJDBC.mostrarProveedores();
        //Introducir los datos en el request para enviarlo al cliente
        request.setAttribute("proveerdores",proveedores);
           RequestDispatcher rd = request.getRequestDispatcher("proveedor.jsp");
           rd.forward(request, response);
       
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
