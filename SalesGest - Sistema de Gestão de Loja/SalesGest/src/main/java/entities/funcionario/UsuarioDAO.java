package entities.funcionario;

import conexao.Conexao;
import conexao.ConexaoMysql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private final Conexao conexao;

    public UsuarioDAO() {
        this.conexao = new ConexaoMysql();
    }

    public String salvarUsuario(Usuario usuario) {
        return usuario.getId() == null ? cadastrarUsuario(usuario) : editarUsuario(usuario);
    }

    public String cadastrarUsuario(Usuario usuario) {
        String sql = "insert into funcionario (nome_funcionario, sobrenome_funcionario,"
                + " telefone_funcionario,login_funcionario, senha_funcionario,id_cargo) values(?,?,?,?,?,?)";
        try {
            if (buscarUsuarioPeloLogin(usuario.getLogin()) != null) {
                return "Erro: Já existe um usuário com este login.";
            } else {
                PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);

                preparedStatement.setString(1, usuario.getNome());
                preparedStatement.setString(2, usuario.getSobrenome());
                preparedStatement.setString(3, usuario.getTelefone());
                preparedStatement.setString(4, usuario.getLogin());
                preparedStatement.setString(5, usuario.getSenha());
                preparedStatement.setInt(6, usuario.getCargo().getId_cargo());
                
                int resultado = preparedStatement.executeUpdate();
                return resultado == 1 ? "Usuário cadastrado com sucesso" : "Ocorreu um erro ao cadastrar o usuário.";

            }
        } catch (SQLException e) {
            return String.format("Erro: %s", e.getMessage());
        }

    }

    private String editarUsuario(Usuario usuario) {
        String sql = "update funcionario nome_funcionario = ?, senha_funcionario =? where id_funcionario=? ";
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);

            preencherValores(preparedStatement, usuario);
            int resultado = preparedStatement.executeUpdate();
            return resultado == 1 ? "Usuario editado com sucesso" : "Ocorreu um erro";

        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }

    }

    private void preencherValores(PreparedStatement preparedStatement, Usuario usuario) throws SQLException {
        preparedStatement.setString(1, usuario.getNome());
        preparedStatement.setString(2, usuario.getSobrenome());
        preparedStatement.setString(3, usuario.getTelefone());
        preparedStatement.setString(4, usuario.getLogin());
        preparedStatement.setString(5, usuario.getSenha());
        preparedStatement.setInt(6, usuario.getCargo().getId_cargo());
    }

    public List<Usuario> listarTodosUsuarios() {
        String sql = "select * from vw_funcionario_geral";
        List<Usuario> listaDeUsuarios = new ArrayList<>();
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            while (result.next()) {
                listaDeUsuarios.add(getUsuario(result));
            }
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        return listaDeUsuarios;
    }

    public double getFolhaSalarial(List<Usuario> funcionarios){
        double folhaSalarial = 0;
        if(!listarTodosUsuarios().isEmpty()){
            for(Usuario f : listarTodosUsuarios()){
                folhaSalarial+= f.getCargo().getRemuneracao_base();
            }
        }
        return folhaSalarial;
    }
    
    private Usuario getUsuario(ResultSet resultado) throws SQLException {
        Usuario usuario = new Usuario();

        usuario.setId(resultado.getInt("id_funcionario"));
        usuario.setNome(resultado.getString("nome_funcionario"));
        usuario.setSobrenome(resultado.getString("sobrenome_funcionario"));
        usuario.setLogin(resultado.getString("login_funcionario"));
        usuario.setSenha(resultado.getString("senha_funcionario"));

        var cargo = new CargoFuncionario();
        cargo.setNome_cargo(resultado.getString("cargo"));
        cargo.setRemuneracao_base(resultado.getDouble("salario"));
        usuario.setCargo(cargo);

        return usuario;
    }

    public Usuario buscarUsuarioPorId(int id) {
        String sql = "select * from vw_funcionario_geral where id_funcionario=?";

        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                return getUsuario(result);
            }
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        return null;
    }

    public Usuario buscarUsuarioPeloNome(String nome) {
        String sql = String.format("Select * from funcionario where nome_funcionario = '%s'", nome);
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            while (result.next()) {
                return getUsuario(result);
            }
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        return null;
    }

    public Usuario buscarUsuarioPeloLogin(String login) {
        String sql = "select * from vw_funcionario_geral where login_funcionario=?";
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            preparedStatement.setString(1, login);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                return getUsuario(result);
            }
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        return null;
    }

    public void deletarUsuario(int id) {
        String sql = String.format("delete from funcionario where id_funcionario = %d", id);
        Usuario u = buscarUsuarioPorId(id);
        if (u == null) {
            return;
        }
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
//            System.out.println("Error"+e.getMessage());
        }

    }

}
