package br.com.letscode.java.diaSemana;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DataArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite uma data no formato: DD/MM/AAAA ");
        String[] data = scan.nextLine().split("/");
        String dataFormatada = data[2]+"-"+data[1]+"-"+data[0];

        // resposta 1 - por extenso
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy");
        System.out.println(LocalDate.parse(dataFormatada).format(formato));

        // resposta 2
        if(LocalDate.parse(dataFormatada).getDayOfWeek().getValue() >= 6){
            System.out.println("É fim de semana");
        } else {
            System.out.println("Não é fim de semana");
        }

        // resposta 3 - ano bissexto
        if (LocalDate.parse(dataFormatada).isLeapYear()){
            System.out.println("É ano bissexto");
        } else {
            System.out.println("Não é ano bissexto");
        }
    }
}
