package br.com.letscode.java.io;

public class Pessoa {
    private String nome;
    private int idade;
    private Sexo sexo;

    public Pessoa(){}

    public Pessoa(String nome, int idade, Sexo sexo){
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getIdade(){
        return this.idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public Sexo getSexo(){
        return this.sexo;
    }

    public void setSexo(Sexo sexo){
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return nome +
                ", idade= " + idade +
                ", sexo= " + sexo;
    }
}
