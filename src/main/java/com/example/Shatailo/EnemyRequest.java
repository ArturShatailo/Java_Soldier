package com.example.Shatailo;
import java.util.ArrayList;

public class EnemyRequest {

    public static int machinesEnemy;
    public static int soldiersEnemy;
    public static ArrayList <EnemySoldier> soldiersListEnemy  = new ArrayList<>();
    public static ArrayList <EnemyMachine> machinesListEnemy  = new ArrayList<>();


    //method creates soldiers and machines by random in amount of a little more that user requested for itself
    public static void createEnemy() {

        //Creates Enemy Soldiers and Machines (random process)
        machinesEnemy = Tech.getRandom(Request.machines, (Request.machines+1)-1);
        soldiersEnemy = Tech.getRandom(Request.soldiers, (Request.soldiers+1)-1);
        String[] namesEnemy = {"Jack", "Hugh", "Antonio", "Jane"};
        String[] machinesTypeEnemy = {"Tank Abrams", "Helicopter Apache", "AW Stryker", "(SAM) system Patriot"};

        for (int i = 0; i < soldiersEnemy; i++) {
            String soldierName = namesEnemy[Tech.getRandom(0, (namesEnemy.length) - 1)];
            EnemySoldier.CreateEnemySoldier(soldierName, soldiersListEnemy);
        }

        for (int i = 0; i < machinesEnemy; i++) {
            String machineType = machinesTypeEnemy[Tech.getRandom(0, (machinesTypeEnemy.length) - 1)];
            EnemyMachine.CreateEnemyMachine(machineType, machinesListEnemy);
        }
    }

}
