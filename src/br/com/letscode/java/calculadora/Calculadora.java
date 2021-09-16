package br.com.letscode.java.calculadora;

public class Calculadora {
    public static void main(String[] args){
        int a = 10, b = 9;
        soma(a,b);
        subtracao(a,b);
        multi(a,b);
        divisao(a,b);
        desafio(a,b);

        boolean aPar = a%2==0;
        boolean bPar = b%2==0;
        System.out.println(aPar +" - " + bPar);
    }

    public static void soma(int a, int b){
        System.out.println("Soma a+b = "+ (a+b));
    }
    public static void subtracao(int a, int b){
        System.out.println("Subtração a-b = "+ (a-b));
    }
    public static void divisao(int a, int b){
        if (b>0){
            System.out.println("Divisão de a/b = "+ (double) a/b);
            return;
        }
        System.out.println("Divisor menor ou igual a zero");
    }
    public static void multi(int a, int b){
        System.out.println("multiplicação a*b = " + a*b);
    }

    public static void desafio(int a, int b){
        if (a%2==0 && b%2==0){
            if (a>b) {
                System.out.println("A é maior que B");
                return;
            }
            if (a<b) {
                System.out.println("B é maior que A");
                return;
            }
            System.out.println("A e B são iguais");
            return ;
        }
        System.out.println("Um dos termos é impar");
    }
}
