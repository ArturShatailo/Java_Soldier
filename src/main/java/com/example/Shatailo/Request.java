package com.example.Shatailo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Class that is used to collect data from user and use them to created new objects "Soldier" and "Machine"
public class Request {

    //static variables will be used during the whole class
    public static int machines;
    public static int soldiers;

    //Actually there is no reason to create an object of class Request because I will use static variables
    /*public Request(int machines, int soldiers){
            this.machines = machines;
            this.soldiers = soldiers;
    }*/

    public static void main(String[] args) {

        //arrays list with data for new Soldiers and Machines creation.
        String [] weapons = {"Assault rifle", "Javelin"};
        String [] names = {"Jack", "Hugh", "Antonio", "Jane", "Mykola"};
        int [] ages = {26, 18, 45, 36, 22};
        String [] machinesType = {"Tank Abrams", "Helicopter Apache", "AW Stryker", "(SAM) system Patriot"};

        //create 2 Lists for collecting created Objects Soldier and Machine
        ArrayList <Soldier> soldiersList = new ArrayList<>();
        ArrayList <Machine> machinesList = new ArrayList<>();

        // Get input from user about requested machines
        System.out.print("How many war machines do you need (number)?\n");
        machines = GetInputFunction();

        // Get input from user about requested soldiers
        System.out.print("How many soldiers do you need (number)?\n");
        soldiers = GetInputFunction();

        //The answer with the followed data about SOLDIERS
        System.out.print("\nWe will send for you " + soldiers + " soldiers:\n\n");


        //cycle that helps generate several objects Soldier automatically by calling function getRandom (for randomisation)
        //and CreateSoldier (for soldiers production). Using array length doesn't allow calling for non-existent array element
        for (int i = 0; i < soldiers; i++) {
            String soldierWeapon = weapons[getRandom(0, (weapons.length)-1)];
            String soldierName = names[getRandom(0, (names.length)-1)];
            int soldierAge = ages[getRandom(0, (ages.length)-1)];
            System.out.println(i+1+") "+CreateSoldier(soldierName, soldierAge, "trooper", soldierWeapon, "soldier", soldiersList));
        }

        //The answer with the followed data about MACHINES
        System.out.print("\nWe will send for you " + machines + " machines:\n\n");

        //the same cycle as for Soldier, but with less parameters for production.
        for (int i = 0; i < machines; i++) {
            String machineType = machinesType[getRandom(0, (machinesType.length)-1)];
            System.out.println(i+1+") "+CreateMachine(machineType, machinesList));
        }

        //call the method that opens a menu for further actions
        startMenu(soldiersList, machinesList);

    }

//Functions


    //"GetInputFunction" is a scanner of input that returns integer number entered by user
     public static int GetInputFunction(){
        Scanner scan = new Scanner(System.in);
        int inputData = scan.nextInt();
        return inputData;
    }

    //"GetInputFunction" is a scanner of input that returns String entered by user
    public static String GetInputStringFunction(){
        Scanner scan = new Scanner(System.in);
        String inputData = scan.nextLine();
        return inputData;
    }

    //"CreateSoldier" gets random generated "weapon", "name" and "age" of object Soldier of Class Soldier
    // that is generated using constructor.
    public static String CreateSoldier(String soldierName, int soldierAge, String soldierType, String soldierWeapon, String soldierRank, List soldiersList){
        Soldier s1 = new Soldier(soldierName, soldierAge, soldierType, soldierWeapon, soldierRank);
        addToList(s1, soldiersList); //call method to add new Object to List
        return s1.toString();
    }

    //"CreateMachine" gets random generated "type" of object Machine of Class Machine
    // that is generated using constructor.
    public static String CreateMachine(String machineType, List machinesList){
        Machine m1 = new Machine(machineType);
        addToList(m1, machinesList);
        return m1.toString();
    }

    //"getRandom" is a generator of random figure with set parameters of minimum and maximum of diapason.
    //The website with examples that I used to create a generator:
    //https://vertex-academy.com/tutorials/ru/generaciya-sluchajnyx-chisel-v-java/
    public static int getRandom(int min, int max){
        int a = min + (int) ( Math.random() * (max+1) );
        return a;
    }



    //////////////////////////////////NEW!!!


