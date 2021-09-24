package br.com.letscode.java.arquivosAntonioScanner;

import java.math.BigDecimal;

public class ContaPJ {
    private int numero;
    private String titular;
    protected BigDecimal saldo;
    static int qtdcontas = 0;

    public ContaPJ(int numero, String titular, BigDecimal saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;

    }

    public void Conta (String Titular) {
    this.titular = Titular;
    qtdcontas++;
    this.numero = qtdcontas;
    this.saldo = BigDecimal.valueOf(0);

    }

    public void Depositar(double valor) {
        this.saldo = BigDecimal.valueOf(this.saldo.doubleValue() + valor);
    }

    public void Sacar(double sValor) {
        if (sValor <= this.saldo.doubleValue()) {
            sValor *= 1.005;
            this.saldo = BigDecimal.valueOf((this.saldo.doubleValue() - sValor));

        } else {
            System.out.println("--Saldo Insuficiente");
        }
    }

    public void  Transferir(double tValor) {
            if (tValor <= this.saldo.doubleValue()) {
                tValor *= 1.005;
                this.saldo = BigDecimal.valueOf((this.saldo.doubleValue() - tValor));

            } else {
                System.out.println("--Saldo Insuficiente");
            }

        }

    public void ConsultarSaldo() {
        System.out.println("Seu saldo: " + this.saldo);
    }



}




