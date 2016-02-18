package com.example.hirshagarwal.traumaapp.obj;

/**
 * Created by Hirsh Agarwal on 2/18/2016.
 */
public class Trauma {

    private int id = 0;
    private String name = "";
    private int organizationId = 0;
    private String location = "";
    private String notes = "";

    //Constructors
    public Trauma(){

    }

    /**
     * Create a full trauma object
     * @param id
     * @param name
     * @param organizationId
     * @param location
     * @param notes
     */
    public Trauma(int id, String name, int organizationId, String location, String notes){
        this.id = id;
        this.name = name;
        this.organizationId = organizationId;
        this.location = location;
        this.notes = notes;
    }

    //Getters
    /**
     * Returns the name of a trauma with a given ID
     * @return
     */
    public String getName(){
        return name;
    }

    public int getOrganizationId(){
        return organizationId;
    }

    public String getLocation(){
        return location;
    }

    public String getNotes(){
        return notes;
    }

    //Setters
    public void setName(String name){
        this.name = name;
    }

    public void setOrganizationId(int organizationId){
        this.organizationId = organizationId;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public void setNotes(String notes){
        this.notes = notes;
    }

}
