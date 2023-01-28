package web;

import Dados.ClienteDAOJDBC;
import Dominio.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author wilqu
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "editar":
                    this.editarCliente(request, response);
                    break;

                default:
                    this.acionDefault(request, response);

            }
        } else {

            this.acionDefault(request, response);

        }

    }

    protected void acionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // por modo de seguranca e reutilização de o codigo baixo, os cogido o método doGet
        //foram colocado neste método que esta sendo chamdo pelo método doGet a cima
        List<Cliente> cliente = new ClienteDAOJDBC().listar();
        System.out.println("Clientes : " + cliente);
        HttpSession session = request.getSession();

        session.setAttribute("clientes", cliente);

        session.setAttribute("totalClientes", cliente.size()); //total Clientes
        session.setAttribute("SaldoTotal", calcularTotal(cliente));

        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
        response.sendRedirect("clientes.jsp");

    }

    private double calcularTotal(List<Cliente> cliente) {

        double saldototal = 0;

        for (Cliente clientes : cliente) {
            saldototal += clientes.getSaldo();
        }
        return saldototal;

    }

   private void editarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        int idcliente = Integer.parseInt(request.getParameter("idcliente"));
        Cliente cliente = new ClienteDAOJDBC().BuscarID(new Cliente(idcliente));
        request.setAttribute("cliente", cliente);
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
       request.getRequestDispatcher(jspEditar).forward(request, response);

       //response.sendRedirect("editarCiente.jsp");
    }

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "inserir":
                    this.inserirCliente(request, response);
                    break;

                default:
                    this.acionDefault(request, response);

            }
        } else {

            this.acionDefault(request, response);

        }

    }

    protected void inserirCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ///  recuper o s valorees do formulario do adicionar cliente 
        String _nome = request.getParameter("name");
        String _apelido = request.getParameter("apelido");
        String _email = request.getParameter("email");
        int _fone = 0;
        String Sfone = request.getParameter("telefone");
        double _saldo = 0;
        String Ssaldo = request.getParameter("saldo");

        if (Sfone != null && !"".equals(Sfone)) {
            _fone = Integer.parseInt(Sfone);
        }
        if (Ssaldo != null && !"".equals(Ssaldo)) {
            _saldo = Double.parseDouble(Ssaldo);
        }

        // Crinado el objeto Cliente pprocessado no formulario
        Cliente cliente = new Cliente(_nome, _apelido, _email, _fone, _saldo);

        int registroModificado = new ClienteDAOJDBC().inserir(cliente);

        System.out.println("registroModificado");

        this.acionDefault(request, response);

    }

}
