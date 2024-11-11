package webVistas;

import datos.ProveedorDaoJDBC;
import jakarta.servlet.RequestDispatcher;
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
@WebServlet(name = "ServletDeleteProveedor", urlPatterns = {"/ServletDeleteProveedor"})
public class ServletDeleteProveedor extends HttpServlet {

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("newNombre");
        int id = Integer.parseInt(request.getParameter("id"));
        
        request.setAttribute("id", id);
        request.setAttribute("nombre",nombre);
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/paginas/proveedor/DeleteProveedor.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        String nombre = request.getParameter("nombre");
        int idProveedor = Integer.parseInt(request.getParameter("id"));
        String mensaje;
        
        int isDeleted = ProveedorDaoJDBC.deleteProveedor(idProveedor);
        
        if (isDeleted == 1) {
            mensaje = "El proveerdor " + nombre + " se ha eliminado correctamente";
        } else {
            mensaje = "El proveedor " + nombre + " no se ha eliminado  ";
        }
        request.setAttribute("mensaje", mensaje);
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/paginas/proveedor/confirmResp.jsp");
        rd.forward(request, response);
               
    }

     @Override
    public String getServletInfo() {
        return "Short description";
    }

}
