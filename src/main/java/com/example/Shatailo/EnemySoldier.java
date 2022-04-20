package com.example.Shatailo;

import java.util.List;

public class EnemySoldier extends MilitaryForce{

    public EnemySoldier(String name, int power, int armor) {
        super(power, armor, name); //extended fields
    }

    @Override
    public String toString(){
        return "name: "+name+" (power: "+ getPower() +", armor: "+ getArmor() +")\n";
    }

    //creates EnemySoldier Objects and adds it to the List soldiersListEnemy
    public static void CreateEnemySoldier(String soldierName, List soldiersListEnemy){
        EnemySoldier es1 = new EnemySoldier(soldierName, 100, 100);
        Tech.addToList(es1, soldiersListEnemy);
    }

}
