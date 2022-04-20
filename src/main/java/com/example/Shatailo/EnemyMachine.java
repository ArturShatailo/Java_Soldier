package com.example.Shatailo;

import java.util.List;

public class EnemyMachine extends MilitaryForce{
    //public String type;

    public EnemyMachine(String name, int power, int armor) {
        super(power, armor, name);
        //this.type = type;
    }

    @Override
    public String toString(){
        return "name: "+name+" (power: "+ getPower() +", armor: "+ getArmor() +")\n";
    }

    public static void CreateEnemyMachine(String machineName, List machinesListEnemy){
        EnemyMachine es1 = new EnemyMachine(machineName, 1000, 500);
        Tech.addToList(es1, machinesListEnemy);
    }

}
