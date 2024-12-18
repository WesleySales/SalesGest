package entities.venda;

import conexao.Conexao;
import conexao.ConexaoMysql;
import entities.produto.Produto;
import entities.produto.ProdutoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemVendaDAO {
    private Conexao conexao;

    public ItemVendaDAO() {
        this.conexao = new ConexaoMysql();
    }
    
    public String salvarItemNoCarrinho(ItemVenda item, int quantidade){
        return item==null? criarItem(item):editarItem(item, quantidade);
    }
    
    private String criarItem(ItemVenda item){

        String sql = "insert into Item_Venda (id_produto, quantidade_produto,valor_item, id_venda) values (?,?,?,?)";
        double valorItem = calcularValorItem(item.getProduto(), item.getQuantidade()); //retorna o valor do item e atribui a minha variavel        
        
        try {
            
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            preparedStatement.setInt(1, item.getProduto().getId());
            preparedStatement.setInt(2, item.getQuantidade());
            preparedStatement.setDouble(3, valorItem);
            preparedStatement.setInt(4, item.getVenda().getId());
            
            preparedStatement.executeUpdate();
            return "Item cadastrado com sucesso";
            
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
    }
    
    private String editarItem(ItemVenda item, int quantidade){
        String sql = "update item_venda set quantidade_produto = ? where id_produto=?";
        
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            preparedStatement.setInt(1, (item.getQuantidade()+quantidade));
            preparedStatement.setInt(2, item.getId());
            
            preparedStatement.executeUpdate();
            return "Item editado com sucesso";
            
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
    }
    
    private double calcularValorItem(Produto produto, int quantidade){
       return produto.getPreco()*quantidade;
    }
    
    public List<ItemVenda> listaDeItens() {
        String sql = "select * from vw_item_venda";
        List<ItemVenda> listaDeItens = new ArrayList<>();
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            while (result.next()) {
                listaDeItens.add(getItem(result));
            }
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        return listaDeItens;
    }
    
    public ItemVenda buscarItem(int id_produto, int id_venda){
        String sql = "select * from vw_item_venda where codigo=?";
        
        try{
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            preparedStatement.setInt(1, id_produto);
//            preparedStatement.setInt(2, id_venda);
            
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
        
        item.setId(resultado.getInt("Codigo"));
        item.setProduto(pDAO.buscarProdutoPorNome(resultado.getString("produto")));
        item.setQuantidade(resultado.getInt("quantidade"));
        item.setValorItem(resultado.getDouble("valor"));           
        
        return item;
    }
    
    
}
