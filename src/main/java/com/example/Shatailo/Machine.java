package com.example.Shatailo;

public class Machine {

    public String type;

    public Machine(String type){

        this.type = type;
    }

    @Override
    public String toString(){
        return type;
    }
}
