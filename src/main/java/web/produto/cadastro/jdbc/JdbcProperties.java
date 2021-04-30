package web.produto.cadastro.jdbc;

public class JdbcProperties {

    private String host;
    private String porta;
    private String banco;
    private String parametros;
    private String usuario;
    private String senha;
    private String driver;

    public JdbcProperties(String host, String porta, String banco, String parametros, String usuario,
                          String senha, String driver) {

        this.host = host;
        this.porta = porta;
        this.banco = banco;
        this.parametros = parametros;
        this.usuario = usuario;
        this.senha = senha;
        this.driver = driver;
    }

    public JdbcProperties() {
    }

    public String getDefaultUrl() {
        return this.host + ":" + this.porta + this.parametros;
    }

    public String getUrl() {
        return this.host + ":" + this.porta + "/" + this.banco + this.parametros;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPorta() {
        return porta;
    }

    public void setPorta(String porta) {
        this.porta = porta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getParametros() {
        return parametros;
    }

    public void setParametros(String parametros) {
        this.parametros = parametros;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
