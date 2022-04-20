package com.example.Shatailo;
import java.util.List;

public class Soldier extends MilitaryForce{

    //public String name;
    public int age;
    public String type;
    public String weapon;
    public String rank;

    public Soldier(String name, int age, String type, String weapon, String rank, int power, int armor) {
        super(power, armor, name);
        //this.name = name;
        this.age = age;
        this.type = type;
        this.weapon = weapon;
        this.rank = rank;
    }

    @Override
    public String toString(){
        return "name: "+name+" (power: "+ getPower() +", armor: "+ getArmor() +")\n age: "+age+"\n type: "+type+"\n weapon: "+weapon+"\n rank: "+rank+"\n";
    }


    //"CreateSoldier" gets random generated "weapon", "name" and "age" of object Soldier of Class Soldier
    // that is generated using constructor.
    public static String CreateSoldier(String soldierName, int soldierAge, String soldierType, String soldierWeapon, String soldierRank, List soldiersList){
        Soldier s1 = new Soldier(soldierName, soldierAge, soldierType, soldierWeapon, soldierRank, 100, 100);
        Tech.addToList(s1, soldiersList); //call method to add new Object to List
        return s1.toString();
    }


    //Method created a new Soldier Object with custom fields and increases the number of Objects in Request
    public static void createCustomSoldier(List soldiersList, List machinesList){
        System.out.println("Set name please:");
        String createName = Tech.GetInputStringFunction();
        System.out.println("Set age please:");
        int createAge = Tech.GetInputFunction();
        System.out.println("Set type please:");
        String createType = Tech.GetInputStringFunction();
        System.out.println("Set weapon please:");
        String createWeapon = Tech.GetInputStringFunction();
        System.out.println("Set rank please:");
        String createRank = Tech.GetInputStringFunction();
        System.out.println("\nYour new soldier is:\n"+CreateSoldier(createName, createAge, createType, createWeapon, createRank, soldiersList));
        Request.soldiers++;
        Request.startMenu(soldiersList, machinesList);
    }



    //Method changes Soldier Object fields.
    //The program asks use to type a new parameters and replace them by calling object's field using get method.
    public static void makeChangesSoldier(List soldiersList, List machinesList){
        System.out.println("Set the index number of a soldier you would like to change:");
        int getIndex = Tech.GetInputFunction();
        System.out.println("The soldier you chose is:\n"+soldiersList.get(getIndex-1)+"\n");
        System.out.println("Set a new name:");
        ((Soldier) soldiersList.get(getIndex-1)).name = Tech.GetInputStringFunction();
        System.out.println("Set a new age:");
        ((Soldier) soldiersList.get(getIndex-1)).age = Tech.GetInputFunction();
        System.out.println("Set a new type:");
        ((Soldier) soldiersList.get(getIndex-1)).type = Tech.GetInputStringFunction();
        System.out.println("Set a new weapon:");
        ((Soldier) soldiersList.get(getIndex-1)).weapon = Tech.GetInputStringFunction();
        System.out.println("Set a new rank:");
        ((Soldier) soldiersList.get(getIndex-1)).rank = Tech.GetInputStringFunction();

        System.out.println("\nAfter your changes:\n"+soldiersList.get(getIndex-1));

        Request.startMenu(soldiersList, machinesList);
    }


}
