package webVistas;

import datos.ProveedorDaoJDBC;
import dominiosJavaBeans.Proveedor;
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
@WebServlet(name = "ServletUpdateProveedor", urlPatterns = {"/ServletUpdateProveedor"})
public class ServletUpdateProveedor extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String newNombre = request.getParameter("newNombre");
        int id = Integer.parseInt(request.getParameter("id"));

        request.setAttribute("newNombre", newNombre);
        request.setAttribute("id", id);
        RequestDispatcher rd = request.getRequestDispatcher("UpdateProveedor.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Proveedor proveedor = new Proveedor();
        int idproveedor = Integer.parseInt(request.getParameter("id"));
        String newNombre = request.getParameter("nombre");
        String mensaje;

        proveedor.setNombre(newNombre);
        proveedor.setIdproveedor(idproveedor);

        int isUpdated = ProveedorDaoJDBC.updateProveerdor(proveedor);

        if (isUpdated == 1) {
            mensaje = "El proveerdor se ha modificado correctamente";
        } else {
            mensaje = "No se ha modificado ningún proveedor";
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
