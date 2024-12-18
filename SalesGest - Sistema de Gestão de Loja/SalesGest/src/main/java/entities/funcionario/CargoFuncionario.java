
package entities.funcionario;

public class CargoFuncionario {
    private int id_cargo;
    private String nome_cargo;
    private double remuneracao_base;

    public CargoFuncionario(){        
    }
    
    public CargoFuncionario(int id_cargo, String nome_cargo, double remuneracao_base) {
        this.id_cargo = id_cargo;
        this.nome_cargo = nome_cargo;
        this.remuneracao_base = remuneracao_base;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getNome_cargo() {
        return nome_cargo;
    }

    public void setNome_cargo(String nome_cargo) {
        this.nome_cargo = nome_cargo;
    }

    public double getRemuneracao_base() {
        return remuneracao_base;
    }

    public void setRemuneracao_base(double remuneracao_base) {
        this.remuneracao_base = remuneracao_base;
    }
    
    
}
