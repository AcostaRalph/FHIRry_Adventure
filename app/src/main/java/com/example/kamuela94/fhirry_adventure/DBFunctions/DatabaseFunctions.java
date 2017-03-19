package com.example.kamuela94.fhirry_adventure.DBFunctions;

import android.content.Context;

import java.sql.Time;

/**
 * Created by kamuela94 on 3/18/17.
 */

public class DatabaseFunctions{
    private DatabaseCreate db;

    public void insert(Context context, String name, Time startTime, Time interval){
        if(db == null){
            db = new DatabaseCreate(context);
        }

        try {
            db.getDrugsDao().update(new Drugs(name, startTime, interval));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void remove(Context context, String name, Time startTime, Time interval){
        if(db == null){
            db = new DatabaseCreate(context);
        }

        try {
            db.getDrugsDao().delete(new Drugs(name, startTime, interval));
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
