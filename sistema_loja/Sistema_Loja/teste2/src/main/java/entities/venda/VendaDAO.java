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
        this.conexao=new ConexaoMysql();
    }
    
    private Venda getVenda(ResultSet resultado) throws SQLException {
        Venda venda =new Venda();
        
        venda.setId(resultado.getInt("id_venda"));
        LocalDate dataVenda = resultado.getObject("data_venda", LocalDate.class);
        venda.setData(dataVenda);
        venda.setValorVenda(resultado.getDouble("valor_total_venda"));       

        return venda;
    }

    public Venda buscarVendaPorId(int id) {
        String sql = "select * from vw_venda_data_total where id_venda = ?";
        try {
            
            PreparedStatement stmt = conexao.obterConexao().prepareStatement(sql);
            stmt.setInt(1,id);
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
}
