
package Dominio;

/**
 *
 * @author wilqu
 */
public class Cliente {
    
    private int idcliente; 
    private String nome;
    private String apelido;
    private String email;
    private int telefone;
    private double saldo;

    
    public Cliente() {
    }
    
    public Cliente(int idcliente) {
        this.idcliente =idcliente;

    }
    
    public Cliente(int idcliente, String nome, String apelido, String email, int telefone, double saldo) {
        this.idcliente = idcliente;
        this.nome = nome;
        this.apelido = apelido;
        this.email = email;
        this.telefone = telefone;
        this.saldo = saldo;
    }



    public Cliente(String nome, String apelido, String email, int telefone, double saldo) {
        this.nome = nome;
        this.apelido = apelido;
        this.email = email;
        this.telefone = telefone;
        this.saldo = saldo;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    

  

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("idcliente=").append(idcliente);
        sb.append(", nome=").append(nome);
        sb.append(", apelido=").append(apelido);
        sb.append(", email=").append(email);
        sb.append(", telefone=").append(telefone);
        sb.append(", saldo=").append(saldo);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
}
