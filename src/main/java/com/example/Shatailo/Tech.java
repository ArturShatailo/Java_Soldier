package com.example.Shatailo;

import java.util.List;
import java.util.Scanner;

public class Tech {

    //"GetInputFunction" is a scanner of input that returns integer number entered by user
    public static int GetInputFunction(){
        Scanner scan = new Scanner(System.in);
        int inputData = scan.nextInt();
        return inputData;
    }

    //"GetInputFunction" is a scanner of input that returns String entered by user
    public static String GetInputStringFunction(){
        Scanner scan = new Scanner(System.in);
        String inputData = scan.nextLine();
        return inputData;
    }

    //Method that adds set(specific) Objects into a set(specific) List and returns this completed List back.
    public static List addToList(Object objectName, List listName){
        listName.add(objectName);
        return listName;
    }

    //"getRandom" is a generator of random figure with set parameters of minimum and maximum of diapason.
    //The website with examples that I used to create a generator:
    //https://vertex-academy.com/tutorials/ru/generaciya-sluchajnyx-chisel-v-java/
    public static int getRandom(int min, int max){

        //int random = min + (int) ( Math.random() * (max+1) );
        int random = (int) (Math.random()*(max-min))+min;
        System.out.println("Random: "+ random+" min: "+min+" max: "+max);
        return random;
    }

}
