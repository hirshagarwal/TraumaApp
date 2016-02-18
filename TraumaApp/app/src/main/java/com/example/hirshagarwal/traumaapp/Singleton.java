package com.example.hirshagarwal.traumaapp;

import android.util.Pair;

import com.example.hirshagarwal.traumaapp.obj.Patient;

import java.util.ArrayList;

/**
 * Created by Hirsh Agarwal on 2/17/2016.
 */
public class Singleton {

    private static Singleton firstInstance = null;
    private ArrayList<Patient> patients = new ArrayList<Patient>();
    private int currentPatient = 0;

    private Singleton(){}

    public static Singleton getInstance(){
        if(firstInstance == null){
            firstInstance = new Singleton();
        }

        return firstInstance;
    }

    public Patient getPatient(){
        return patients.get(currentPatient);
    }

    public void addPatient(Patient p){
        patients.add(p);
        currentPatient = patients.size()-1;
    }


}
