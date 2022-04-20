package com.example.Shatailo;

public class MilitaryForce {

    public String name;
    private int power;
    private int armor;

    public MilitaryForce(int power, int armor, String name){
        this.power = power;
        this.armor = armor;
        this.name =  name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public static void main(String[] args) {

    }

}
