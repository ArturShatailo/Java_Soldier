package com.example.Shatailo;

import java.util.List;

public class EnemySoldier extends MilitaryForce{
    //public String name;

    public EnemySoldier(String name, int power, int armor) {
        super(power, armor, name);
        //this.name = name;
    }

    @Override
    public String toString(){
        return "name: "+name+" (power: "+ getPower() +", armor: "+ getArmor() +")\n";
    }

    public static void CreateEnemySoldier(String soldierName, List soldiersListEnemy){
        EnemySoldier es1 = new EnemySoldier(soldierName, 100, 100);
        Tech.addToList(es1, soldiersListEnemy);
    }

}
