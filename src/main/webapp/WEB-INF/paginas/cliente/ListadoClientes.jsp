<%-- 
    Document   : ListadoClientes
    Created on : 01/01/2023, 22:25:26
    Author     : wilqu
--%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="pt_BR"/>



<section id="clientes">
    <div class="container">
        <div class="row"> 
            <!-- Tabela dados inicio -->
            <div class="col-md-8"> 
                <div class="card">
                    <div class="card-header">
                        <h2> Lista de Cliente </h2>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark"> <!-- cabecario da tabela inicio-->
                            <tr> 
                                <th>ID </th>
                                <th>NOME</th>
                                <th>APELIDO</th>                                
                                <th>EMAIL</th>
                                <th>FONE</th>
                                <th>SALDO</th>
                                <th> </th>                            
                            </tr>                        

                        </thead>  <!-- cabecario da tabela Fim-->
                        <tbody>

                            <c:forEach var="cliente" items="${clientes}" varStatus="status" >
                                <tr>    

                                    <td> ${status.count} </td>
                                    <td> ${cliente.nome} </td>
                                    <td> ${cliente.apelido} </td>                                      
                                    <td> ${cliente.email} </td>
                                    <td> ${cliente.telefone} </td>
                                    <td> <fmt:formatNumber value="${cliente.saldo}" type="currency"/></td>

                                    <td> 
                                        <a href="${pageContext.request.contextPath}/ServletControlador?action=editar&idcliente=${cliente.idcliente}"
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"> </i>EDITAR
                                        </a>
                                </tr> 
                            </c:forEach>
                        </tbody>                   
                    </table>
                </div>
            </div> <!-- Fim Tabela de Dados-->

            <!-- Tabela total inicio -->
            <div class="col-md-4">
                <div class=" card text-center bg-danger text-white mb-3">  
                    <div class="card-body"> 
                        <h4>Saldo Total </h4>
                        <h6 class="display-4"> 
                            <fmt:formatNumber value="${SaldoTotal}" type="currency"/>                        
                        </h6>                    
                    </div>                
                </div>                
                <!-- Fim Tabel de Total  -->

                <!-- Tabela total User -->
              
                    <div class="card text-center bg-success text-white mb-3">
                        <div class="card-body">
                            <h4> Total Clientes </h4>
                            <h4 class="display-4"> 
                                <i class="fa fa-users"></i> ${totalClientes}                       
                            </h4>
                        </div>
                    </div>          
                </div> <!-- Fim Tabel de Usuario  -->

            </div>      
        </div>  

</section>
                            
          <!-- Cria uma pagina para Adicionar Clintes -->
     
          <jsp:include page="/WEB-INF/paginas/cliente/AdicionarCliente.jsp"/>    



