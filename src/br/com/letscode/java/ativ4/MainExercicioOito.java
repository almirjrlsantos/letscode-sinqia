//Reescreva a questão 8 da Lista 3 usando POO "Escreva um programa que lê nome, peso e altura de 5 pessoas,
// calcula o IMC de cada um e ao final informa se alguém está fora do peso ideal (o IMC ideal é entre 18,5 e 25)."

package br.com.letscode.java.ativ4;

public class MainExercicioOito {
    public static void main(String[] args) {
        final float IMC_IDEAL_MIN = 18.5f;
        final float IMC_IDEAL_MAX = 25f;

        Pessoa[] pessoas = new Pessoa[5];
        pessoas[0] = new Pessoa("Almir",80, 1.70 );
        pessoas[1] = new Pessoa("Meire",55.5, 1.56);
        pessoas[2] = new Pessoa("Carol",55.3, 1.62);
        pessoas[3] = new Pessoa("Rodrigo",95, 1.68);
        pessoas[4] = new Pessoa("Fran",52, 1.50);

        for(int i=0; i< pessoas.length; i++){
            double imc = pessoas[i].calcularImc(pessoas[i].getPeso(), pessoas[i].getAltura());

            if(imc < IMC_IDEAL_MIN || imc > IMC_IDEAL_MAX){
                pessoas[i].setImcIdeal(false);
            } else {
                pessoas[i].setImcIdeal(true);
            }
        }
        for(Pessoa pessoa : pessoas){
            if(!pessoa.isImcIdeal()){
                System.out.println(pessoa.getNome() + " está fora do peso ideal.");
            }
        }
    }
}
