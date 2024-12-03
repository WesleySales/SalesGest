package entities.venda;

import entities.funcionario.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venda {
    private static int geradorIdVenda = 100;
    private int id;
    private Usuario usuario; // funcionario que realizou a venda
    private LocalDate data;
    private List<ItemVenda> listaDeItens = new ArrayList<>();
    private double valorVenda;

    public Venda() {
        this.id = geradorIdVenda++;
        this.data = LocalDate.now();
        this.valorVenda=0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", data=" + data + ", valorVenda=" + valorVenda + '}';
    }
}
