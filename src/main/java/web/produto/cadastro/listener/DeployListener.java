package web.produto.cadastro.listener;

import web.produto.cadastro.jdbc.JdbcManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.InputStream;
import java.sql.Connection;

public class DeployListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent contextEvent) {
        JdbcManager jdbcManager = new JdbcManager();

        Connection conn = jdbcManager.iniciarConexaoPadrao();

        if (jdbcManager.testarConexao(conn)) {
            System.out.println("Conexão com o banco de dados estabelecida!");

            InputStream sqlScript = getClass().getClassLoader().getResourceAsStream("sql/script/script-create.sql");
            jdbcManager.executarScript(conn, sqlScript);
        }

        jdbcManager.fecharConexao(conn);
    }
}
