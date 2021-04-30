<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:url value="/cadastrarProduto" var="cadastrarProduto"/>
<c:url value="/detalhesProduto" var="editarProduto"/>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <title>Cadastro de Produto</title>
    </head>
    <body>
        <div class="container" style="margin-top: 20px;">
            <h3>Cadastro de Produto</h3><br>

            <form method="POST" action="
                    <c:if test="${produto == null}">
                        ${cadastrarProduto}
                    </c:if>
                    <c:if test="${produto != null}">
                        ${editarProduto}
                    </c:if>">

                <c:if test="${produto != null}">
                    <input type="hidden" name="codigo" value="<c:out value="${produto.codigo}"/>" />
                </c:if>

                <c:if test="${produto != null}">
                    <div class="form-group">
                        <label for="codigo">Código:</label>

                        <input id="codigo" class="form-control" type="text" name="codigo"
                               value="<c:out value="${produto.codigo}"/>" readonly/>
                    </div>
                </c:if>

                <div class="form-group">
                    <label for="descricao">Descrição:</label>

                    <input id="descricao" class="form-control" type="text" name="descricao"
                           value="<c:out value="${produto.descricao}"/>" placeholder="Nome do produto"/>
                </div>

                <div class="form-group">
                    <label for="marca">Marca:</label>

                    <input id="marca" class="form-control" type="text" name="marca"
                           value="<c:out value="${produto.marca}"/>" placeholder="Marca do produto" />
                </div>

                <div class="form-group">
                    <label for="preco">Preço (R$):</label>

                    <input id="preco" class="form-control" type="number" name="preco" step="0.01"
                           value="<c:out value="${produto.preco}"/>" placeholder="Preço do produto em R$" />
                </div>

                <button class="btn btn-primary" type="submit">Salvar</button>
            </form>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

        <script type="text/javascript">

            $('form').on("submit", function (e) {
                let descricao = document.getElementById('descricao').value;
                let marca = document.getElementById('marca').value;

                if (descricao === undefined || descricao.trim() === "") {
                    alert('Por favor informe uma descrição para o produto.');
                    return false;
                }

                if (marca === undefined || marca.trim() === "") {
                    alert('Por favor informe uma marca para o produto.');
                    return false;
                }

                return true;
            });

        </script>

    </body>
</html>
