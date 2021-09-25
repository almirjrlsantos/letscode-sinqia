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
        clientes[0] = new Cliente("Maria","PF",0001);
        contas[0] = new Conta(clientes[0].getNumContaCliente());

        clientes[1] = new Cliente("João","PF", 0002);
        contas[1] = new Conta(clientes[1].getNumContaCliente(), new BigDecimal(1000));

        clientes[2] = new Cliente("Empresa1","PJ", 0003);
        contas[2] = new Conta(clientes[2].getNumContaCliente(), new BigDecimal(500));

        // ================================
        //APAGAR DEPOIS
        //SEM MENU
//        exibirContas();
//        Cliente cliente = clientes[2];
//        investimento(cliente);
//        // ========================================

        boolean loop = true;
        while(loop){
            exibirPaginaInicial();
            int opcao = scan.nextInt();
            switch (opcao) {
                case 0:
                    loop = false;
                    break;
                case 1:
                    abrirConta();
                    break;
                case 2:
                   acessarConta();
                   break;
            }
        }
        scan.close();

    }

    private static void acessarConta() {
        System.out.println("Informe a conta que deseja acessar:");
        int contaSelecionada;
        do{
            contaSelecionada = selecionarConta();
            if(contaSelecionada == -1 ){
                System.out.println("Conta Inválida\n");
            }
        }while (contaSelecionada == -1);

        Cliente cliente = clientes[contaSelecionada];
        Conta conta = contas[contaSelecionada];
        System.out.println(cliente.toString());// APAGAR

        while(contaSelecionada != -1){
            menuLogado();
            int opcao = scan.nextInt();
            switch (opcao){
                case 0:
                    contaSelecionada = -1;
                    break;
                case 2:
                    saque(cliente, conta);
                    break;
                case 3:
                    deposito(cliente, conta);
                    break;
                case 4:
                    transferencia(cliente);
                    break;
                case 5:
                    investimento(cliente, conta);
                    break;
                case 6:
                    consultarSaldo(cliente);
                    break;
                case 99: /// APAGAR
                    exibirContas();
                default:;

            }

        }
    }

    public static void exibirPaginaInicial(){

        System.out.println("================== Bank AM ==================\n");
        System.out.println("Informe a opção que deseja usar:");
        System.out.println("[1] - Abrir Conta");
        System.out.println("[2] - Acessar Conta");
        System.out.println("[0] - Sair");
        System.out.println("\n=============================================\n");
        System.out.print("===> ");
    }

    public static void menuLogado(){

        System.out.println("================== Bank AM ==================\n");
        System.out.println("Informe a opção que deseja usar:");
        System.out.println("[2] - Saque");
        System.out.println("[3] - Deposito");
        System.out.println("[4] - Transferência");
        System.out.println("[5] - Investir");
        System.out.println("[6] - Consultar Saldo");
        System.out.println("[0] - Sair");
        System.out.println("\n=============================================\n");
        System.out.print("===> ");
    }

    private static void abrirConta() {
        System.out.println("\nEntrou em abrir conta\n\n");
    }

    private static void saque(Cliente cliente, Conta conta) {
        System.out.println("================== Bank AM - Saque ==================\n");
        if(cliente.getTipo().equals("PF")) {
            System.out.println("De qual conta deseja sacar?");
            System.out.println("[1] - Conta corrente");
            System.out.println("[2] - Conta poupança");
            System.out.println("[3] - Conta investimento");
            System.out.println("[0] - Cancelar Saque");
            int tipoContasaque;
            do {
                System.out.printf("===> ");
                tipoContasaque = scan.nextInt();
            }while(tipoContasaque < 0 || tipoContasaque > 3);
            if(tipoContasaque!=0){
                System.out.println("Qual valor deseja sacar?");
                System.out.printf("===> ");
                BigDecimal valor = scan.nextBigDecimal();
                conta.sacar(cliente, conta,tipoContasaque, valor);

            }
        } else {
            System.out.println("De qual conta deseja sacar?");
            System.out.println("[1] - Conta corrente");
            System.out.println("[2] - Conta investimento");
            System.out.println("[0] - Cancelar Saque");
            int tipoContasaque;
            do {
                System.out.printf("===> ");
                tipoContasaque = scan.nextInt();
            }while(tipoContasaque < 0 || tipoContasaque > 2);
            if(tipoContasaque!=0){
                if(tipoContasaque == 2){
                    tipoContasaque = 3;
                }
                System.out.println("Qual valor deseja sacar?");
                System.out.printf("===> ");
                BigDecimal valor = scan.nextBigDecimal();
                conta.sacar(cliente, conta,tipoContasaque, valor);

            }
        }
        System.out.println("=====================================================\n");
    }

    private static void deposito(Cliente cliente, Conta conta) {
        System.out.println("================== Bank AM - Deposito ==================\n");

        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor informe para qual conta deseja depositar");
        if (cliente.getTipo() == "PF") {
            System.out.println("Para qual conta deseja depositar");
            System.out.println("[1] - Conta corrente");
            System.out.println("[2] - Conta poupança");
            System.out.println("[0] - Cancelar Deposito");
            int contaSelecionada = sc.nextInt();

            System.out.println("Por favor informe o valor que deseja depositar: ");
            Scanner dValor = new Scanner(System.in);
            BigDecimal valor = dValor.nextBigDecimal();

            switch (contaSelecionada) {
                case 0:
                    System.out.println("Deposito Cancelado");
                    break;
                case 1: // CC
                    conta.depositar(cliente, conta, valor, contaSelecionada);
                    System.out.println("Deposito realizado com sucesso.");
                    break;

                case 2:  //CP
                    conta.depositar(cliente, conta, valor, contaSelecionada);
                    System.out.println("Deposito realizado com sucesso.");
                    break;

                default:
                    break;
            }

        } else {
            System.out.println("Deseja confirmar deposito: ");
            System.out.println("[1] - Conta corrente");
            System.out.println("[0] - Cancelar Deposito");
            int contaSelecionada = sc.nextInt();

            System.out.println("Por favor informe o valor que deseja depositar: ");
            Scanner dValor = new Scanner(System.in);
            BigDecimal valor = dValor.nextBigDecimal();
            switch (contaSelecionada) {
                case 0:
                    System.out.println("Deposito Cancelado");
                    break;

                case 1:
                    conta.depositar(cliente, conta, valor, contaSelecionada);
                    System.out.println("Deposito realizado com sucesso.");
                    break;
            }
        }
        System.out.println("\n================================================\n");
    }

    private static void transferencia(Cliente cliente) {
        int numConta = cliente.getNumContaCliente() - 1;
        System.out.println("================== Bank AM - Transferencias ==================\n");
        System.out.println("Qual a conta do destinatário:");
        int clienteDestinatario = selecionarConta();
        if(clienteDestinatario != -1){

            if(clienteDestinatario != numConta){
                if(clientes[numConta].getTipo() == "PF"){
                    System.out.println("De qual conta deseja transferir?");
                    System.out.println("[1] - Conta corrente");
                    System.out.println("[2] - Conta poupança");
                    System.out.println("[0] - Cancelar transferência");
                    int tipoContaRemetente;
                    do{
                        System.out.printf("===> ");
                        tipoContaRemetente = scan.nextInt();
                        switch (tipoContaRemetente){
                                case 0:
                                    System.out.printf("Transferencia Cancelada");
                                    break;

                                case 1:
                                    System.out.println("Qual valor deseja transferir?");
                                    System.out.printf("===> ");
                                    BigDecimal valor = scan.nextBigDecimal();
                                    if(Conta.transferir(clientes, contas, numConta, clienteDestinatario, tipoContaRemetente,1, valor)){
                                        System.out.println("Transferencia realizada.\n\n");
                                    } else {
                                        System.out.println("Saldo insuficiente!\nTransferencia cancelada.\n\n");
                                    }
                                    break;

                                case 2:
                                    System.out.println("Qual valor deseja transferir?");
                                    System.out.printf("===> ");
                                    valor = scan.nextBigDecimal();
                                    if(Conta.transferir(clientes, contas, numConta, clienteDestinatario, tipoContaRemetente,1, valor)){
                                        System.out.println("Transferencia realizada.\n\n");
                                    } else {
                                        System.out.println("Saldo insuficiente!\nTransferencia cancelada.\n\n");
                                    }
                                    break;
                        }
                    }while(tipoContaRemetente < 0 || tipoContaRemetente > 2);

                } else {
                    //PJ
                    int tipoRemetente = 1;
                    System.out.println("Qual valor deseja transferir?");
                    System.out.printf("===> ");
                    BigDecimal valor = scan.nextBigDecimal();
                    if(Conta.transferir(clientes, contas, numConta, clienteDestinatario, tipoRemetente,1, valor)){
                        System.out.println("Transferencia realizada.\n\n");
                    } else {
                        System.out.println("Saldo insuficiente!\nTransferencia cancelada.\n\n");
                    }
                }
            } else {
                if(clientes[numConta].getTipo() == "PF"){
                    System.out.println("[1] - Conta corrente -> Conta poupança");
                    System.out.println("[2] - Conta poupança -> Conta corrente");
                    System.out.println("[3] - Investimento -> Conta corrente");
                    System.out.println("[0] - Cancelar Transferência");
                    int tipoContaRemetente;
                    do{
                        System.out.printf("===> ");
                        tipoContaRemetente = scan.nextInt();
                        switch (tipoContaRemetente){
                            case 0:
                                System.out.printf("Transferencia Cancelada");
                                break;

                            case 1:
                                System.out.println("Qual valor deseja transferir?");
                                System.out.printf("===> ");
                                BigDecimal valor = scan.nextBigDecimal();
                                if(Conta.transferir(clientes, contas, numConta, clienteDestinatario, tipoContaRemetente,2, valor)){
                                    System.out.println("Transferencia realizada.\n\n");
                                } else {
                                    System.out.println("Saldo insuficiente!\nTransferencia cancelada.\n\n");
                                }
                                break;

                            case 2:
                                System.out.println("Qual valor deseja transferir?");
                                System.out.printf("===> ");
                                valor = scan.nextBigDecimal();
                                if(Conta.transferir(clientes, contas, numConta, clienteDestinatario, tipoContaRemetente,1, valor)){
                                    System.out.println("Transferencia realizada.\n\n");
                                } else {
                                    System.out.println("Saldo insuficiente!\nTransferencia cancelada.\n\n");
                                }
                                break;

                            case 3:
                                System.out.println("Qual valor deseja transferir?");
                                System.out.printf("===> ");
                                valor = scan.nextBigDecimal();
                                if(Conta.transferir(clientes, contas, numConta, clienteDestinatario, tipoContaRemetente,1, valor)){
                                    System.out.println("Transferencia realizada.\n\n");
                                } else {
                                    System.out.println("Saldo insuficiente!\nTransferencia cancelada.\n\n");
                                }
                                break;
                        }
                    }while(tipoContaRemetente < 0 || tipoContaRemetente > 2);

                } else {
                    int contaRemetente = 3;
                    System.out.println("Transferir de Investimento -> Conta corrente");
                    System.out.println("Qual valor deseja transferir?");
                    System.out.printf("===> ");
                    BigDecimal valor = scan.nextBigDecimal();
                    if(Conta.transferir(clientes, contas, numConta, clienteDestinatario, contaRemetente,1, valor)){
                        System.out.println("Transferencia realizada.\n\n");
                    } else {
                        System.out.println("Saldo insuficiente!\nTransferencia cancelada.\n\n");
                    }
                }
            }
        } else {
            System.out.println("Conta destinatária inválida!\nTransferencia cancelada.\n\n");
        }
        System.out.println("==============================================================\n");
    }

    private static void investimento (Cliente cliente, Conta conta){
        System.out.println("================== Bank AM - Investimento ==================\n");

        Investir p1 = new Investir();
        System.out.println("Qual valor deseja investir? ");
        System.out.printf("===> ");
        BigDecimal valor = scan.nextBigDecimal();
        if (Conta.temSaldo(cliente, contas[cliente.getNumContaCliente() -1], 1, valor)) {
            p1.investir(valor, cliente, conta);
            p1.dados(valor);
        } else {
            System.out.println("Saldo insuficiente para esta operação.\n\n ");
        }
        System.out.println("\n======================================================\n");
    }

    private static void consultarSaldo(Cliente cliente) {
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

