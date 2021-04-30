package web.produto.cadastro.jdbc.dao;

import web.produto.cadastro.jdbc.JdbcManager;
import web.produto.cadastro.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao extends JdbcManager {

    public List<Produto> buscarTodos() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            conn = iniciarConexao();

            stmt = conn.prepareStatement("SELECT * FROM `produto`;");
            rs = stmt.executeQuery();

            if (rs != null) {
                while(rs.next()) {
                    Produto produto = new Produto();

                    produto.setCodigo(rs.getLong(1));
                    produto.setDescricao(rs.getString(2));
                    produto.setMarca(rs.getString(3));
                    produto.setPreco(rs.getDouble(4));

                    produtos.add(produto);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(rs, stmt, conn);
        }

        return produtos;
    }

    public Produto buscarPorCodigo(Long codigo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Produto produto = new Produto();

        try {
            conn = iniciarConexao();

            stmt = conn.prepareStatement("SELECT * FROM `produto` WHERE `codigo` = ?;");
            stmt.setLong(1, codigo);

            rs = stmt.executeQuery();

            if (rs != null && rs.next()) {
                produto.setCodigo(rs.getLong(1));
                produto.setDescricao(rs.getString(2));
                produto.setMarca(rs.getString(3));
                produto.setPreco(rs.getDouble(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(rs, stmt, conn);
        }

        return produto;
    }

    public void salvar(Produto produto) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = iniciarConexao();
            stmt = conn.prepareStatement("INSERT INTO `produto` (`descricao`, `marca`, `preco`) VALUES (?, ?, ?);");

            stmt.setString(1, produto.getDescricao());
            stmt.setString(2, produto.getMarca());
            stmt.setDouble(3, produto.getPreco());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(null, stmt, conn);
        }
    }

    public void atualizar(Produto produto) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = iniciarConexao();
            stmt = conn.prepareStatement("UPDATE `produto` SET `descricao`= ?, `marca`= ?, `preco`= ? WHERE `codigo`= ?;");

            stmt.setString(1, produto.getDescricao());
            stmt.setString(2, produto.getMarca());
            stmt.setDouble(3, produto.getPreco());
            stmt.setLong(4, produto.getCodigo());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(null, stmt, conn);
        }
    }

    public void remover(Long codigo) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = iniciarConexao();
            stmt = conn.prepareStatement("DELETE FROM `produto` WHERE `codigo` = ?;");

            stmt.setLong(1, codigo);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(null, stmt, conn);
        }
    }
}
