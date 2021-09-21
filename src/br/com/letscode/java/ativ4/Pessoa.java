//Crie uma classe para representar a estrutura de dados para uma Pessoa, contendo os
// atributos de nome, idade. Defina os métodos construtor padrão e completo, e os
// acessadores e modificadores para cada atributo. Também escreva o método "toString" para essa classe.

package br.com.letscode.java.ativ4;

public class Pessoa {
    private String nome;
    private int idade;
    private double peso;
    private double altura;
    private boolean imcIdeal;

    public Pessoa() {
    }
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    public Pessoa(String nome, double peso, double altura) {
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public boolean isImcIdeal() {
        return imcIdeal;
    }

    public void setImcIdeal(boolean imcIdeal) {
        this.imcIdeal = imcIdeal;
    }

    public double calcularImc(double peso, double altura){
        return peso/Math.pow(altura,2);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", peso=" + peso +
                ", altura=" + altura +
                ", imcIdeal=" + imcIdeal +
                '}';
    }
}
