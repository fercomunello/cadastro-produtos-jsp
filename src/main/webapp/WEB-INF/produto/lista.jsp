<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.List" %>
<c:url value="/detalhesProduto" var="editarProduto"/>
<c:url value="/cadastrarProduto" var="cadastrarProduto"/>
<c:url value="/removerProduto" var="removerProduto"/>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <title>Lista de Produtos</title>
    </head>
    <body>
        <div class="container" style="margin-top: 20px;">
            <h3>Lista de Produtos</h3><br>

            <a class="btn btn-success" href="${cadastrarProduto}">Novo Produto</a>

            <table class="table table-hover shadow-sm p-3 mb-5 bg-white rounded" style="margin-top: 20px;">
                <thead class="thead-light">
                <tr>
                    <th scope="col">Código</th>
                    <th scope="col">Descrição</th>
                    <th scope="col">Marca</th>
                    <th scope="col">Preço</th>
                    <th scope="col">Alterar</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="produto" items="${produtos}">
                    <tr>
                        <td>${produto.codigo}</td>
                        <td>${produto.descricao}</td>
                        <td>${produto.marca}</td>
                        <td><fmt:setLocale value="pt_BR" /><fmt:formatNumber type="currency" value="${produto.preco}" /></td>
                        <td>
                            <a href="${editarProduto}?codigo=${produto.codigo}" class="btn btn-primary">
                                Editar
                            </a>

                            <a href="${removerProduto}?codigo=${produto.codigo}" class="btn btn-danger " style="margin-left: 5px;">
                                Deletar
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>