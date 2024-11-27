package entities;

public class Usuario {
    private Integer id;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String login;
    private String senha;
    private CargoFuncionario cargo;
//    
//    private UsuarioDAO userDAO;
    CargoFuncionarioDAO c = new CargoFuncionarioDAO();
    
    public Usuario(){        
    }
    

    public Usuario(String nome, String sobrenome, String telefone, String login, String senha, int id_cargo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.login = login;
        this.senha = senha;
        this.cargo = c.buscarCargoPorId(id_cargo);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getTelefone() {
        return telefone;
    }
    

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public CargoFuncionario getCargo() {
        return cargo;
    }

    public void setCargo(CargoFuncionario cargo) {
        this.cargo = cargo;
    }
      
    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Cargo: " + getCargo().getNome_cargo();
    }
    
    
    
    
}
