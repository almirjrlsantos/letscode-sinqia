package br.com.letscode.java.atividadeGrupo;

import java.math.BigDecimal;

public class Conta {
    final private double PF_JUROS_INVESTIMENTO = 3;
    final private double PF_TAXA_SAQUE_TRANSFER = 0.5;
    final private double PJ_JUROS_INVESTIMENTO = PF_JUROS_INVESTIMENTO * 2;

    private int numConta;
    private BigDecimal contaCorrente = new BigDecimal(0);
    private BigDecimal contaPoupanca = new BigDecimal(0);
    private BigDecimal contaInvestimento = new BigDecimal(0);

    private Conta(){}

    public Conta(int numConta) {
        this.numConta = numConta;
    }

    public Conta(int numConta, BigDecimal contaCorrente) {
        this.numConta = numConta;
        this.contaCorrente = contaCorrente;
    }

    public Conta(int numConta, BigDecimal contaCorrente, BigDecimal contaPoupanca, BigDecimal contaInvestimento) {
        this.numConta = numConta;
        this.contaCorrente = contaCorrente;
        this.contaPoupanca = contaPoupanca;
        this.contaInvestimento = contaInvestimento;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numConta=" + numConta +
                ", contaCorrente=" + contaCorrente +
                ", contaPoupanca=" + contaPoupanca +
                ", contaInvestimento=" + contaInvestimento +
                '}';
    }
}
