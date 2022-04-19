package com.company;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.Year;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.YEARS;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Ожидаю ввод данных в формате:\n \"Фамилия Имя Отчество\n День.Месяц.Год (или через другой разделитель)\"\n");
        String Surname = scanner.next();
        String Name = scanner.next();
        String Otchestvo = scanner.next();
        String gender = "Other";




        Scanner scanner2 = new Scanner(System.in).useDelimiter("\\D");
        int YearOfBirth=0;
        int MonthOfBirth=0;
        int DayOfBirth=0;
        try {
            DayOfBirth = scanner2.nextInt();
            MonthOfBirth = scanner2.nextInt();
            YearOfBirth = scanner2.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Please, type numbers only in date section!");
        }



        LocalDate cur_date2 = LocalDate.now();
        try{
            cur_date2 = LocalDate.of(YearOfBirth,MonthOfBirth,DayOfBirth);
        }
        catch (DateTimeException e) {
            throw new DateTimeException("Please input correct date!");
        }
       // System.out.println(cur_date2);
        String dob2Parse = "" + YearOfBirth + "-";


        if (Otchestvo.endsWith("на")) {
            gender = "Female";
        }
        else if(Otchestvo.endsWith("ич"))
        {
            gender="Male";
        }


        LocalDate cur_date = LocalDate.now();
        long diff = YEARS.between(cur_date2, cur_date);



        // otvet
        System.out.println("\n" + Surname + " " + Name.charAt(0) + "." + Otchestvo.charAt(0) + ".\n" +gender +" , "+ diff + " years old");


    }
}