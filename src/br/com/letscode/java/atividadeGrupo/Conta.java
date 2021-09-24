package br.com.letscode.java.atividadeGrupo;

import java.math.BigDecimal;

public class Conta { // STATIC NAS CONSTANTES // CORRIGIR DE MULT PARA SOMA // CORRIGIR PORCENTAGEM
    final static private double PF_JUROS_INVESTIMENTO = 0.03;
    final static private double PJ_TAXA_SAQUE_TRANSFER = 0.005;
    final static private double PJ_JUROS_INVESTIMENTO = PF_JUROS_INVESTIMENTO + 0.02;

    private int numConta;
    private BigDecimal contaCorrente = new BigDecimal(0); // 1
    private BigDecimal contaPoupanca = new BigDecimal(0); // 2
    private BigDecimal contaInvestimento = new BigDecimal(0); //3

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

    public static boolean temSaldo(Cliente cliente, Conta conta, int tipo, BigDecimal valor){
        if(cliente.getTipo() == "PJ"){
            valor = valor.multiply(BigDecimal.valueOf(1+PJ_TAXA_SAQUE_TRANSFER));
        }
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

    public static boolean transferir(Cliente[] clientes, Conta[] contas, int numContaRemetente, int numContaDestinataria, int tipoContaRemetente, int tipoContaDestinatario, BigDecimal valor){
        Conta contaRemetente = contas[numContaRemetente];
        BigDecimal valorEmCC = contaRemetente.getContaCorrente();
        BigDecimal valorEmCP = contaRemetente.getContaPoupanca();
        BigDecimal valorEmCI = contaRemetente.getContaInvestimento();

        Conta contaDestinataria = contas[numContaDestinataria];
        BigDecimal valorEmCCdestino = contaDestinataria.getContaCorrente();
        BigDecimal valorEmCPdestino = contaDestinataria.getContaPoupanca();

        BigDecimal valorDebitado = valor;
        if(clientes[numContaRemetente].getTipo() == "PJ"){
            valorDebitado = valor.multiply(BigDecimal.valueOf(1+PJ_TAXA_SAQUE_TRANSFER));
        }

        if (Conta.temSaldo(clientes[numContaRemetente], contaRemetente, tipoContaRemetente, valor)) {
            if (tipoContaRemetente == 1 && tipoContaDestinatario == 1) {
                contaRemetente.setContaCorrente(valorEmCC.subtract(valorDebitado));
                contaDestinataria.setContaCorrente(valorEmCCdestino.add(valor));
            } else if (tipoContaRemetente == 1 && tipoContaDestinatario == 2) {
                contaRemetente.setContaCorrente(valorEmCC.subtract(valorDebitado));
                contaDestinataria.setContaPoupanca(valorEmCPdestino.add(valor));
            } else if (tipoContaRemetente == 2 && tipoContaDestinatario == 1) {
                contaRemetente.setContaPoupanca(valorEmCP.subtract(valorDebitado));
                contaDestinataria.setContaCorrente(valorEmCCdestino.add(valor));
            } else if (tipoContaRemetente == 3 && tipoContaDestinatario == 1) {
                contaRemetente.setContaInvestimento(valorEmCI.subtract(valorDebitado));
                contaDestinataria.setContaCorrente(valorEmCCdestino.add(valor));
            }
            return true;
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
