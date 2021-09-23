package br.com.letscode.java.atividadeGrupo;

import java.math.BigDecimal;
import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) {

        //Três clientes previamente cadastrados
        Cliente[] clientes = new Cliente[10];
        Conta[] contas = new Conta[10];

        clientes[0] = new Cliente("Maria","PF", 0001);
        contas[0] = new Conta(clientes[0].getNumContaCliente());

        clientes[1] = new Cliente("João","PF", 0002);
        contas[1] = new Conta(clientes[1].getNumContaCliente(), new BigDecimal(1000));

        clientes[2] = new Cliente("Empresa1","PJ", 0003);
        contas[2] = new Conta(clientes[2].getNumContaCliente());

//        // Exibir contas
//        for(int i=0; i<clientes.length; i++) {
//            if(clientes[i] == null){
//                break;
//            }
//            System.out.println(clientes[i].toString());
//            System.out.println(contas[i].toString());
//            System.out.println();
//        }

        boolean loop = true;
        while(loop){
            Scanner scan = new Scanner(System.in);
            exibirPaginaInicial();
            int opcao = scan.nextInt();

            switch (opcao){
                case 0:
                    loop = false;
                    break;
                case 1:
                    abrirConta();
                    break;
                case 2:
                    saque();
                    break;
                case 3:
                    deposito();
                    break;
                case 4:
                    transferencia();
                    break;
                case 5:
                    investimento();
                    break;
                case 6:
                    consultarSaldo();
                    break;
                default:;

            }

        }


    }

    public static void exibirPaginaInicial(){

        System.out.println("================== Bank AM ==================");
        System.out.println();
        System.out.println("Informe a opção que deseja usar:");
        System.out.println("[1] - Abrir Conta");
        System.out.println("[2] - Saque");
        System.out.println("[3] - Deposito");
        System.out.println("[4] - Transferência");
        System.out.println("[5] - Investir");
        System.out.println("[6] - Consultar Saldo");
        System.out.println("[0] - Sair");
        System.out.println();
        System.out.println("=============================================");
        System.out.println();
        System.out.print("===> ");
    }

    private static void abrirConta() {
        System.out.println("\nEntrou em abrir conta\n\n");
    }

    private static void saque() {
        System.out.println("\nEntrou em saque\n\n");
    }

    private static void deposito() {
        System.out.println("\nEntrou em deposito\n\n");
    }

    private static void transferencia() {
        System.out.println("\nEntrou em transferencia\n\n");
    }

    private static void investimento() {
        System.out.println("\nEntrou em investimento\n\n");
    }

    private static void consultarSaldo() {
        System.out.println("\nEntrou em consultar saldo\n\n");
    }

}

