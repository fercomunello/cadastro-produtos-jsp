package web.produto.cadastro.servlets.produto;

import web.produto.cadastro.jdbc.dao.ProdutoDao;
import web.produto.cadastro.model.Produto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/listaProdutos")
public class ListaProdutosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        final List<Produto> produtos = new ProdutoDao().buscarTodos();

        request.setAttribute("produtos", produtos);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/produto/lista.jsp");
        dispatcher.forward(request, response);
    }
}
