package com.example.Shatailo;

import java.util.List;

public class EnemyMachine extends MilitaryForce{

    public EnemyMachine(String name, int power, int armor) {
        super(power, armor, name);
    }

    @Override
    public String toString(){
        return "name: "+name+" (power: "+ getPower() +", armor: "+ getArmor() +")\n";
    }

    //creates EnemyMachine Objects and adds it to the List machinesListEnemy
    public static void CreateEnemyMachine(String machineName, List machinesListEnemy){
        EnemyMachine es1 = new EnemyMachine(machineName, 1000, 500);
        Tech.addToList(es1, machinesListEnemy);
    }

}
