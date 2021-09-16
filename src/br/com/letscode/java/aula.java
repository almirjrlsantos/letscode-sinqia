package br.com.letscode.java;

import java.util.Scanner;

public class aula {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Numero: ");
        int num = scan.nextInt();
        limpar(scan);

        System.out.print("Texto: ");
        String s = scan.nextLine();

        System.out.println(num);
        System.out.println(s);
        scan.close();
    }
    public static void limpar(Scanner scan){
        if(scan.hasNextLine()){
            scan.nextLine();
        }
    }
}
