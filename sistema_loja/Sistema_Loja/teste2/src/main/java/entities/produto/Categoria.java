/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities.produto;

/**
 *
 * @author wesle
 */
public class Categoria {
    
    private static int geradorIdCategoria = 1;
    private int id;
    private String nome_categoria;

    public Categoria() {
    }
    
    public Categoria(String nome_categoria) {
        this.id = geradorIdCategoria++;
        this.nome_categoria = nome_categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_categoria() {
        return nome_categoria;
    }

    public void setNome_categoria(String nome_categoria) {
        this.nome_categoria = nome_categoria;
    }

    @Override
    public String toString() {
        return "Categoria{" + "id=" + id + ", nome_categoria=" + nome_categoria + '}';
    }
    
    
}
