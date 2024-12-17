/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities.venda;

import conexao.Conexao;
import conexao.ConexaoMysql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class VendaDAO {

    private Conexao conexao;

    public VendaDAO() {
        this.conexao = new ConexaoMysql();
    }

    public void criarVenda(Venda venda) {
        String sql = "insert into venda (id_venda,id_funcionario, data_venda) values (?,?,?)";

        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            preparedStatement.setInt(1, venda.getId());
            preparedStatement.setInt(2, venda.getUsuario().getId());

            LocalDate localDate = venda.getData();  // Supondo que venda.getData() retorne um LocalDate
            java.sql.Date sqlDate = java.sql.Date.valueOf(localDate); // Converte LocalDate para java.sql.Date
            preparedStatement.setDate(3, sqlDate); // Passa a data convertida para o PreparedStatement

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.format("Error: %s", e.getMessage());
        }
    }

    private Venda getVenda(ResultSet resultado) throws SQLException {
        Venda venda = new Venda();

        venda.setId(resultado.getInt("id_venda"));
        LocalDate dataVenda = resultado.getObject("data_venda", LocalDate.class);
        venda.setData(dataVenda);
        venda.setValorVenda(resultado.getDouble("valor_total_venda"));
        String statusVendaString = resultado.getString("status_venda");
        venda.setStatusVenda(StatusVenda.valueOf(statusVendaString));  // Agora passando o valor correto

        return venda;
    }

    public Venda buscarVendaPorId(int id) {
        String sql = "select * from vw_venda_data_total where id_venda = ?";
        try {

            PreparedStatement stmt = conexao.obterConexao().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                return getVenda(result);
            }
        } catch (SQLException e) {
            System.out.format("Error: %s", e.getMessage());
        }
        System.out.println("Venda nao encontrada");
        return null;
    }

    public Venda exibirVendaPorId(int id) {
        String sql = "select * from venda where id_venda=?";

        try {
            PreparedStatement stmt = conexao.obterConexao().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                return getVenda(result);
            }
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        return null;

    }

    public void atualizarStatusVenda(int id, StatusVenda status) {
        String sql = "update venda set status_venda = ? where id_venda=?";

        try {
            PreparedStatement stmt = conexao.obterConexao().prepareStatement(sql);
            stmt.setString(1, status.name());
            stmt.setInt(2, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
    }
}
