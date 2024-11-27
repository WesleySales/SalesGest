package entities.funcionario;

import conexao.Conexao;
import conexao.ConexaoMysql;
import entities.produto.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CargoFuncionarioDAO {

    private final Conexao conexao;

    public CargoFuncionarioDAO() {
        this.conexao = new ConexaoMysql();
    }

    public String cadastrarCargoFuncionario(CargoFuncionario cargo) {        
        String sql = "insert into cargo_funcionario (nome_cargo,remuneracao_base) values (?,?)";
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            preparedStatement.setString(1, cargo.getNome_cargo());
            preparedStatement.setDouble(2, cargo.getRemuneracao_base());
            preparedStatement.executeUpdate();
            return "Produto cadastrado com sucesso";
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
    }

    public String exibirListaDeCargos() {
        String sql = "select * from cargo_funcionario";
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            StringBuilder sb = new StringBuilder();
            while (result.next()) {
                sb.append(getCargo(result)).append("\n");
            }
            return sb.toString();
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        return "";
    }

    public CargoFuncionario getCargo(ResultSet resultado) throws SQLException {
        CargoFuncionario cargo = new CargoFuncionario();
        cargo.setId_cargo(resultado.getInt("id_cargo"));
        cargo.setNome_cargo(resultado.getString("nome_cargo"));
        cargo.setRemuneracao_base(resultado.getDouble("remuneracao_base"));
        return cargo;
    }

    public CargoFuncionario buscarCargoPorId(int id) {
        String sql = "select * from cargo_funcionario where id_cargo = ?";
        try {
            
            PreparedStatement stmt = conexao.obterConexao().prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                return getCargo(result);
            }
        } catch (SQLException e) {
            System.out.format("Error: %s", e.getMessage());
        }
        return null;
    }

    private void preencherValores(PreparedStatement preparedStatement, Produto produto) throws SQLException {
        preparedStatement.setString(1, produto.getNome());
        preparedStatement.setDouble(2, produto.getPreco());
        preparedStatement.setInt(3, produto.getEstoque());
        preparedStatement.setInt(4, produto.getCategoria().getId());
    }
    
    public void deletarCargo(int id) {
        String sql = String.format("delete from cargo_funcionario where id_cargo = %d", id);
        var cargo = buscarCargoPorId(id);
        if (cargo == null) {
            System.out.println("Cargo não encontrado");
            return;
        }
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            preparedStatement.executeUpdate(sql);
            System.out.println("Produto deletado com sucesso");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
