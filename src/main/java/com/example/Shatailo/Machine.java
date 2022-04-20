package com.example.Shatailo;
import java.util.List;

public class Machine extends MilitaryForce {

    //public String type;

    public Machine(String name, int power, int armor){
        super(power, armor, name);
        //this.type = type;
    }

    @Override
    public String toString(){
        return name+" (power: "+ getPower() +", armor: "+ getArmor() +")";
    }


    //"CreateMachine" gets random generated "type" of object Machine of Class Machine
    // that is generated using constructor.
    public static String CreateMachine(String machineType, List machinesList){
        Machine m1 = new Machine(machineType, 1000, 500);
        Tech.addToList(m1, machinesList);
        return m1.toString();
    }



    //Method created a new Machine Object with custom fields and increases the number of Objects in Request
    public static void createCustomMachine(List soldiersList, List machinesList){
        System.out.println("Set type please:");
        String createType = Tech.GetInputStringFunction();
        System.out.println("\nYour new machine is:\n"+CreateMachine(createType, machinesList));
        Request.machines++;
        Request.startMenu(soldiersList, machinesList);
    }



}
