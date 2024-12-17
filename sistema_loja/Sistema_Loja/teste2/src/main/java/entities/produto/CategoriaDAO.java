package entities.produto;

import conexao.Conexao;
import conexao.ConexaoMysql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    private final Conexao conexao;

    public CategoriaDAO() {
        this.conexao = new ConexaoMysql();
    }

    public String cadastrarCategoria(Categoria categoria) {
        String sql = "insert into categoria (nome_categoria) values (?)";
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            preparedStatement.setString(1, categoria.getNome_categoria());
            
            preparedStatement.executeUpdate();
            
            return "Categoria cadastrado com sucesso";
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
    }



//    public List<Produto> listaDeProdutosCadastrados() {
//        String sql = "select * from produto";
//        List<Produto> listaDeProdutos = new ArrayList<>();
//        try {
//            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
//            while (result.next()) {
//                listaDeProdutos.add(getProduto(result));
//            }
//        } catch (SQLException e) {
//            System.out.println(String.format("Error: %s", e.getMessage()));
//        }
//        return listaDeProdutos;
//    }

    public List<String> exibirListaDeCategorias() {
        List<String> categorias = new ArrayList<>();
        String sql = "select * from categoria";
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            while (result.next()) {
                categorias.add(getCategoria(result).getNome_categoria());
            }
            return categorias;
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        return categorias;
    }

    private Categoria getCategoria(ResultSet resultado) throws SQLException {
        Categoria categoria = new Categoria();

        categoria.setId(resultado.getInt("id_categoria"));
        categoria.setNome_categoria(resultado.getString("nome_categoria"));

        return categoria;
    }

    public Categoria buscarCategoriaPorId(int id) {
        String sql = String.format("select * from categoria where id_categoria = %d", id);
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            while (result.next()) {
                return getCategoria(result);
            }
        } catch (SQLException e) {
            System.out.format("Error: %s", e.getMessage());
        }
        return null;
    }

//    public Produto buscarProdutoPorNome(String nome) {
//        String sql = String.format("select * from produto where nome_produto = %s", nome);
//        try {
//            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
//            while (result.next()) {
//                return getProduto(result);
//            }
//        } catch (SQLException e) {
//            System.out.println(String.format("Error: %s", e.getMessage()));
//        }
//        return null;
//    }

//    public String editarProduto(String novoNome, double novoPreco, int novaQtd, int id) {
//        String sql = "update produto set nome_produto = ?, preco_produto =?, estoque=? where id_produto=? ";
//        try {
//            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
//
//            preparedStatement.setString(1, novoNome);
//            preparedStatement.setDouble(2, novoPreco);
//            preparedStatement.setInt(3, novaQtd);
//            preparedStatement.setInt(4, id);
//            
//            int resultado = preparedStatement.executeUpdate();
//            
//            return resultado == 1 ? "Produto editado com sucesso" : "Ocorreu um erro";
//
//        } catch (SQLException e) {
//            return String.format("Error: %s", e.getMessage());
//        }
//    }
    
    public void deletarCategoria(int id) {
        String sql = String.format("delete from categoria where id_categoria = %d", id);
        Categoria c = buscarCategoriaPorId(id);
        if (c == null) {
            System.out.println("Categoria não encontrada");
            return;
        }
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            preparedStatement.executeUpdate(sql);
            System.out.println("Categoria deletada com sucesso");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
