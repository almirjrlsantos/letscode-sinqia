package br.com.letscode.java.atividadeGrupo;

import java.math.BigDecimal;
import java.util.Scanner;

public class Aplicacao {
///  MUDANÇA DESSES PARA STATIC // DOIS METODOS NO FINAL DO ARQUIVO // APAGAR CASE 99 MENU
    static Cliente[] clientes = new Cliente[10];
    static Conta[] contas = new Conta[10];
    static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        //Três clientes previamente cadastrados
        clientes[0] = new Cliente("Maria","PF", 0001);
        contas[0] = new Conta(clientes[0].getNumContaCliente());

        clientes[1] = new Cliente("João","PF", 0002);
        contas[1] = new Conta(clientes[1].getNumContaCliente(), new BigDecimal(1000));

        clientes[2] = new Cliente("Empresa1","PJ", 0003);
        contas[2] = new Conta(clientes[2].getNumContaCliente(), new BigDecimal(500));

        exibirContas();

        boolean loop = true;
        while(loop){

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
                case 99: /// APAGAR
                    exibirContas();
                default:;

            }

        }
        scan.close();

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
        System.out.println("\nTransferencia");
        System.out.println("Qual a conta remetente:");
        int clienteRemetente = selecionarConta();
        if(clienteRemetente != -1){
            System.out.println("Qual a conta do destinatário:");
            int clienteDestinatario = selecionarConta();
            if(clienteDestinatario != -1){

                if(clienteDestinatario != clienteRemetente){
                    System.out.println("De qual conta deseja transferir?");
                    if(clientes[clienteRemetente].getTipo() == "PF"){
                        System.out.println("[1] - Conta corrente");
                        System.out.println("[2] - Conta poupança");
                        System.out.println("[0] - Cancelar transferência");
                        int contaRemetente;
                        do{
                            System.out.printf("===> ");
                            contaRemetente = scan.nextInt();
                            switch (contaRemetente){
                                    case 0:
                                        System.out.printf("Transferencia Cancelada");
                                        break;
                                    case 1:
                                        System.out.println("Qual valor deseja transferir?");
                                        System.out.printf("===> ");
                                        BigDecimal valor = scan.nextBigDecimal();
                                        if(Conta.transferir(clientes, contas, clienteRemetente, clienteDestinatario, contaRemetente,1, valor)){
                                            System.out.println("Transferencia realizada.\n\n");
                                        } else {
                                            System.out.println("Saldo insuficiente!\nTransferencia cancelada.\n\n");
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Qual valor deseja transferir?");
                                        System.out.printf("===> ");
                                        valor = scan.nextBigDecimal();
                                        if(Conta.transferir(clientes, contas, clienteRemetente, clienteDestinatario, contaRemetente,1, valor)){
                                            System.out.println("Transferencia realizada.\n\n");
                                        } else {
                                            System.out.println("Saldo insuficiente!\nTransferencia cancelada.\n\n");
                                        }
                                        break;
                            }
                        }while(contaRemetente < 0 || contaRemetente > 2);

                    } else {
                        //PJ
                        int tipoRemetente = 1;
                        System.out.println("Qual valor deseja transferir?");
                        System.out.printf("===> ");
                        BigDecimal valor = scan.nextBigDecimal();
                        if(Conta.transferir(clientes, contas, clienteRemetente, clienteDestinatario, tipoRemetente,1, valor)){
                            System.out.println("Transferencia realizada.\n\n");
                        } else {
                            System.out.println("Saldo insuficiente!\nTransferencia cancelada.\n\n");
                        }
                    }
                    //Transferencia entre mesma conta
                } else {
                    System.out.println("De qual conta deseja transferir?");
                    if(clientes[clienteRemetente].getTipo() == "PF"){
                        System.out.println("[1] - Conta corrente -> Conta poupança");
                        System.out.println("[2] - Conta poupança -> Conta corrente");
                        System.out.println("[3] - Investimento -> Conta corrente");
                        System.out.println("[0] - Cancelar Transferência");
                        int contaRemetente;
                        do{
                            System.out.printf("===> ");
                            contaRemetente = scan.nextInt();
                            switch (contaRemetente){
                                case 0:
                                    System.out.printf("Transferencia Cancelada");
                                    break;
                                case 1:
                                    System.out.println("Qual valor deseja transferir?");
                                    System.out.printf("===> ");
                                    BigDecimal valor = scan.nextBigDecimal();
                                    if(Conta.transferir(clientes, contas, clienteRemetente, clienteDestinatario, contaRemetente,2, valor)){
                                        System.out.println("Transferencia realizada.\n\n");
                                    } else {
                                        System.out.println("Saldo insuficiente!\nTransferencia cancelada.\n\n");
                                    }
                                    break;
                                case 2:
                                    System.out.println("Qual valor deseja transferir?");
                                    System.out.printf("===> ");
                                    valor = scan.nextBigDecimal();
                                    if(Conta.transferir(clientes, contas, clienteRemetente, clienteDestinatario, contaRemetente,1, valor)){
                                        System.out.println("Transferencia realizada.\n\n");
                                    } else {
                                        System.out.println("Saldo insuficiente!\nTransferencia cancelada.\n\n");
                                    }
                                    break;
                                case 3:
                                    System.out.println("Qual valor deseja transferir?");
                                    System.out.printf("===> ");
                                    valor = scan.nextBigDecimal();
                                    if(Conta.transferir(clientes, contas, clienteRemetente, clienteDestinatario, contaRemetente,1, valor)){
                                        System.out.println("Transferencia realizada.\n\n");
                                    } else {
                                        System.out.println("Saldo insuficiente!\nTransferencia cancelada.\n\n");
                                    }
                                    break;
                            }
                        }while(contaRemetente < 0 || contaRemetente > 2);

                    } else {
                        int contaRemetente = 3;
                        System.out.println("Transferir de Investimento -> Conta corrente");
                        System.out.println("Qual valor deseja transferir?");
                        System.out.printf("===> ");
                        BigDecimal valor = scan.nextBigDecimal();
                        if(Conta.transferir(clientes, contas, clienteRemetente, clienteDestinatario, contaRemetente,1, valor)){
                            System.out.println("Transferencia realizada.\n\n");
                        } else {
                            System.out.println("Saldo insuficiente!\nTransferencia cancelada.\n\n");
                        }
                    }
                }
            } else {
                System.out.println("Conta destinatária inválida!\nTransferencia cancelada.\n\n");
            }
        } else {
            System.out.println("Conta do remetente inválida!\nTransferencia cancelada.\n\n");
        }
    }



    private static void investimento() {
        System.out.println("\nEntrou em investimento\n\n");
    }

    private static void consultarSaldo() {
        System.out.println("\nEntrou em consultar saldo\n\n");
    }

    private static int selecionarConta(){
        System.out.printf("===>: ");
        int contaInformada = scan.nextInt();

        if(Cliente.contaExiste(clientes, contaInformada)){
            return contaInformada-1;
        }
        return -1;
    }

    private static void exibirContas() {
        for(int i=0; i<clientes.length; i++) {
            if(clientes[i] == null){
                break;
            }
            System.out.println(clientes[i].toString());
            System.out.println(contas[i].toString());
            System.out.println();
        }
    }
}

