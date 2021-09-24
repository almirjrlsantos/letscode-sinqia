package br.com.letscode.java.atividadeGrupo;

import java.math.BigDecimal;

public class Conta {
    final private double PF_JUROS_INVESTIMENTO = 3;
    final private double PF_TAXA_SAQUE_TRANSFER = 0.5;
    final private double PJ_JUROS_INVESTIMENTO = PF_JUROS_INVESTIMENTO + 2; // CORRIGIR A OPERAÇÃO

    private int numConta;
    private BigDecimal contaCorrente = new BigDecimal(0); // 1
    private BigDecimal contaPoupanca = new BigDecimal(0); // 2
    private BigDecimal contaInvestimento = new BigDecimal(0); //3
    private boolean aberturaPoupanca = false;
    private boolean aberturaInvestimento = false;

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

    public int getNumConta() {
        return numConta;
    }

    private void setNumConta(int numConta) { // METODO NÃO PODE SER ACESSIVEL
        this.numConta = numConta;
    }

    public BigDecimal getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(BigDecimal contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public BigDecimal getContaPoupanca() {
        return contaPoupanca;
    }

    public void setContaPoupanca(BigDecimal contaPoupanca) {
        this.contaPoupanca = contaPoupanca;
    }

    public BigDecimal getContaInvestimento() {
        return contaInvestimento;
    }

    public void setContaInvestimento(BigDecimal contaInvestimento) {
        this.contaInvestimento = contaInvestimento;
    }

    public static boolean temSaldo(Conta conta, int tipo, BigDecimal valor){
        if(tipo == 1){
            if (conta.getContaCorrente().doubleValue()  >= valor.doubleValue()){
                return true;
            }
        } else if (tipo == 2){
            if (conta.getContaPoupanca().doubleValue()  >= valor.doubleValue()){
                return true;
            }
        } else if (tipo == 3){
            if (conta.getContaInvestimento().doubleValue()  >= valor.doubleValue()){
                return true;
            }
        }
        return false;
    }

    public static boolean transferir(Conta[] contas, int contaRemetente, int contaDestinataria, int tipoRemetente, int tipoDestinatario, BigDecimal valor){
        if(tipoDestinatario == 0) {
            if (Conta.temSaldo(contas[contaRemetente], tipoRemetente, valor)) {
                if (tipoRemetente == 1) {
                    contas[contaRemetente].setContaCorrente(contas[contaRemetente].getContaCorrente().subtract(valor));
                    contas[contaDestinataria].setContaCorrente(contas[contaDestinataria].getContaCorrente().add(valor));
                } else if (tipoRemetente == 2) {
                    contas[contaRemetente].setContaPoupanca(contas[contaRemetente].getContaPoupanca().subtract(valor));
                    contas[contaDestinataria].setContaCorrente(contas[contaDestinataria].getContaCorrente().add(valor));
                } else if (tipoRemetente == 3) {
                    contas[contaRemetente].setContaInvestimento(contas[contaRemetente].getContaInvestimento().subtract(valor));
                    contas[contaDestinataria].setContaCorrente(contas[contaDestinataria].getContaCorrente().add(valor));
                }
                return true;
            }
        } else {
            if (Conta.temSaldo(contas[contaRemetente], tipoRemetente, valor)){
                if (tipoRemetente == 1 && tipoDestinatario == 2) {
                    contas[contaRemetente].setContaCorrente(contas[contaRemetente].getContaCorrente().subtract(valor));
                    contas[contaDestinataria].setContaPoupanca(contas[contaDestinataria].getContaPoupanca().add(valor));
                } else if (tipoRemetente == 2 && tipoDestinatario == 1) {
                    contas[contaRemetente].setContaPoupanca(contas[contaRemetente].getContaPoupanca().subtract(valor));
                    contas[contaDestinataria].setContaCorrente(contas[contaDestinataria].getContaCorrente().add(valor));
                } else if (tipoRemetente == 3 && tipoDestinatario == 1) {
                    contas[contaRemetente].setContaInvestimento(contas[contaRemetente].getContaInvestimento().subtract(valor));
                    contas[contaDestinataria].setContaCorrente(contas[contaDestinataria].getContaCorrente().add(valor));
                }
                return true;
            }
        }
        return false;
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
