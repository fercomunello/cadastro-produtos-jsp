package web.produto.cadastro.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = "/teste", loadOnStartup = 1)
public class TesteServlet extends HttpServlet {

    public TesteServlet() {
        System.out.println("Servlet " + getClass().getName() + " foi carregado.");
    }
}
