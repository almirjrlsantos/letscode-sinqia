package br.com.letscode.java.atividadeGrupo;

import java.math.BigDecimal;

public class Investir {
    private double totalInvestido;
    private double rendimentos;
    private double totalPatrimonio;
    private String tipo;
    final static private double PF_JUROS_INVESTIMENTO = 0.03;
    final static private double PJ_JUROS_INVESTIMENTO = PF_JUROS_INVESTIMENTO + 0.02;

    public void dados(BigDecimal valor) {
        System.out.println("Total Investido: " + valor);
        System.out.println("Rendimentos: " + this.getRendimentos());
        System.out.println("Total do Patrimônio: " + this.getTotalPatrimonio());
        System.out.println("\n");

    }

    public Investir() {

    }

    public Investir(BigDecimal valor, double totalInvestido, double rendimentos, double totalPatrimonio, String tipo) {
        this.totalInvestido = totalInvestido;
        this.rendimentos = rendimentos;
        this.totalPatrimonio = totalPatrimonio;
        this.tipo = tipo;

    }

    public double getTotalInvestido() {
        return totalInvestido;
    }

    public void setTotalInvestido(double totalInvestido) {
        this.totalInvestido = totalInvestido;
    }

    public double getRendimentos() {
        return rendimentos;
    }

    public void setRendimentos(double rendimentos) {
        this.rendimentos = rendimentos;
    }

    public double getTotalPatrimonio() {
        return totalPatrimonio;
    }

    public void setTotalPatrimonio(double totalPatrimonio) {
        this.totalPatrimonio = totalPatrimonio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Investir{" +
                "totalInvestido=" + totalInvestido +
                ", rendimentos=" + rendimentos +
                ", totalPatrimônio=" + totalPatrimonio +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    public void investir(BigDecimal valor, Cliente cliente, Conta conta) {
        double valorConta = conta.getContaInvestimento().doubleValue();
        if (valor.doubleValue() >= 10) {
            this.setTotalInvestido(this.getTotalInvestido() + valor.doubleValue());

            if (cliente.getTipo() == "PF") {
                System.out.println("\nEntrou em PF");
                double PF_JUROS_INVESTIMENTO = 0.03;
                this.setTotalPatrimonio(valorConta + valor.doubleValue() * (PF_JUROS_INVESTIMENTO + 1));
                this.setTotalInvestido(getTotalInvestido() + valor.doubleValue());
                this.setRendimentos(this.getRendimentos() + valor.doubleValue() * PF_JUROS_INVESTIMENTO);
                conta.setContaInvestimento(BigDecimal.valueOf(this.getTotalPatrimonio()));
                conta.setContaCorrente(conta.getContaCorrente().subtract(valor));

            }
            if (cliente.getTipo() == "PJ") {
                System.out.println("\nEntrou em PJ");
                double PF_JUROS_INVESTIMENTO = 0.03;
                double PJ_JUROS_INVESTIMENTO = PF_JUROS_INVESTIMENTO + 0.02;
                this.setTotalPatrimonio(valorConta + valor.doubleValue() * (PJ_JUROS_INVESTIMENTO + 1));
                this.setTotalInvestido(getTotalInvestido() + valor.doubleValue());
                this.setRendimentos(this.getRendimentos() + valor.doubleValue() * PJ_JUROS_INVESTIMENTO);
                conta.setContaInvestimento(BigDecimal.valueOf(this.getTotalPatrimonio()));
                conta.setContaCorrente(conta.getContaCorrente().subtract(valor));

            }
        } else {
            System.out.println("Valor minimo para investimento R$10,00. \n");

        }
    }

}

