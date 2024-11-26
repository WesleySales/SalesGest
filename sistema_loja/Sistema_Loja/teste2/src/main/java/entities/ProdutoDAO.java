package entities;

import conexao.Conexao;
import conexao.ConexaoMysql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private final Conexao conexao;

    public ProdutoDAO() {
        this.conexao = new ConexaoMysql();
    }

//    public String salvarProduto(Produto produto) {
//        return produto.getId() == null ? cadastrarProduto(produto) : editarProduto(String novoNome, double novoPreco, int novaQtd, int id);
//    }

    public String cadastrarProduto(Produto produto) {
        
        String sql = "insert into produto (nome_produto,preco_produto,estoque,id_categoria) values (?,?,?,?)";
        try {
            
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            preencherValores(preparedStatement, produto);
            preparedStatement.executeUpdate();
            return "Produto cadastrado com sucesso";
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
    }

    public List<Produto> listaDeProdutosCadastrados() {
        String sql = """
                     select p.id_produto, c.nome_categoria as categoria,p.nome_produto,
                     p.preco_produto, p.estoque
                     from produto p 
                     join categoria c on p.id_categoria = c.id_categoria""";
        List<Produto> listaDeProdutos = new ArrayList<>();
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            while (result.next()) {
                listaDeProdutos.add(getProduto(result));
            }
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        return listaDeProdutos;
    }

    public String exibirListaDeProdutos() {
        String sql = "select * from vw_produtos_visao_geral where id_produto = ?";
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            StringBuilder sb = new StringBuilder();
            while (result.next()) {
                sb.append(getProduto(result)).append("\n");
            }
            return sb.toString();
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        return "";
    }

    private Produto getProduto(ResultSet resultado) throws SQLException {
        Produto produto = new Produto();

        produto.setId(resultado.getInt("id_produto"));
        produto.setNome(resultado.getString("nome_produto"));
        produto.setPreco(resultado.getDouble("preco_produto"));
        produto.setEstoque(resultado.getInt("estoque"));
        
        Categoria categoria = new Categoria();
        categoria.setNome_categoria(resultado.getString("categoria"));
        produto.setCategoria(categoria);

        return produto;
    }

    public Produto buscarProdutoPorId(int id) {
        String sql = "select * from vw_produtos_visao_geral where id_produto = ?";
        try {
            
            PreparedStatement stmt = conexao.obterConexao().prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                return getProduto(result);
            }
        } catch (SQLException e) {
            System.out.format("Error: %s", e.getMessage());
        }
        return null;
    }

    public Produto buscarProdutoPorNome(String nome) {
        String sql = "select * from vw_produtos_visao_geral where nome_produto = ?";
        try {
            PreparedStatement stmt = conexao.obterConexao().prepareStatement(sql);
            stmt.setString(1,nome);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                return getProduto(result);
            }
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        return null;
    }

    public String editarProduto(String novoNome, double novoPreco, int novaQtd, int id) {
        String sql = "update produto set nome_produto = ?, preco_produto =?, estoque=? where id_produto=? ";
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);

            preparedStatement.setString(1, novoNome);
            preparedStatement.setDouble(2, novoPreco);
            preparedStatement.setInt(3, novaQtd);
            preparedStatement.setInt(4, id);
            
            int resultado = preparedStatement.executeUpdate();
            
            return resultado == 1 ? "Produto editado com sucesso" : "Ocorreu um erro";

        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
    }

    private void preencherValores(PreparedStatement preparedStatement, Produto produto) throws SQLException {
        preparedStatement.setString(1, produto.getNome());
        preparedStatement.setDouble(2, produto.getPreco());
        preparedStatement.setInt(3, produto.getEstoque());
        preparedStatement.setInt(4, produto.getCategoria().getId());
    }
    
    public void deletarProduto(int id) {
        String sql = String.format("delete from produto where id_produto = %d", id);
        Produto p = buscarProdutoPorId(id);
        if (p == null) {
            System.out.println("Produto não encontrado");
            return;
        }
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            preparedStatement.executeUpdate(sql);
            System.out.println("Produto deletado com sucesso");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
