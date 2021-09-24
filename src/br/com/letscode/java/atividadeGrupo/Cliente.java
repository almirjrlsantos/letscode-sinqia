package br.com.letscode.java.atividadeGrupo;

import java.util.Scanner;

public class Cliente {
    private String nomeCliente;
    private String tipo; // Se é PF ou PJ
    private int numContaCliente;

    private Cliente() {}

    public Cliente(String nomeCliente, String tipo, int contaCliente) {
        this.nomeCliente = nomeCliente;
        this.tipo = tipo;
        this.numContaCliente = contaCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getNumContaCliente() {
        return numContaCliente;
    }

    public void setNumContaCliente(int numContaCliente) {
        this.numContaCliente = numContaCliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public static boolean contaExiste(Cliente[] clientes, int contaInformada){
        for(int i=0; i< clientes.length; i++){
            if(clientes[i] == null){
                return false;
            }
            if(clientes[i].getNumContaCliente() == contaInformada){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nomeCliente='" + nomeCliente + '\'' +
                ", tipo='" + tipo + '\'' +
                ", numContaCliente=" + numContaCliente +
                '}';
    }
}
