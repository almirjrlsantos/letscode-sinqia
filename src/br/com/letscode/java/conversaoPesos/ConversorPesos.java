package br.com.letscode.java.conversaoPesos;

import java.util.Scanner;

public class ConversorPesos {
    public static void main(String[] args){
        final float FATOR_CONVERSAO_KG_LB = 2.20462f;

        Scanner scan = new Scanner(System.in);
        System.out.printf("Digite o peso: ");
        float pesoKg = scan.nextFloat();
        float pesoLibra = pesoKg * FATOR_CONVERSAO_KG_LB;

        System.out.printf("O peso em libra é %.3flb", pesoLibra);


    }
}
