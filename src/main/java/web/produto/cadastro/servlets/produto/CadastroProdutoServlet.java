package web.produto.cadastro.servlets.produto;

import web.produto.cadastro.jdbc.dao.ProdutoDao;
import web.produto.cadastro.model.Produto;
import web.produto.cadastro.util.NumberUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/cadastrarProduto")
public class CadastroProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/produto/formulario.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String descricao = request.getParameter("descricao");
        String marca = request.getParameter("marca");
        Double preco = NumberUtil.parseDouble(request.getParameter("preco")).orElse(0.0);

        Produto produto = new Produto();

        produto.setDescricao(descricao.trim());
        produto.setMarca(marca.trim());
        produto.setPreco(preco);

        new ProdutoDao().salvar(produto);

        response.sendRedirect("listaProdutos");
    }
}
