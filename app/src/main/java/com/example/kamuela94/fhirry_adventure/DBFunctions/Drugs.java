package com.example.kamuela94.fhirry_adventure.DBFunctions;

import com.j256.ormlite.field.DatabaseField;

import java.io.Serializable;
import java.sql.Time;
import java.util.GregorianCalendar;

/**
 * Created by kamuela94 on 3/18/17.
 */

public class Drugs implements Serializable {
    /**
     *  Model class for teacher_details database table
     */
    private static final long serialVersionUID = -222864131214757024L;

    // Primary key defined as an auto generated integer
    // If the database table column name differs than the Model class variable name, the way to map to use columnName
    @DatabaseField(generatedId = true, columnName = "drug_id")
    public int drugId;

    // Define a String type field to hold teacher's name
    @DatabaseField(columnName = "name")
    public String name;

    // Define a String type field to hold student's address
    @DatabaseField(columnName = "start_time")
    public GregorianCalendar startTime;

    @DatabaseField(columnName = "interval")
    public GregorianCalendar interval;

    // Default constructor is needed for the SQLite, so make sure you also have it
    public Drugs(){

    }

    //For our own purpose, so it's easier to create a TeacherDetails object
    public Drugs(final String name, final GregorianCalendar startTime, final GregorianCalendar interval){
        this.name = name;
        this.startTime = startTime;
        this.interval = interval;

    }
}
