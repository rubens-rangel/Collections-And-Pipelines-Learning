package Entities;

public class Func {
    private String nome;
    private String email;
    private Double Salario;

    public Func(String nome, String email, Double salario) {
        this.nome = nome;
        this.email = email;
        Salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalario() {
        return Salario;
    }

    public void setSalario(Double salario) {
        Salario = salario;
    }
}
