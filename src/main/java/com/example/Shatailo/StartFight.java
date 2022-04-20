package com.example.Shatailo;

import java.util.ArrayList;
import java.util.List;

public class StartFight {

    public static ArrayList<Object> User = new ArrayList<>();
    public static ArrayList<Object> Enemy = new ArrayList<>();

    public static void startFight(){

        EnemyRequest.createEnemy();

        Request.soldiersList.forEach((s) -> User.add(s));
        EnemyRequest.soldiersListEnemy.forEach((s) -> Enemy.add(s));
        Request.machinesList.forEach((s) -> User.add(s));
        EnemyRequest.machinesListEnemy.forEach((s) -> Enemy.add(s));

        int switcher = 1;
        while(User.size() > 0 && Enemy.size() > 0){

            if(switcher == 1) {

                int AttackerID = Tech.getRandom(0, (User.size()-1));
                int DefenderID = Tech.getRandom(0, (Enemy.size()-1));
                System.out.println("Your " + ((MilitaryForce) User.get(AttackerID)).name + " beats enemy's " + ((MilitaryForce) Enemy.get(DefenderID)).name + " for " + ((MilitaryForce) User.get(AttackerID)).getPower() + " damage.\n" + "Press 'Enter' for next turn");
                Enemy = AttackLogic(AttackerID, DefenderID, User, Enemy);
                Tech.GetInputStringFunction();
               switcher=0;
           }else{

                int AttackerID = Tech.getRandom(0, (Enemy.size()-1));
                int DefenderID = Tech.getRandom(0, (User.size()-1));
                System.out.println("Enemy's " + ((MilitaryForce) Enemy.get(AttackerID)).name + " beats your " + ((MilitaryForce) User.get(DefenderID)).name + " for " + ((MilitaryForce) Enemy.get(AttackerID)).getPower() + " damage.\n" + "Press 'Enter' for next turn");
                User = AttackLogic(AttackerID, DefenderID, Enemy, User);
                Tech.GetInputStringFunction();
               switcher=1;
           }
        }
        String winner = (User.size() > 0) ? "You win! Glory to Ukraine!" : "Enemy win, but this is only one battle, not war!";
        System.out.println(winner);
    }


    public static ArrayList AttackLogic(int AttackerID, int DefenderID, ArrayList Attacker, ArrayList Defender){

        Object AttackerUnit = Attacker.get(AttackerID);
        Object DefenderUnit = Defender.get(DefenderID);
        int attackValue = ((MilitaryForce) AttackerUnit).getPower();
        int defenceValue = ((MilitaryForce) DefenderUnit).getArmor();

        int unitsFight = defenceValue - attackValue;
        if(unitsFight<=0){
            Defender.remove(DefenderID);
        }else{
            ((MilitaryForce) Defender.get(DefenderID)).setArmor(unitsFight);
        }

        return Defender;

    }

}
