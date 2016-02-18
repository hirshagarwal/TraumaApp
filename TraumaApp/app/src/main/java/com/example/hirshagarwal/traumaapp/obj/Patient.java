package com.example.hirshagarwal.traumaapp.obj;

/**
 * Created by Hirsh Agarwal on 2/17/2016.
 */
public class Patient {

    private String name = "";
    private int id = 0;
    private int gcs = -1;
    private int priority = -1;
    private int gender = 0;
    private String responder = null;

    public Patient(){
        System.out.println("New Patient Added");
    }

    public Patient(String name){
        this.name = name;
    }


    //Setters
    public void setGCS(int score){
        gcs = score;
    }

    public void setPriority(int score){
        priority = score;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setGender(int gender){
        this.gender = gender;
    }

    //Getters
    public int getId(){
        return id;
    }

    public int getGCS(){
        return gcs;
    }

    public String getName(){
        return name;
    }

    public int getGender(){
        return gender;
    }

    public int getPriority(){
        return priority;
    }






}
