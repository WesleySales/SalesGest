/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities.venda;

import entities.produto.Produto;

public class ItemVenda {   
    private static int geradorID=1;
    private int id;
    private Produto produto;
    private int quantidade;
    private double valorItem;
    private Venda venda;

    public ItemVenda(Produto produto, int quantidade, Venda venda) {
        this.id = geradorID++;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorItem = calcularValorItem(produto, quantidade);
        this.venda= venda;
    }

    ItemVenda() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorItem() {
        return valorItem;
    }

    public void setValorItem(double valorItem) {
        this.valorItem = valorItem;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public String toString() {
        return "ItemVenda{" + "produto=" + produto.getNome() + ", quantidade=" + quantidade + ", valorItem= R$ " + valorItem + '}';
    }
    
    public double calcularValorItem(Produto produto, int quantidade){
       return produto.getPreco()*quantidade;
    }
    
}