    //Method that adds set(specific) Objects into a set(specific) List and returns this completed List back.
    public static List addToList(Object objectName, List listName){
        listName.add(objectName);
        return listName;
    }

    //method for menu call with variation of further actions
    public static void startMenu(List soldiersList, List machinesList){
        System.out.print("\nDo you wish to change something? Press on keyboard:\n'0' to change Soldier's parameters" +
                "\n'1' to create own Machine\n'2' to create own Soldier\n'3' to show your Request\n'4' to Exit\n");
        setDecision(GetInputFunction(), soldiersList, machinesList);
    }

    //method with SWITCH that allows call different methods according to user's choice. In case of wrong choice the
    //method will be called again with the same options
    public static void setDecision(int answer, List soldiersList, List machinesList){

        switch (answer){
            case 0: makeChangesSoldier(soldiersList, machinesList); break;
            case 1: createCustomMachine(soldiersList, machinesList); break;
            case 2: createCustomSoldier(soldiersList, machinesList); break;
            case 3: showRequest(soldiersList, machinesList); break;
            case 4: System.out.println("Thank you,\nBye"); break;
            default: System.out.println("This menu is unavailable. Try again"); setDecision(GetInputFunction(), soldiersList, machinesList);
        }
    }


    //Method is used for calling request (all Soldier and Machine objects).
    //I use forEach to call each object included in ArrayList and then ask to show them one by one using indexOf
    public static void showRequest(List soldiersList, List machinesList){
        System.out.print("\nWe will send for you " + soldiers + " soldiers:\n\n");
        soldiersList.forEach((s) -> System.out.println(soldiersList.indexOf(s)+1+") "+s.toString()));

        System.out.print("\nWe will send for you " + machines + " machines:\n\n");
        machinesList.forEach((m) -> System.out.println(machinesList.indexOf(m)+1+") "+m.toString()));

        startMenu(soldiersList, machinesList);
    }


    //Method changes Soldier Object fields.
    //The program asks use to type a new parameters and replace them by calling object's field using get method.
    public static void makeChangesSoldier(List soldiersList, List machinesList){
        System.out.println("Set the index number of a soldier you would like to change:");
        int getIndex = GetInputFunction();
        System.out.println("The soldier you chose is:\n"+soldiersList.get(getIndex-1)+"\n");
        System.out.println("Set a new name:");
        ((Soldier) soldiersList.get(getIndex-1)).name = GetInputStringFunction();
        System.out.println("Set a new age:");
        ((Soldier) soldiersList.get(getIndex-1)).age = GetInputFunction();
        System.out.println("Set a new type:");
        ((Soldier) soldiersList.get(getIndex-1)).type = GetInputStringFunction();
        System.out.println("Set a new weapon:");
        ((Soldier) soldiersList.get(getIndex-1)).weapon = GetInputStringFunction();
        System.out.println("Set a new rank:");
        ((Soldier) soldiersList.get(getIndex-1)).rank = GetInputStringFunction();

        System.out.println("\nAfter your changes:\n"+soldiersList.get(getIndex-1));

        startMenu(soldiersList, machinesList);
    }


    //Method created a new Soldier Object with custom fields and increases the number of Objects in Request
    public static void createCustomSoldier(List soldiersList, List machinesList){
        System.out.println("Set name please:");
        String createName = GetInputStringFunction();
        System.out.println("Set age please:");
        int createAge = GetInputFunction();
        System.out.println("Set type please:");
        String createType = GetInputStringFunction();
        System.out.println("Set weapon please:");
        String createWeapon = GetInputStringFunction();
        System.out.println("Set rank please:");
        String createRank = GetInputStringFunction();
        System.out.println("\nYour new soldier is:\n"+CreateSoldier(createName, createAge, createType, createWeapon, createRank, soldiersList));
        soldiers++;
        startMenu(soldiersList, machinesList);
    }


    //Method created a new Machine Object with custom fields and increases the number of Objects in Request
    public static void createCustomMachine(List soldiersList, List machinesList){
        System.out.println("Set type please:");
        String createType = GetInputStringFunction();
        System.out.println("\nYour new machine is:\n"+CreateMachine(createType, machinesList));
        machines++;
        startMenu(soldiersList, machinesList);
    }

}