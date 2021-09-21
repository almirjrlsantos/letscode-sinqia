//Reescreva a questão 8 da Lista 3 usando POO "Escreva um programa que lê nome, peso e altura de 5 pessoas,
// calcula o IMC de cada um e ao final informa se alguém está fora do peso ideal (o IMC ideal é entre 18,5 e 25)."

package br.com.letscode.java.ativ4;

import java.util.ArrayList;

public class MainExercicioOito {
    public static void main(String[] args) {
        final float IMC_IDEAL_MIN = 18.5f;
        final float IMC_IDEAL_MAX = 25f;
        ArrayList<Pessoa> pessoas = new ArrayList();

        pessoas.add(new Pessoa("Almir",80, 1.70 ));
        pessoas.add(new Pessoa("Meire",55.5, 1.56));
        pessoas.add(new Pessoa("Carol",55.3, 1.62));
        pessoas.add(new Pessoa("Rodrigo",95, 1.68));
        pessoas.add(new Pessoa("Fran",52, 1.50));

        for(int i=0; i< pessoas.size(); i++){
            Pessoa pessoa = pessoas.get(i);
            double imc = pessoa.calcularImc(pessoa.getPeso(), pessoa.getAltura());

            if(imc < IMC_IDEAL_MIN || imc > IMC_IDEAL_MAX){
                pessoa.setImcIdeal(false);
            } else {
                pessoa.setImcIdeal(true);
            }
        }
        for(Pessoa pessoa : pessoas){
            if(!pessoa.isImcIdeal()){
                System.out.println(pessoa.getNome() + " está fora do peso ideal.");
            }
        }
    }
}
