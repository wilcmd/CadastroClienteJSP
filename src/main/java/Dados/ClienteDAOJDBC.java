
package Dados;


import Dominio.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wilqu
 */
public class ClienteDAOJDBC {
  
   private static final String SQL_SELECT = "SELECT * FROM cliente";
  //  private static final String SQL_SELECT = "SELECT idcliente, nome, apelido, email, telefone, saldo FROM cliente";
  private static final String ConsultaID = "CALL ConsultaID()";
   //private static final String SQL_CONSULTA_ID = "SELECT nome, apelido, email, telefone, saldo FROM cliente where idcliente = ?";
  private static final String SQL_CONSULTA_ID = "CALL CADASTRO_CLIENTE()";
    
   private static final String SQL_INSERT = "INSERT INTO cliente (nome, apelido, email, telefone, saldo) VALUES (?,?,?,?,?)";
  ///  private static final String Delete_Cadastro = "CALL Delete_Cadastro()";
   
    private static final String SQL_UPDATE =" update cliente set (nome=?, apelido=?, email=?, telefone=?, saldo=?) where (idcliente =? and nome=?)";
  //  private static final String Atualizar_Cadastro = "CALL Atualizar _Cadastro()";
    
    private static final String SQL_DELETE ="delete from cliente where idcliente =?;";

    public List<Cliente> listar() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            conn = Conexao.getConnection();
            stmt = conn.prepareCall(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int idcliente = rs.getInt("idcliente");
                String nome = rs.getString("nome");
                String apelido = rs.getString("apelido");
                String email = rs.getString("email");
                int telefone = rs.getInt("telefone");
                double saldo = rs.getDouble("saldo");

                cliente = new Cliente(idcliente, nome, apelido, email, telefone, saldo);
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexao.close(rs);
            Conexao.close(stmt);
            Conexao.close(conn);
        }

        return clientes;

    }

    public Cliente BuscarID(Cliente cliente) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexao.getConnection();
            stmt = conn.prepareCall(SQL_CONSULTA_ID);
            stmt.setInt(1, cliente.getIdcliente());
            rs = stmt.executeQuery();
            rs.absolute(1);
            
            String nome = rs.getString("nome");
            String apelido = rs.getString("apelido");
            String email = rs.getString("email");
            int telefone = rs.getInt("telefone");
            double saldo = rs.getDouble("saldo");

            cliente.setNome(nome);
            cliente.setApelido(apelido);
            cliente.setEmail(email);
            cliente.setTelefone(telefone);
            cliente.setSaldo(saldo);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexao.close(rs);
            Conexao.close(stmt);
            Conexao.close(conn);
        }

        return cliente;

    }

    public int inserir(Cliente cliente) {

        Connection conn = null;
        PreparedStatement stmt = null;
        Integer qtdo = 0;

        try {

            conn = Conexao.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getApelido());
            stmt.setString(3,cliente.getEmail());         
            stmt.setInt(4, cliente.getTelefone());
            stmt.setDouble(5, cliente.getSaldo());

            qtdo = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexao.close(stmt);
            Conexao.close(conn);
        }

       return qtdo;

    }

    public int Atualizar(Cliente cliente) {

        Connection conn = null;
        PreparedStatement stmt = null;
        Integer qtdo = 0;

        try {

            conn = Conexao.getConnection();
            stmt = conn.prepareCall(SQL_UPDATE);
            stmt.setInt(1, cliente.getIdcliente());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getApelido());
            stmt.setInt(4, cliente.getTelefone());
            stmt.setDouble(5, cliente.getSaldo());
            stmt.setString(6, cliente.getEmail());

            qtdo = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexao.close(stmt);
            Conexao.close(conn);
        }

        return qtdo;

    }
    
    public int delete(Cliente cliente){
        
        
    Connection conn = null;
        PreparedStatement stmt = null;
        Integer qtdo = 0;

        try {

            conn = Conexao.getConnection();
            stmt = conn.prepareCall(SQL_DELETE);
          
            stmt.setInt(1, cliente.getIdcliente());

            qtdo = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexao.close(stmt);
            Conexao.close(conn);
        }

        return qtdo;
    } 
    
}
