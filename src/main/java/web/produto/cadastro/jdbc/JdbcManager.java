package web.produto.cadastro.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class JdbcManager {

    private static Properties properties;

    static {
        properties = new Properties();

        try {
            InputStream inputStream = JdbcManager.class.getClassLoader().getResourceAsStream("sql/database.properties");
            properties.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private final JdbcProperties jdbcProperties;

    public JdbcManager() {
        final String host = getProperties().getProperty("host");
        final String porta = getProperties().getProperty("porta");
        final String banco = getProperties().getProperty("banco");
        final String parametros = getProperties().getProperty("parametros");
        final String usuario = getProperties().getProperty("usuario");
        final String senha = getProperties().getProperty("senha");
        final String driverClass = getProperties().getProperty("driverClass");

        this.jdbcProperties = new JdbcProperties(host, porta, banco, parametros, usuario, senha, driverClass);
    }

    public Connection iniciarConexao() {
        try {
            Class.forName(this.jdbcProperties.getDriver());

            return DriverManager.getConnection(this.jdbcProperties.getUrl(),
                    this.jdbcProperties.getUsuario(), this.jdbcProperties.getSenha());

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Connection iniciarConexaoPadrao() {
        try {
            Class.forName(this.jdbcProperties.getDriver());

            return DriverManager.getConnection(this.jdbcProperties.getDefaultUrl(),
                    this.jdbcProperties.getUsuario(), this.jdbcProperties.getSenha());

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void fecharConexao(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException ignored) {
            }
        }

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException ignored) {
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ignored) {
            }
        }
    }

    public void fecharConexao(Connection conn) {
        fecharConexao(null, null, conn);
    }

    public boolean testarConexao(Connection conn) {
        try {
            return conn != null && conn.isValid(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void executarScript(Connection conn, InputStream sqlScript) {
        Scanner scanner = new Scanner(sqlScript);
        scanner.useDelimiter("(;(\r)?\n)|(--\n)");

        try (Statement stmt = conn.createStatement()) {
            while (scanner.hasNext()) {
                String line = scanner.next();
                if (line.startsWith("/*!") && line.endsWith("*/")) {
                    int i = line.indexOf(' ');
                    line = line.substring(i + 1, line.length() - " */".length());
                }

                if (line.trim().length() > 0) {
                    stmt.execute(line);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public JdbcProperties getJdbcProperties() {
        return jdbcProperties;
    }

    public static Properties getProperties() {
        return JdbcManager.properties;
    }
}
