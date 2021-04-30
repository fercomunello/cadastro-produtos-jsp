package web.produto.cadastro.servlets.produto;

import web.produto.cadastro.jdbc.dao.ProdutoDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/removerProduto")
public class RemoverProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        final Long codigo = Long.valueOf(request.getParameter("codigo"));

        new ProdutoDao().remover(codigo);

        response.sendRedirect("listaProdutos");
    }
}
