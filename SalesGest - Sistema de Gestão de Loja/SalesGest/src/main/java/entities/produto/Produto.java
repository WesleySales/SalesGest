package entities.produto;

public class Produto {

    private Integer id;
    private String nome;
    private double preco;
    private int estoque;
    private Categoria categoria;

    public Produto() {

    }

    CategoriaDAO catDAO = new CategoriaDAO();

    public Produto(String nome, double preco, int estoque, int id_categoria) {

        setNome(nome);
        setPreco(preco);
        setEstoque(estoque);
        this.categoria = catDAO.buscarCategoriaPorId(id_categoria);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() < 3) {
            throw new IllegalArgumentException("O nome deve ter pelo menos 3 letras.");                        
        }
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero.");
        }
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        if (estoque <= 0) {
            throw new IllegalArgumentException("O estoque deve ser maior que zero.");           
        }
        this.estoque = estoque;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return String.format("ID: %d - Categoria: %s - Produto: %s - Preço: %.2f - Estoque: %d ",
                getId(), getCategoria().getNome_categoria(), getNome(), getPreco(), getEstoque());

    }

//    @Override
//    public String toString() {
//        return "Produto{" + "id=" + id + ", nome=" + nome + ", preco=" + preco + ", estoque=" + estoque + ", categoria=" + categoria + '}';
//    }
}
