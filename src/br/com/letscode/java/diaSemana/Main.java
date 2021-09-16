package br.com.letscode.java.diaSemana;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import static java.time.format.TextStyle.*;
import java.util.Locale;

public class Main {

    static final DayOfWeek dow = LocalDate.now().getDayOfWeek();
    static final Locale PT_BR =  new Locale("pt", "BR");

    public static void main(String[] args) {

        diaSemanaF(FULL);
        diaSemanaF(SHORT);
        diaSemanaF(NARROW);
    }

    public static void diaSemanaF(TextStyle estilo){
        String diaSemana = dow.getDisplayName(estilo, PT_BR);
        System.out.println(diaSemana);
    }
}
