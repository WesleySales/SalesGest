package com.salescorp.teste2;

import conexao.Conexao;
import conexao.ConexaoMysql;
import entities.Categoria;
import entities.CategoriaDAO;
import entities.Produto;
import entities.ProdutoDAO;
import entities.Usuario;
import entities.UsuarioDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import view.TelaProdutos;

/**
 *
 * @author wesle
 */
public class Teste2 {

    public static void main(String[] args) throws SQLException {
        Conexao conexao = new ConexaoMysql();
        
        UsuarioDAO userDAO = new UsuarioDAO();
        
        var userTeste = new Usuario("Exemplo", "Junior", "99889988", "exjunio", "1234", 2);
        
        System.out.println(userTeste);
        
        userDAO.cadastrarUsuario(userTeste);
        System.out.println(userDAO.buscarUsuarioPorId(1));
        System.out.println(userDAO.buscarUsuarioPorId(6));
        
    }
}
