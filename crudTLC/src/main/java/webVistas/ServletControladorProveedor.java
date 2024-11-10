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
        //Creando un ArrayList para llamar al metodo mostrar proveedores
        ArrayList<Proveedor> proveedores = ProveedorDaoJDBC.mostrarProveedores();
        //Introducir los datos en el request para enviarlo al cliente
        request.setAttribute("proveedores", proveedores);
        RequestDispatcher rd = request.getRequestDispatcher("proveedor.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Probando metodo insertProveedor
        String mensaje;
        Proveedor proveedor = new Proveedor();
        String nombre = request.getParameter("nombre");
        proveedor.setNombre(nombre);
        int isInserted = ProveedorDaoJDBC.insertProveerdores(proveedor);
        if(isInserted == 1){
           mensaje = "El proveerdor se ha agregado correctamente";
        }else{
            mensaje = "No se a agregado ningún proveedor";
        }
        request.setAttribute("mensaje", mensaje);
        RequestDispatcher rd = request.getRequestDispatcher("confirmResp.jsp");
        rd.forward(request, response);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
