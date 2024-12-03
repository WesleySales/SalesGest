package entities.venda;

import conexao.Conexao;
import conexao.ConexaoMysql;
import entities.produto.Produto;
import entities.produto.ProdutoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemVendaDAO {
    private Conexao conexao;

    public ItemVendaDAO() {
        this.conexao = new ConexaoMysql();
    }

    
    
    
    public String criarItem(Produto produto, int quantidade, int id_venda){

        String sql = "insert into Item_Venda (id_produto, quantidade_produto,valor_item,id_venda) values (?,?,?,?)";
        double valorItem = calcularValorItem(produto, quantidade); //retorna o valor do item e atribui a minha variavel        
        
        try {
            
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            preparedStatement.setInt(1, produto.getId());
            preparedStatement.setInt(2, quantidade);
            preparedStatement.setDouble(3, valorItem);
            preparedStatement.setInt(4, id_venda);
            
            preparedStatement.executeUpdate();
            return "Item cadastrado com sucesso";
            
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
    }
    
    private double calcularValorItem(Produto produto, int quantidade){
       return produto.getPreco()*quantidade;
    }
    
    public ItemVenda buscarItem(Produto p, int id_venda){
        String sql = "select p.id_produto, p.nome_produto, iv.id_venda \n" +
        "from produto p, item_venda iv\n" +
        "where p.id_produto =? = iv.id_produto=?";
        
        try{
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            preparedStatement.setInt(1, p.getId());
            preparedStatement.setInt(2, id_venda);
            
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                return getItem(result);
            }
        } catch (SQLException e){
            System.out.println("Error: "+ e.getMessage());
        }
        return null;
    }
    
    private ItemVenda getItem(ResultSet resultado) throws SQLException {
        ItemVenda item = new ItemVenda();
        var pDAO = new ProdutoDAO();
        var vendaDAO = new VendaDAO();
        
        item.setProduto(pDAO.buscarProdutoPorId(resultado.getInt("nome_produto")));
        item.setQuantidade(resultado.getInt("quantidade_produto"));
        item.setVenda(vendaDAO.buscarVendaPorId(resultado.getInt("id_venda")));            
        
        return item;
    }
}
