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

@WebServlet(urlPatterns = "/detalhesProduto")
public class DetalhesProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        final Long codigo = Long.valueOf(request.getParameter("codigo"));
        final Produto produto = new ProdutoDao().buscarPorCodigo(codigo);

        request.setAttribute("produto", produto);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/produto/formulario.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long codigo = null;

        if (request.getParameter("codigo") != null) {
            codigo = Long.valueOf(request.getParameter("codigo"));
        }

        String descricao = request.getParameter("descricao");
        String marca = request.getParameter("marca");
        Double preco = NumberUtil.parseDouble(request.getParameter("preco")).orElse(0.0);

        if (codigo != null) {

            Produto produto = new ProdutoDao().buscarPorCodigo(codigo);

            produto.setDescricao(descricao.trim());
            produto.setMarca(marca.trim());
            produto.setPreco(preco);

            new ProdutoDao().atualizar(produto);

            response.sendRedirect("listaProdutos");
        }
    }
}
