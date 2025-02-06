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
        
        
        //teste de itemVenda
        var itemDAO = new ItemVendaDAO();
        var produtosDAO = new ProdutoDAO();
        
        System.out.println(produtosDAO.exibirProdutosPorCategoria("Roupas"));

        
    }
}
