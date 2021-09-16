package br.com.letscode.java.ativ2;

import java.util.Scanner;

public class Exerc2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Informe um valor de 1 a 10 para ver sua respectiva tabuada.");
        int valor = scan.nextInt();

        System.out.println("Tabuada do " + valor);
        System.out.println(valor + " x 1 = " + valor);
        System.out.println(valor + " x 2 = " + (valor * 2));
        System.out.println(valor + " x 3 = " + (valor * 3));
        System.out.println(valor + " x 4 = " + (valor * 4));
        System.out.println(valor + " x 5 = " + (valor * 5));
        System.out.println(valor + " x 6 = " + (valor * 6));
        System.out.println(valor + " x 7 = " + (valor * 7));
        System.out.println(valor + " x 8 = " + (valor * 8));
        System.out.println(valor + " x 9 = " + (valor * 9));
        System.out.println(valor + " x 10 = " + (valor * 10));
    }
}
