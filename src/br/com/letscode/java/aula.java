package br.com.letscode.java;

import java.util.Scanner;

public class aula {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        limpar(scan);
        String s = scan.nextLine();
        System.out.println(num);
        System.out.println(s);
    }
    public static void limpar(Scanner scan){
        if(scan.hasNextLine()){
            scan.nextLine();
        }
    }
}
