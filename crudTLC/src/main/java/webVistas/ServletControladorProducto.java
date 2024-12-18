package webVistas;

import datos.ProductoDaoJDBC;
import dominiosJavaBeans.Producto;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@WebServlet(name = "ServletControladorProducto", urlPatterns = {"/ServletControladorProducto"})
public class ServletControladorProducto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarProducto(request, response);
                    break;
                case "eliminar":
                    this.eliminarProducto(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarProducto(request, response);
                    break;
                case "modificar":
                    this.modificarProducto(request, response);
                    break;
                case "eliminar":
                    this.eliminarProducto(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    protected void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Producto> productos = new ProductoDaoJDBC().listar(); 
        HttpSession sesion=request.getSession();
        sesion.setAttribute("productos", productos);
        response.sendRedirect("Producto.jsp");
    }

    protected void editarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idProducto = Integer.parseInt(request.getParameter("idproducto"));
        Producto producto = new ProductoDaoJDBC().buscar(new Producto(idProducto));
        request.setAttribute("producto", producto);
        String jspEditar = "WEB-INF/paginas/productos/editarProducto.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    protected void modificarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idProducto = Integer.parseInt(request.getParameter("idproducto"));
        String nombre = request.getParameter("nombre");
        Producto producto = new Producto(idProducto, nombre);
        int resgistroModificados = new ProductoDaoJDBC().update(producto);
        this.accionDefault(request, response);

    }

    protected void insertarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        Producto producto = new Producto(nombre);
        int resgistroModificados = new ProductoDaoJDBC().insert(producto);
        this.accionDefault(request, response);

    }

    protected void eliminarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idProducto = Integer.parseInt(request.getParameter("idproducto"));
        Producto producto = new Producto(idProducto);
        int registroModificado = new ProductoDaoJDBC().delete(producto);
        this.accionDefault(request, response);

    }

}
