package br.com.letscode.java.arquivosAntonioScanner;

import java.math.BigDecimal;
import java.util.Scanner;

public class Deposito {
    private int numero;
    private String titular;
    protected BigDecimal saldo = BigDecimal.valueOf(0);


    public void Depositar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor informe o valor que deseja depositar: ");
        double valor = sc.nextDouble();
        this.saldo = BigDecimal.valueOf(this.saldo.doubleValue() + valor);
        System.out.println("Seu saldo atual: " + this.saldo);
    }


        public static void main (String[] args){ // Apenas para testar
        Deposito a = new Deposito();
        a.Depositar();
    }
    }

