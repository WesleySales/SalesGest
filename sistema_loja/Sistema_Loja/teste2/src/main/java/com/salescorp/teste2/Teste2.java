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
        
        Usuario novoUsuario = new Usuario("Novo", "Teste","WesleySales12", "4444");
//        
        CategoriaDAO cat = new CategoriaDAO();
        
//        Categoria novaCat = new Categoria("TESTANDO");
//        cat.cadastrarCategoria(novaCat);
        
//        System.out.println(cat.buscarCategoriaPorId(1));
//        System.out.println(cat.buscarCategoriaPorId(2));
//        System.out.println(cat.buscarCategoriaPorId(5));
        
        ProdutoDAO pDAO = new ProdutoDAO();
//        Produto produto = new Produto("Novo Exemplo", 100, 50, 4);
        
//        pDAO.cadastrarProduto(produto);
        System.out.println(pDAO.exibirListaDeProdutos());
               
//        System.out.println(produto);
    }
}
