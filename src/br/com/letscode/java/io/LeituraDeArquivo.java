package br.com.letscode.java.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeituraDeArquivo {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        Path enderecoArquivoEntrada = arquivoEntrada();
        Path enderecoArquivoSaida = arquivoSaida();

        //leitura(enderecoArquivoEntrada);

        addNaClasse(enderecoArquivoEntrada, pessoas);
        //exibirPessoas(pessoas);

        //copiarArquivo(enderecoArquivoEntrada.toString(), enderecoArquivoSaida.toString());

        exportarArrayClassePessoa(enderecoArquivoSaida.toString(), pessoas);

    }

    private static void exportarArrayClassePessoa(String enderecoArquivoSaida, List<Pessoa> pessoas) {
        System.out.println("========================================> EXPORTAR ARRAY PARA ARQUIVO");

        try(FileOutputStream arquivoSaida = new FileOutputStream(enderecoArquivoSaida)){
            for (Pessoa pessoa : pessoas){
                String linha = "";
                linha += pessoa.getNome()+",";
                linha += pessoa.getIdade()+",";
                linha += pessoa.getSexo().name()+"\n";
                byte[] linhaByte = linha.getBytes();
                arquivoSaida.write(linhaByte);
            }
        } catch (IOException e){
            System.out.println("Deu ruim");
        }
    }

    private static void copiarArquivo(String enderecoArquivoEntrada, String enderecoArquivoSaida) {
        System.out.println("========================================> COPIAR ARQUIVO");

        try (FileInputStream arquivoEntrada = new FileInputStream(enderecoArquivoEntrada);
             FileOutputStream arquivoSaida = new FileOutputStream(enderecoArquivoSaida)){

            int linha;
            while ((linha = arquivoEntrada.read()) != -1){
                arquivoSaida.write(linha);
            }

        } catch (IOException e){
            System.out.println("Deu ruim!");
        }
    }

    private static Path arquivoSaida() {
        String nomeArquivo = "arquivoSaidaIO.txt";
        String enderecoArquivo = System.getProperty("user.home") + "/IdeaProjects/letscode-sinqia/src/br/com/letscode/java/io/arquivos";
        return Path.of(enderecoArquivo, nomeArquivo);
    }

    private static Path arquivoEntrada(){
        String nomeArquivo = "arquivoLeituraIO.txt";
        String enderecoArquivo = System.getProperty("user.home") + "/IdeaProjects/letscode-sinqia/src/br/com/letscode/java/io/arquivos";
        return Path.of(enderecoArquivo, nomeArquivo);
    }

    private static void addNaClasse(Path enderecoArquivoEntrada, List<Pessoa> pessoas) {
        System.out.println("========================================> ADD EM UMA CLASSE");

        List<String> linhas;

        try (Stream<String> stremIO = Files.lines(enderecoArquivoEntrada)){
            linhas = stremIO.collect(Collectors.toList()); // cada linha em um endereço do List
            addPessoa(pessoas, linhas);
        } catch (IOException e) {
            System.err.println("Deu ruim!");
        }
    }

    private static void leitura(Path enderecoArquivoEntrada) {
        System.out.println("========================================> APENAS LEITURA");
        try (Stream<String> stremIO = Files.lines(enderecoArquivoEntrada)){
            stremIO.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Deu ruim!");
        }
    }

    private static void exibirPessoas(List<Pessoa> pessoas) {
        for(Pessoa pessoa : pessoas){
            System.out.println(pessoa.toString());
        }
    }

    private static void addPessoa(List<Pessoa> pessoas, List<String> linhas) {
        for(String l : linhas){
            String[] linha = l.split(","); //cada linha desmembrada
            String nome = linha[0];
            int idade = Integer.parseInt(linha[1].replace(" ",""));
            Sexo sexo = Sexo.valueOf(linha[2].replace(" ",""));

            pessoas.add(new Pessoa(nome, idade, sexo));
        }
    }
}
