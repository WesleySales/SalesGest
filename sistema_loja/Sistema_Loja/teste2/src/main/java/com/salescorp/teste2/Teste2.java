package com.salescorp.teste2;

import conexao.Conexao;
import conexao.ConexaoMysql;
import entities.produto.Categoria;
import entities.produto.CategoriaDAO;
import entities.produto.Produto;
import entities.produto.ProdutoDAO;
import entities.funcionario.Usuario;
import entities.funcionario.UsuarioDAO;
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
        
//        produtos.listaDeProdutosCadastrados();
//        System.out.println(cargoDAO.buscarCategoriaPorId(1));
        
        System.out.println(userDAO.listarTodosUsuarios());
//        System.out.println(userDAO.buscarUsuarioPorId(1));
//        System.out.println(userDAO.buscarUsuarioPorId(6));
        
    }
}
