package com.railway_reservation;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int availableTotalBerths=3;
    static int availableLowerBerth=1;
    static int availableMiddleBerth=1;
    static int availableUpperBerth=1;
    static int availableRac=1;
    static int availableWaitingList=1;

    static ArrayList<Passenger> bookedTickets=new ArrayList<>();
    static ArrayList<Passenger> racTickets=new ArrayList<>();
    static ArrayList<Passenger> waitingTickets=new ArrayList<>();

    public static void bookTickets(Scanner scanner)
    {
        if(availableWaitingList==0){
            System.out.println("No tickets available");
            return;
        }

        System.out.println("Enter the passenger name");
        String name=scanner.nextLine();
        System.out.println("Enter the age");
        int age=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your gender");
        String gender=scanner.nextLine();
        System.out.println("Enter your berth preference");
        String berth_preference=scanner.nextLine().toLowerCase();

        if(age<5){
            System.out.println("Sorry,we cannot allocate tickets for children allow age 5");
            return;
        }

        if(berth_preference.equals("lower")){
            if(availableLowerBerth>0){
                  Passenger passenger=new Passenger(name,age,gender,berth_preference);
                  availableLowerBerth--;
                  availableTotalBerths--;
                  bookedTickets.add(passenger);
                  System.out.println("Tickets booked successfully!!!!");
            }
            else{
                System.out.println("You cannot get lower berth,other options are");
                otherAvailableOptions(name,age,gender,scanner);
            }
        }

        else if(berth_preference.equals("middle")){
            if(availableMiddleBerth>0){
                Passenger passenger=new Passenger(name,age,gender,berth_preference);
                availableMiddleBerth--;
                availableTotalBerths--;
                bookedTickets.add(passenger);
                System.out.println("Tickets booked successfully!!!!");
            }
            else{
                System.out.println("You cannot get middle berth,other options are");
                otherAvailableOptions(name,age,gender,scanner);
            }
        }

        else if(berth_preference.equals("upper")){
            if(availableUpperBerth>0){
                Passenger passenger=new Passenger(name,age,gender,berth_preference);
                availableUpperBerth--;
                availableTotalBerths--;
                bookedTickets.add(passenger);
                System.out.println("Tickets booked successfully!!!!");
            }
            else{
                System.out.println("You cannot get upper berth,other options are");
                otherAvailableOptions(name,age,gender,scanner);
            }
        }


    }

    private static void otherAvailableOptions(String name, int age, String gender,Scanner scanner) {
        if(availableLowerBerth>0){
            System.out.println("1.Try Lower");
        }
        if(availableMiddleBerth>0){
            System.out.println("2.Try Middle");
        }
        if(availableUpperBerth>0){
            System.out.println("3.Try Upper");
        }

        if(availableLowerBerth==0 && availableMiddleBerth==0 && availableUpperBerth==0)
        {
            System.out.println("4.Try RAC");
        }


        int choice=scanner.nextInt();

        switch (choice)
        {
            case 1:
                bookedTickets.add(new Passenger(name,age,gender,"lower"));
                System.out.println("Ticket booked successfully");
                availableLowerBerth--;
                availableTotalBerths--;
                break;
            case 2:
                bookedTickets.add(new Passenger(name,age,gender,"middle"));
                System.out.println("Ticket booked successfully");
                availableMiddleBerth--;
                availableTotalBerths--;
                break;
            case 3:
                bookedTickets.add(new Passenger(name,age,gender,"upper"));
                System.out.println("Ticket booked Successfully");
                availableTotalBerths--;
                availableUpperBerth--;
                break;
            case 4:
                if(availableRac>0){
                    racTickets.add(new Passenger(name,age,gender,"rac"));
                    availableRac--;
                    System.out.println("Ticket booked successfully(rac)");
                }
                else{
                    System.out.println("RAC not available,can you book on waiting list,If yes type yes(in small letter) in the console");
                    String ans=scanner.next().toLowerCase();

                    if(ans.equals("yes")){
                        waitingTickets.add(new Passenger(name,age,gender,"waiting"));
                        availableWaitingList--;
                        System.out.println("Ticket booked successfully(in waiting list)");
                    }

                }
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Main main=new Main();
        System.out.println("Welcome to ticket booking application");
        boolean b=true;
        while (b)
        {
            System.out.println("1.Book \n 2.Cancel \n 3.Print booked tickets \n 4.Print available tickets \n 5.exit");
            int choice=scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1:
                    main.bookTickets(scanner);
                    break;
                case 2:
                    main.cancelTickets(scanner);
                    break;
                case 3:
                    main.printBookTickets();
                    break;
                case 4:
                    main.printAvailableTickets();
                    break;
                case 5:
                    System.out.println("you are leaving our application,Thank you");
                    b=false;
                    break;
                default:
                    System.out.println("Your choice is wrong.Please enter a number between 1 to 5");
                    break;
            }
        }
    }

    private void printAvailableTickets() {
        System.out.println("Available Tickets");
        System.out.println("-----------------------");
        System.out.println("Available Tickets: "+availableTotalBerths);
        System.out.println("Available Lower Berth: " + availableLowerBerth);
        System.out.println("Available Middle Berth: " + availableMiddleBerth);
        System.out.println("Available Upper Berth: " + availableUpperBerth);
        System.out.println("Available Rac Tickets: "+availableRac);
        System.out.println("Available Waiting list Tickets: "+availableWaitingList);

        System.out.println("--------------------------------------");
        System.out.println("Total Available Tickets:  "+(availableTotalBerths+availableRac+availableWaitingList));
    }

    private void printBookTickets() {
        if(bookedTickets.isEmpty()){
            System.out.println("No booked tickets available");
        }
        else{
            System.out.println("Booked Tickets");
            System.out.println("----------------");

            for(int i=0;i<bookedTickets.size();i++)
            {
                Passenger passenger=bookedTickets.get(i);
                System.out.println((i+1)+". Name: "+passenger.name+" \n Age: "+passenger.age+" \n Gender: "+passenger.gender+" \n Berth preference: "+passenger.berth_prefernce);
            }

            System.out.println("-------------------");

            System.out.println("RAC Tickets");
            System.out.println("----------------");

            for(int i=0;i<racTickets.size();i++)
            {
                Passenger passenger=racTickets.get(i);
                System.out.println((i+1)+". Name: "+passenger.name+" \n Age: "+passenger.age+" \n Gender: "+passenger.gender+" \n Berth preference: "+passenger.berth_prefernce);
            }

            System.out.println("-------------------");

            System.out.println("Waiting List Tickets");
            System.out.println("----------------");

            for(int i=0;i<waitingTickets.size();i++)
            {
                Passenger passenger=waitingTickets.get(i);
                System.out.println((i+1)+". Name: "+passenger.name+" \n Age: "+passenger.age+" \n Gender: "+passenger.gender+" \n Berth preference: "+passenger.berth_prefernce);
            }

            System.out.println("-------------------");


            System.out.println("Total booked Tickets:  "+bookedTickets.size());
            System.out.println("Total booked rac tickets: "+racTickets.size());
            System.out.println("Total waiting list tickets: "+waitingTickets.size());

        }
    }

    private void cancelTickets(Scanner scanner) {

        System.out.println("Enter your name to cancel the ticket");
        String deleteName=scanner.nextLine();

        Passenger delete=null;
        for(Passenger passenger:bookedTickets){
            if(passenger.name.equalsIgnoreCase(deleteName)){
                delete=passenger;
                break;
            }
        }
        if(delete==null){
            System.out.println("Your name is not found");
            return;
        }

        bookedTickets.remove(delete);
        availableTotalBerths++;
        if(delete.berth_prefernce.equalsIgnoreCase("lower")){
            availableLowerBerth++;
        }
        else if(delete.berth_prefernce.equalsIgnoreCase("middle")){
            availableMiddleBerth++;
        }
        else if(delete.berth_prefernce.equalsIgnoreCase("upper")){
            availableUpperBerth++;
        }


        if(!racTickets.isEmpty()){
            Passenger passenger=racTickets.remove(0);
            availableRac++;
            bookedTickets.add(new Passenger(passenger.name,passenger.age,passenger.gender,delete.berth_prefernce));
            availableTotalBerths--;
            System.out.println("Tickets cancelled successfully for "+delete.name);
        }
        else {
            System.out.println("Tickets cancelled successfully for "+delete.name);
        }

        if(!waitingTickets.isEmpty()){
            Passenger passenger=waitingTickets.remove(0);
            availableWaitingList++;
            racTickets.add(new Passenger(passenger.name,passenger.age,passenger.gender,"rac"));
            System.out.println("Waiting list moved to rac");
            availableRac--;
        }
    }

}
