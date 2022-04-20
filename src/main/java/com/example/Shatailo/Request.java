package com.example.Shatailo;
import java.util.ArrayList;
import java.util.List;

//Class that is used to collect data from user and use them to created new objects "Soldier" and "Machine"
public class Request {

    //static variables will be used during the whole class
    public static int machines;
    public static int soldiers;

    //create 2 Lists for collecting created Objects Soldier and Machine
    public static ArrayList<Soldier> soldiersList = new ArrayList<>();
    public static ArrayList <Machine> machinesList = new ArrayList<>();

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


        // Get input from user about requested machines
        System.out.print("How many war machines do you need (number)?\n");
        machines = Tech.GetInputFunction();

        // Get input from user about requested soldiers
        System.out.print("How many soldiers do you need (number)?\n");
        soldiers = Tech.GetInputFunction();

        //The answer with the followed data about SOLDIERS
        System.out.print("\nWe will send for you " + soldiers + " soldiers:\n\n");


        //cycle that helps generate several objects Soldier automatically by calling function getRandom (for randomisation)
        //and CreateSoldier (for soldiers production). Using array length doesn't allow calling for non-existent array element
        for (int i = 0; i < soldiers; i++) {
            String soldierWeapon = weapons[Tech.getRandom(0, (weapons.length)-1)];
            String soldierName = names[Tech.getRandom(0, (names.length)-1)];
            int soldierAge = ages[Tech.getRandom(0, (ages.length)-1)];
            System.out.println(i+1+") "+Soldier.CreateSoldier(soldierName, soldierAge, "trooper", soldierWeapon, "soldier", soldiersList));
        }

        //The answer with the followed data about MACHINES
        System.out.print("\nWe will send for you " + machines + " machines:\n\n");

        //the same cycle as for Soldier, but with less parameters for production.
        for (int i = 0; i < machines; i++) {
            String machineType = machinesType[Tech.getRandom(0, (machinesType.length)-1)];
            System.out.println(i+1+") "+Machine.CreateMachine(machineType, machinesList));
        }

        //call the method that opens a menu for further actions
        startMenu(soldiersList, machinesList);

    }

//Functions



    //method for menu call with variation of further actions
    public static void startMenu(List soldiersList, List machinesList){
        System.out.print("\nDo you wish to change something? Press on keyboard:\n'0' to start Fight" +
                "\n'1' to create own Machine\n'2' to create own Soldier\n'3' to show your Request\n'4' to change Soldier's parameters\n'5' to Exit\n");
        setDecision(Tech.GetInputFunction(), soldiersList, machinesList);
    }

    //method with SWITCH that allows call different methods according to user's choice. In case of wrong choice the
    //method will be called again with the same options
    public static void setDecision(int answer, List soldiersList, List machinesList){

        switch (answer){
            case 0: StartFight.startFight(); break;
            case 4: Soldier.makeChangesSoldier(soldiersList, machinesList); break;
            case 1: Machine.createCustomMachine(soldiersList, machinesList); break;
            case 2: Soldier.createCustomSoldier(soldiersList, machinesList); break;
            case 3: showRequest(soldiersList, machinesList); break;
            case 5: System.out.println("Thank you,\nBye"); break;
            default: System.out.println("This menu is unavailable. Try again"); setDecision(Tech.GetInputFunction(), soldiersList, machinesList);
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





}