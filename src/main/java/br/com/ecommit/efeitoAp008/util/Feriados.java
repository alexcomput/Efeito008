package br.com.ecommit.efeitoAp008.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Feriados {
    public static boolean diaUtil(LocalDate date) {
        List<LocalDate> list = getFeriado();
        boolean condicao = true;
        while (condicao) {
            LocalDate finalDate = date;
            condicao = list.stream().anyMatch(date1 -> date1.equals(finalDate));
            if (condicao) {
                date = date.plusDays(1);
            }
        }
        return condicao;
    }

    public static List<LocalDate> getFeriado() {
        List<LocalDate> feriados = new ArrayList();
        feriados.add(LocalDate.parse("2020-01-01"));
        feriados.add(LocalDate.parse("2020-02-24"));
        feriados.add(LocalDate.parse("2020-02-25"));
        feriados.add(LocalDate.parse("2020-04-10"));
        feriados.add(LocalDate.parse("2020-04-21"));
        feriados.add(LocalDate.parse("2020-05-01"));
        feriados.add(LocalDate.parse("2020-06-11"));
        feriados.add(LocalDate.parse("2020-09-07"));
        feriados.add(LocalDate.parse("2020-10-12"));
        feriados.add(LocalDate.parse("2020-11-02"));
        feriados.add(LocalDate.parse("2020-11-15"));
        feriados.add(LocalDate.parse("2020-12-25"));
        feriados.add(LocalDate.parse("2021-01-01"));
        feriados.add(LocalDate.parse("2021-02-15"));
        feriados.add(LocalDate.parse("2021-02-16"));
        feriados.add(LocalDate.parse("2021-04-02"));
        feriados.add(LocalDate.parse("2021-04-21"));
        feriados.add(LocalDate.parse("2021-05-01"));
        feriados.add(LocalDate.parse("2021-06-03"));
        feriados.add(LocalDate.parse("2021-09-07"));
        feriados.add(LocalDate.parse("2021-10-12"));
        feriados.add(LocalDate.parse("2021-11-02"));
        feriados.add(LocalDate.parse("2021-11-15"));
        feriados.add(LocalDate.parse("2021-12-25"));
        feriados.add(LocalDate.parse("2022-01-01"));
        feriados.add(LocalDate.parse("2022-02-15"));
        feriados.add(LocalDate.parse("2022-02-16"));
        feriados.add(LocalDate.parse("2022-04-02"));
        feriados.add(LocalDate.parse("2022-04-21"));
        feriados.add(LocalDate.parse("2022-05-01"));
        feriados.add(LocalDate.parse("2022-06-03"));
        feriados.add(LocalDate.parse("2022-09-07"));
        feriados.add(LocalDate.parse("2022-10-12"));
        feriados.add(LocalDate.parse("2022-11-02"));
        feriados.add(LocalDate.parse("2022-11-15"));
        feriados.add(LocalDate.parse("2022-12-25"));
        return feriados;
    }

    public static boolean fimDeSemana(LocalDate ld) {
        DayOfWeek d = ld.getDayOfWeek();
        return d == DayOfWeek.SATURDAY || d == DayOfWeek.SUNDAY;
    }
}

