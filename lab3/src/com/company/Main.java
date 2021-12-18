package com.company;
import com.company.plans.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/*Мобильная связь. Определить иерархию тарифов мобильной компании. Создать список тарифов компании.
Подсчитать общую численность клиентов.
 Провести сортировку тарифов на основе размера абонентской платы.
 Найти тариф в компании, соответствующий заданному диапазону параметров.*/

public class Main {
    private static final ArrayList<Client> clients = new ArrayList<>();
    private static final ArrayList<Plan> planList = new ArrayList<>();


    public static void setClients() {
        for(int i=1; i<=10; i++)
        {
            Random random = new Random();
            int planIndex = random.nextInt(planList.size());
            Plan selectedPlan = planList.get(planIndex);
            String organization = "Organization #" + i;
            int number = random.nextInt(100000);
            clients.add(new Client(selectedPlan, organization, number));
        }
    }

    public static void setPlans() {
        try{
            Scanner scanner = new Scanner(new File("src/plans.txt"));
            while(scanner.hasNextDouble())
            {
                double pricing = scanner.nextDouble();
                int minutes = scanner.nextInt();
                int data = scanner.nextInt();
                planList.add(new Plan(pricing,minutes,data));
            }
        }
        catch (FileNotFoundException | NullPointerException e)
        {
            System.out.println("Error while reading from file! " + "\n" + e.getMessage());
            return;
        }
        try {
            if(planList.size() == 0) throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Something went wrong, the plan list is empty!");
            return;
        }
    }

    public static String plansToString(ArrayList<Plan> planList) {
        StringBuilder res_str = new StringBuilder();
        for (Plan plan : planList) {
            res_str.append(plan.toString());
            res_str.append("\n");
        }
        return res_str.toString();
    }

    public static String clientsToString(ArrayList<Client> clients) {
        StringBuilder res_str = new StringBuilder();
        for (Client client : clients) {
            res_str.append(client.toString());
            res_str.append("\n");
        }
        return res_str.toString();
    }

    public static String plansWithinParameters(ArrayList<Plan> planList) {
        ArrayList<Plan> res = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your parameters");
        double min_price, max_price;
        int min_minutes, max_minutes, min_data, max_data;
        System.out.println("Please enter your minimum price");
        min_price = Double.parseDouble(sc.next());
        System.out.println("Please enter your maximum price");
        max_price = Double.parseDouble(sc.next());
        System.out.println("Please enter your minimum minutes");
        min_minutes = Integer.parseInt(sc.next());
        System.out.println("Please enter your maximum minutes");
        max_minutes = Integer.parseInt(sc.next());
        System.out.println("Please enter your minimum data");
        min_data = Integer.parseInt(sc.next());
        System.out.println("Please enter your maximum data");
        max_data = Integer.parseInt(sc.next());

        for (Plan plan : planList) {
            if (min_price <= plan.getPricing() && max_price >= plan.getPricing() && min_minutes <= plan.getMinutes() && max_minutes >= plan.getMinutes()
                    && min_data <= plan.getDataTraffic() && max_data >= plan.getDataTraffic()) {
                res.add(plan);
            }
        }

        if (res.size() == 0) {
            return "No plans found!";
        } else {
            return plansToString(res);
        }

    }

    public static int getMaxPlan(ArrayList<Plan> planList) {
        double max = Double.MIN_VALUE;
        int max_index = 0;
        for (Plan plan : planList) {
            if (plan.getPricing() > max) {
                max = plan.getPricing();
                max_index = planList.indexOf(plan);
            }
        }
        return max_index;
    }

    public static ArrayList<Plan> sortPlans(ArrayList<Plan> planList) {
        ArrayList<Plan> buf = new ArrayList<>(planList);
        ArrayList<Plan> sortedList = new ArrayList<>();
        while (buf.size() > 1) {
            sortedList.add(buf.get(getMaxPlan(buf)));
            buf.remove(getMaxPlan(buf));
        }
        sortedList.add(buf.get(0));
        return sortedList;

    }

    public static void serialization()
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat")))
        {
                oos.writeObject(planList);
        }
        catch(IOException ex){

            System.out.println("Error while serializing:" + "\n" + ex.getMessage());
            return;
        }
    }

    public static void deserialization()
    {
        ArrayList<Plan> newPlanList=new ArrayList<Plan>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dat")))
        {
            newPlanList=((ArrayList<Plan>)ois.readObject());
        }
        catch(IOException | ClassNotFoundException ex){

            System.out.println("Error while deserializing:" + "\n" + ex.getMessage());
            return;
        }
        System.out.println("*********************************");
        System.out.println(plansToString(newPlanList));
    }


    public static void main(String[] args) {

        setPlans();
        setClients();
        System.out.println(plansToString(planList));
        System.out.println(clientsToString(clients));
        System.out.println(plansToString(sortPlans(planList)));
        serialization();
        deserialization();


        while (true) {
            System.out.println("Select what you want to do:");
            System.out.println("1. Display amount of clients");
            System.out.println("2. Sort plans by price");
            System.out.println("3. Select a plan by parameters");
            System.out.println("4. Exit");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> System.out.println("Amount of clients: " + clients.size() + "\n");
                case 2 -> System.out.println(plansToString(sortPlans(planList)));
                case 3 -> System.out.println(plansWithinParameters(planList));
                case 4 -> {
                    return;
                }
                default -> System.out.println("You entered wrong option");
            }

        }
    }
}
