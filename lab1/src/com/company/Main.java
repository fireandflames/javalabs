package com.company;
import java.time.*;
import java.util.ArrayList;
import java.util.Scanner;

/*Создать классы, спецификации которых приведены ниже.
Определить кон-структоры и методы setТип(), getТип(), toString().
Определить дополнительно методы в классе, создающем массив объектов.
Задать критерий выбора данных и вывести эти данные на консоль.
В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.
12. Airline: Пункт назначения, Номер рейса, Тип самолета, Время вылета, Дни недели.

        Создать массив объектов. Вывести:

        a) список рейсов для заданного пункта назначения;

        b) список рейсов для заданного дня недели;

        c) список рейсов для заданного дня недели, время вылета для которых больше заданного. */
public class Main {

    public static void getAirlinesByAirport(ArrayList<Airline> airlines, String destination) { //a
        boolean resultZero = true;

        for (int i = 0; i < airlines.size(); i++) {
            if (airlines.get(i).getDestination().equalsIgnoreCase(destination)) {
                System.out.println(airlines.get(i).toString());
                resultZero = false;
            }
        }
        if (resultZero) {
            System.out.println("No matches found!");
        }
        System.out.println("*****************************************************************************************");
    }

    public static void getAirlinesByDay(ArrayList<Airline> airlines, String day) { //b
        boolean resultZero = true;

        for (int i = 0; i < airlines.size(); i++) {
            if (airlines.get(i).getDays().contains(day)) {
                System.out.println(airlines.get(i).toString());
                resultZero = false;
            }
        }
        if (resultZero) {
            System.out.println("No matches found!");
        }
        System.out.println("*****************************************************************************************");
    }

    public static void getAirlinesByDayAndTime(ArrayList<Airline> airlines, String day, LocalTime time) { //c
        boolean resultZero = true;

        for (int i = 0; i < airlines.size(); i++) {
            if (airlines.get(i).getDays().contains(day) && airlines.get(i).getDeparture_time().isAfter(time))  {
                System.out.println(airlines.get(i).toString());
                resultZero = false;
            }
        }
        if (resultZero) {
            System.out.println("No matches found!");
        }
        System.out.println("*****************************************************************************************");
    }
    public static void main(String[] args) {

        ArrayList<Airline> airlines = Airline.createAirlines();
        Scanner sc = new Scanner(System.in);
        boolean active = true;
        while(active)
        {
            System.out.println("Welcome! Please select an option:" );
            System.out.println("1. Get airlines by destination");
            System.out.println("2. Get airlines by day");
            System.out.println("3. Get airlines by day and date");
            System.out.println("4. Exit");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1 : {
                    System.out.println("Please enter destination");
                    String destination = sc.next();
                    getAirlinesByAirport(airlines, destination);
                } break;
                case 2 : {
                    System.out.println("Please enter day");
                    String day = sc.next();
                    getAirlinesByDay(airlines, day);
                } break;
                case 3 : {
                    System.out.println("Please enter day");
                    String day = sc.next();
                    System.out.println("Please enter date in HH:MM format");
                    String time = sc.next();
                    LocalTime depart_time=LocalTime.parse(time);
                    getAirlinesByDayAndTime(airlines, day, depart_time);
                } break;
                case 4 : {
                    return;
                }
                default: {
                    System.out.println("You've entered the wrong button!");
                    break;
                }
            }

        }

    }
}
