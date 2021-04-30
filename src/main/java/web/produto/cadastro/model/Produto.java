package web.produto.cadastro.model;

public class Produto {

    private Long codigo;
    private String descricao;
    private String marca;
    private Double preco;

    public Produto(Long codigo, String descricao, String marca, Double preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.marca = marca;
        this.preco = preco;
    }

    public Produto() {

    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
