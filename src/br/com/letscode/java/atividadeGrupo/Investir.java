package br.com.projeto.java;

public class Investir {
    private double totalInvestido;
    private double rendimentos;
    private double totalPatrimonio;
    private String tipo;

    public void dados() {
        System.out.println("Tipo de Conta: " + this.getTipo());
        System.out.println("Total Investido: " + this.getTotalInvestido());
        System.out.println("Rendimentos: " + this.getRendimentos());
        System.out.println("Total do Patrimônio: " + this.getTotalPatrimonio());


    }

    public Investir() {

    }

    public Investir(double totalInvestido, double rendimentos, double totalPatrimonio, String tipo) {
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

    public void investir(double valor) {
        if (this.getTotalInvestido() >= 10) {
            this.setTotalInvestido(this.getTotalInvestido() + valor);

            if (this.getTipo() == "PF") {
                double PF_JUROS_INVESTIMENTO = 0.03;
                this.setTotalPatrimonio(this.getTotalInvestido() + this.getTotalInvestido() * PF_JUROS_INVESTIMENTO);
                this.setRendimentos(this.getTotalInvestido() * PF_JUROS_INVESTIMENTO);

            }
            if (this.getTipo() == "PJ") {
                double PF_JUROS_INVESTIMENTO = 0.03;
                double PJ_JUROS_INVESTIMENTO = PF_JUROS_INVESTIMENTO + 0.02;
                this.setTotalPatrimonio(this.getTotalInvestido() + this.getTotalInvestido() * PJ_JUROS_INVESTIMENTO);
                this.setRendimentos(this.getTotalInvestido() * PJ_JUROS_INVESTIMENTO);

            }
        } else {
            System.out.println("Valor minimo para investimento R$10,00. ");

        }
    }
}

