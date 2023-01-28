<%-- 
    Document   : AdicionarCliente
    Created on : 04/01/2023, 21:23:51
    Author     : wilqu
--%>

<div class="modal fade" id="adicionarClienteModal" > 
    <div class="modal-dialog "> 
        <div class="modal-content "> 
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Adicionar Cliente</h5>
                <button class="close" data-dismiss="modal"> 
                    <samp>&times;</samp>

                </button> 
            </div>



            <form action="${pageContext.request.contextPath}/ServletControlador?action=inserir" 
                  method="POST"  class="was-validated">
                <div class="modal-body">  
                    <div class="form-group">                   
                        <label for="nome">Nome</label>
                        <input type="text" class="form-control" name="name" required >                    
                    </div>

                    <div class="form-group">                   
                        <label for="apelido">Apelido</label>
                        <input type="text" class="form-control" name="apelido" required>                     
                    </div> 

                    <div class="form-group">                   
                        <label for="email">Email</label>
                        <input type="email" class="form-control" name="email" required >                     
                    </div>

                    <div class="form-group">                   
                        <label for="telefone">Fone</label>
                        <input type="number" class="form-control" name="telefone" required >                     
                    </div>

                    <div class="form-group">                   
                        <label for="saldo">Saldo</label>
                        <input type="number" class="form-control" name="saldo" required  step="any">                     
                    </div>  

                    <div class="modal-footer">
                        <button class="btn btn-primary" type="submit">Salvar</button>
                    </div>

                </div>
            </form>
        </div>    
    </div>
</div>