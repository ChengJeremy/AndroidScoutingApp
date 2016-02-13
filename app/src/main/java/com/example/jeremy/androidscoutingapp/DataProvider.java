package com.example.jeremy.androidscoutingapp;

/**
 * Created by jerem on 1/13/2016.
 */
public class DataProvider {

    //purpose of this class is to PROVIDE each row of data in the form of an OBJECT.
    private String name;
    private String description;

    public DataProvider(String name, String description)
    {
        //this is used to reference THIS CLASS'S (or whichever it refereces to) INSTANCES AND VARIABLES.
        this.name = name;
        this.description = description;

        //tip: press alt + insert to insert setter and getter methods and others...

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
