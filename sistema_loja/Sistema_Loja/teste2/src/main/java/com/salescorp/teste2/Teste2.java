package com.salescorp.teste2;

import conexao.Conexao;
import conexao.ConexaoMysql;
import entities.produto.Categoria;
import entities.produto.CategoriaDAO;
import entities.produto.Produto;
import entities.produto.ProdutoDAO;
import entities.funcionario.Usuario;
import entities.funcionario.UsuarioDAO;
import entities.venda.ItemVenda;
import entities.venda.ItemVendaDAO;
import entities.venda.VendaDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.smartcardio.Card;
import view.produto.TelaProdutos;

/**
 *
 * @author wesle
 */
public class Teste2 {

    public static void main(String[] args) throws SQLException {
        Conexao conexao = new ConexaoMysql();
        
        UsuarioDAO userDAO = new UsuarioDAO();
        
        var userTeste = new Usuario("Exemplo", "Junior", "99889988", "exjunio", "1234", 2);
        
//        System.out.println(userTeste);
        var cargoDAO = new CategoriaDAO();
        
        ProdutoDAO produtos = new ProdutoDAO();
        
//        Produto p1 = produtos.buscarProdutoPorId(8);
//        Produto p2 = produtos.buscarProdutoPorId(3);
//        Produto p3 = produtos.buscarProdutoPorId(4);
//        
//        System.out.println(p2);
//        
//        ItemVenda item = new ItemVenda(produtos.buscarProdutoPorId(2), 2);
//        System.out.println("Exibindo item do carrinho: \n\n");
//        System.out.println(item);
        
        var itemDAO = new ItemVendaDAO();
//        System.out.println(itemDAO.criarItem(p1, 3,1));
//        System.out.println(itemDAO.criarItem(p2, 2,1));
//        System.out.println(itemDAO.criarItem(p3, 3,1));
        
        var vendaDAO = new VendaDAO();
        
        System.out.println(vendaDAO.buscarVendaPorId(1));
    }
}
