package webVistas;

import datos.ClienteDaoJDBC;
import dominiosJavaBeans.Cliente;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author tonym
 */
@WebServlet(name = "ServerControlador", urlPatterns = {"/ServerControlador"})
public class ServletControladorCliente extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion=request.getParameter("accion");
        if(accion != null){
        switch(accion){
            case "editar":
                this.editarCliente(request, response);break;
            case "eliminar":
                this.eliminarCliente(request, response);break;
            default:
                this.accionDefault(request, response);
        }
        }else{
        this.accionDefault(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion=request.getParameter("accion");
        if(accion != null){
        switch(accion){
            case "insertar":
                this.insertarCliente(request, response);break;
            case "modificar":
                this.modificarCliente(request, response);break;
            case "eliminar":
                this.eliminarCliente(request, response);break;
            default:
                this.accionDefault(request, response);
        }
        }else{
        this.accionDefault(request, response);
        }
    }
     
    protected void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cliente> clientes = new ClienteDaoJDBC().listar();
        System.out.println("cliente = "+ clientes);// para ver en consola 
        HttpSession sesion=request.getSession();
        
        sesion.setAttribute("clientes", clientes);
        //sesion.setAttribute("TotalClientes", clientes);
        //sesion.setAttribute("TotalClientes", this.calcularSaldoP(clientes));
        
        response.sendRedirect("cliente.jsp");
    }
    
    protected void editarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCliente = Integer.parseInt(request.getParameter("idcliente"));
        Cliente cliente = new ClienteDaoJDBC().buscar(new Cliente(idCliente));
        request.setAttribute("cliente", cliente);
        String jspEditar="WEB-INF/paginas/clientes/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }
    
    protected void modificarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCliente = Integer.parseInt(request.getParameter("idcliente"));
        String nombre= request.getParameter("nombre");
        Cliente cliente = new Cliente(idCliente, nombre);
        int resgistroModificados = new ClienteDaoJDBC().update(cliente);
        this.accionDefault(request, response);
        //double saldo = 0;
        //String saldoString = request.getParameter("saldo");
        //if(saldoString != null && !"".equals(saldoString))
        //saldo = Double.parseDouble(saldoString);   
    }
    
    protected void insertarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //int idPersona = Integer.parseInt(request.getParameter("idPersona"));
        String nombre= request.getParameter("nombre");
        Cliente cliente = new Cliente(nombre);
        int resgistroModificados = new ClienteDaoJDBC().insert(cliente);
        this.accionDefault(request, response);
        //double saldo = 0;
        //String saldoString = request.getParameter("saldo");
        //if(saldoString != null && !"".equals(saldoString))
        //saldo = Double.parseDouble(saldoString);   
    }
    
    protected void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCliente = Integer.parseInt(request.getParameter("idcliente"));
        Cliente cliente = new Cliente(idCliente);
        int registroModificado = new ClienteDaoJDBC().delete(cliente);
        this.accionDefault(request, response);
        
    }
   /*private double calcularSaldoTotalP(){
    double saldoTotal = 0;
    for(Persona persona: personas){
    saldoTotal+=persona.getSaldo();
        }
    return saldoTotal;
    }*/

}
