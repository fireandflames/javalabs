package com.company;

import java.time.LocalTime;
import java.util.ArrayList;

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
public class Airline {

    private String destination;
    private String flight_number;
    private PlaneType planeType;
    private LocalTime departure_time;
    private String days;

    public Airline(String destination, String flight_number, PlaneType planeType, LocalTime departure_time) {
        this.destination = destination;
        this.flight_number = flight_number;
        this.planeType = planeType;
        this.departure_time = departure_time;
        this.days = "Monday";
    }

    public Airline(String destination, String flight_number, LocalTime departure_time, String days) {
        this.destination = destination;
        this.flight_number = flight_number;
        this.planeType = PlaneType.commercial;
        this.departure_time = departure_time;
        this.days = days;
    }
    public Airline(String destination, String flight_number, PlaneType planeType, LocalTime departure_time, String days) {
        this.destination = destination;
        this.flight_number = flight_number;
        this.planeType = planeType;
        this.departure_time = departure_time;
        this.days = days;
    }

    public String getDestination() {
        return destination;
    }

    public String getFlight_number() {
        return flight_number;
    }

    public PlaneType getPlaneType() {
        return planeType;
    }

    public LocalTime getDeparture_time() {
        return departure_time;
    }

    public String getDays() {
        return days;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public void setPlaneType(PlaneType planeType) {
        this.planeType = planeType;
    }

    public void setDeparture_time(LocalTime departure_time) {
        this.departure_time = departure_time;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String toString()
    {
        return "Plane to " + this.destination + ", flight number is " + this.flight_number + ", plane type is " + planeType + ", departure time is " +
                departure_time + ", departs on " + days;
    }

    public static ArrayList<Airline> createAirlines()
    {
        ArrayList<Airline> airlines= new ArrayList<Airline>();
        airlines.add(new Airline("Minsk", "B-001", PlaneType.commercial, LocalTime.parse("14:10"), "Monday, Tuesday, Thursday"));
        airlines.add(new Airline("Moscow", "U-213", PlaneType.military, LocalTime.parse("23:12"), "Friday"));
        airlines.add(new Airline("Minsk", "A-123", PlaneType.commercial, LocalTime.parse("16:20"), "Monday, Wednesday, Sunday"));
        airlines.add(new Airline("Warsaw", "L-234", PlaneType.commercial, LocalTime.parse("08:45"), "Monday, Friday"));
        airlines.add(new Airline("Vilnius", "N-129", PlaneType.commercial, LocalTime.parse("00:00"), "Monday, Tuesday, Saturday"));
        return airlines;
    }


}
