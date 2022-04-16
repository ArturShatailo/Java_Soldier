package com.example.Shatailo;

public class Soldier {

    public String name;
    public int age;
    public String type;
    public String weapon;
    public String rank;

    public Soldier(String name, int age, String type, String weapon, String rank) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.weapon = weapon;
        this.rank = rank;
    }

    @Override
    public String toString(){
        return "name: "+name+"\n age: "+age+"\n type: "+type+"\n weapon: "+weapon+"\n rank: "+rank+"\n";
    }

}
