package com.example.kamuela94.fhirry_adventure.DBFunctions;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.field.types.DateTimeType;

import java.sql.SQLException;
import java.sql.Time;
import java.util.GregorianCalendar;

/**
 * Created by kamuela94 on 3/18/17.
 */

public class DatabaseFunctions{
    private static DatabaseCreate db;

    public static void insert(Context context, String name, DateTimeType startTime, DateTimeType interval){
        if(db == null){
            db = new DatabaseCreate(context);
        }

        try {
            db.getDrugsDao().update(new Drugs(name, startTime, interval));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void remove(Context context, String name, DateTimeType startTime, DateTimeType interval){
        if(db == null){
            db = new DatabaseCreate(context);
        }

        try {
            db.getDrugsDao().delete(new Drugs(name, startTime, interval));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Dao<Drugs, Integer> getDrugs(){
        try {
            return db.getDrugsDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
