package com.example.Shatailo;
import java.util.Scanner;

//Class that is used to collect data from user and use them to created new objects "Soldier" and "Machine"
public class Request {

    //static variables will be used during the whole class
    public static int machines;
    public static int soldiers;


    //Actually there is no reason to create an object of class Request because I will use static variables
    public Request(int machines, int soldiers){
            this.machines = machines;
            this.soldiers = soldiers;
    }


    public static void main(String[] args) {

        //arrays list with data for new Soldiers and Machines creation.
        String [] weapons = {"Assault rifle", "Javelin"};
        String [] names = {"Jack", "Hugh", "Antonio", "Jane", "Mykola"};
        int [] ages = {26, 18, 45, 36, 22};
        String [] machinesType = {"Tank Abrams", "helicopter Apache", "AW Stryker", "(SAM) system Patriot"};

        // Get input from user about requested machines
        System.out.print("How many war machines do you need (number)?\n");
        machines = GetInputFunction();

        // Get input from user about requested soldiers
        System.out.print("How many soldiers do you need (number)?");
        soldiers = GetInputFunction();

        //The answer with the followed data about SOLDIERS
        System.out.print("We will send for you " + soldiers + " soldiers:\n");


        //cycle that helps generate several objects Soldier automatically by calling function getRandom (for randomisation)
        //and CreateSoldier (for soldiers production). Using array length doesn't allow calling for non-existent array element
        for (int i = 0; i < soldiers; i++) {
            String soldierWeapon = weapons[getRandom(0, (weapons.length)-1)];
            String soldierName = names[getRandom(0, (names.length)-1)];
            int soldierAge = ages[getRandom(0, (ages.length)-1)];
            System.out.println(CreateSoldier(soldierWeapon, soldierName, soldierAge));
        }

        //The answer with the followed data about MACHINES
        System.out.print("We will send for you " + machines + " machines:\n");

        //the same cycle as for Soldier, but with less parameters for production.
        for (int i = 0; i < machines; i++) {
            String machineType = machinesType[getRandom(0, (machinesType.length)-1)];
            System.out.println(CreateMachine(machineType));
        }
    }

//Functions

    //"GetInputFunction" is a scanner of input that returns integer number entered by user
     public static int GetInputFunction(){
        Scanner scan = new Scanner(System.in);
        int inputData = scan.nextInt();
        return inputData;
    }

    //"CreateSoldier" gets random generated "weapon", "name" and "age" of object Soldier of Class Soldier
    // that is generated using constructor.
    public static String CreateSoldier(String soldierWeapon, String soldierName, int soldierAge){
        Soldier s1 = new Soldier(soldierName, soldierAge, "trooper", soldierWeapon, "soldier");
        return s1.toString();
    }

    //"CreateMachine" gets random generated "type" of object Machine of Class Machine
    // that is generated using constructor.
    public static String CreateMachine(String machineType){
        Machine m1 = new Machine(machineType);
        return m1.toString();
    }

    //"getRandom" is a generator of random figure with set parameters of minimum and maximum of diapason.
    //The website with examples that I used to create a generator:
    //https://vertex-academy.com/tutorials/ru/generaciya-sluchajnyx-chisel-v-java/
    public static int getRandom(int min, int max){
        int a = min + (int) ( Math.random() * (max+1) );
        return a;
    }



}