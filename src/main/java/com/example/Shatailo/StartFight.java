package com.example.Shatailo;

import java.util.ArrayList;

public class StartFight {

    //Arrays of all (Soldiers and Machines) military objects for User and Enemy
    public static ArrayList<Object> User = new ArrayList<>();
    public static ArrayList<Object> Enemy = new ArrayList<>();

    public static void startFight(){

        EnemyRequest.createEnemy(); // call method to create enemy army

        //Objects from Lists soldiersList and machinesList will be inserted in the User List,
        //soldiersListEnemy and machinesListEnemy will be inserted in Enemy List
        Request.soldiersList.forEach((s) -> User.add(s));
        EnemyRequest.soldiersListEnemy.forEach((s) -> Enemy.add(s));
        Request.machinesList.forEach((s) -> User.add(s));
        EnemyRequest.machinesListEnemy.forEach((s) -> Enemy.add(s));

        System.out.println("Enemy soldiers army is: \n");
        EnemyRequest.soldiersListEnemy.forEach((s) -> System.out.print(s.toString()));
        System.out.println("\nEnemy machines army is: \n");
        EnemyRequest.machinesListEnemy.forEach((s) -> System.out.print(s.toString()));
        System.out.println("\nTHE BATTLE BEGINS: \n");
        int switcher = 1; //switcher for changing turn during the fight

        //'while' cycle will be active until Enemy's military objects or User's military objects ended.
        //the program gets random Military Object from List (User and Enemy) and calls method AttackLogic that returns new updated List (User or Enemy)
        //first turn: User beats Enemy, second: Enemy beats User and so on...
        while(User.size() > 0 && Enemy.size() > 0){

            if(switcher == 1) {

                int AttackerID = Tech.getRandom(0, (User.size()-1));
                int DefenderID = Tech.getRandom(0, (Enemy.size()-1));
                System.out.println("Your '" + ((MilitaryForce) User.get(AttackerID)).name + "' beats enemy's '" + ((MilitaryForce) Enemy.get(DefenderID)).name + "' for " + ((MilitaryForce) User.get(AttackerID)).getPower() + " damage.\n" + "Press 'Enter' for next turn");
                Enemy = AttackLogic(AttackerID, DefenderID, User, Enemy);
                Tech.GetInputStringFunction();
               switcher=0;
           }else{

                int AttackerID = Tech.getRandom(0, (Enemy.size()-1));
                int DefenderID = Tech.getRandom(0, (User.size()-1));
                System.out.println("Enemy's '" + ((MilitaryForce) Enemy.get(AttackerID)).name + "' beats your '" + ((MilitaryForce) User.get(DefenderID)).name + "' for " + ((MilitaryForce) Enemy.get(AttackerID)).getPower() + " damage.\n" + "Press 'Enter' for next turn");
                User = AttackLogic(AttackerID, DefenderID, Enemy, User);
                Tech.GetInputStringFunction();
               switcher=1;
           }
        }
        String winner = (User.size() > 0) ? "You win! Glory to Ukraine!" : "Enemy win, but this is only one battle, not war!";
        System.out.println(winner);
    }

    //Method gets ID of Military Object that will attack, ID of Military Object that will be attacked (Defender),
    // List of all Military Objects from Lists (User and Enemy).
    //Method finds 'power' field of attacker Object and 'armor' of defender Object and created fighting:
    //fighting is deduction attacker's 'power' from defender's 'armor' and then delete (if power more or equal than armor)
    //or change 'armor' field (if armor more that power). Returns updated List of defender (User or Enemy)
    public static ArrayList AttackLogic(int AttackerID, int DefenderID, ArrayList Attacker, ArrayList Defender){

        Object AttackerUnit = Attacker.get(AttackerID);
        Object DefenderUnit = Defender.get(DefenderID);
        int attackValue = ((MilitaryForce) AttackerUnit).getPower(); //AttackerUnit adjusted to MilitaryForce Object
        int defenceValue = ((MilitaryForce) DefenderUnit).getArmor(); //DefenderUnit adjusted to MilitaryForce Object

        int unitsFight = defenceValue - attackValue;
        if(unitsFight<=0){
            Defender.remove(DefenderID);
        }else{
            ((MilitaryForce) Defender.get(DefenderID)).setArmor(unitsFight);
        }

        return Defender;

    }

}
