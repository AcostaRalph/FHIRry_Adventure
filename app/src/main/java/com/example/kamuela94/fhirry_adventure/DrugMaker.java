package com.example.kamuela94.fhirry_adventure;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.example.kamuela94.fhirry_adventure.DBFunctions.DatabaseCreate;
import com.example.kamuela94.fhirry_adventure.DBFunctions.DatabaseFunctions;
import com.example.kamuela94.fhirry_adventure.DBFunctions.Drugs;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.Where;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by racosta on 3/18/17.
 */

public class DrugMaker extends AppCompatActivity {

    private Dao<Drugs, Integer> mdata;
    List<String[]> names;
    List<GregorianCalendar[]> intervals;
    List<Drugs> drugRows;
    private static DrugMaker sDrugMaker;
    private static ArrayList<Drug> mTotalList;
    private static ArrayList<Drug> mOverdueDrugs;
    private static ArrayList<Drug> mTakeNowDrugs;
    private static ArrayList<Drug> mUpcomingDrugs;

    public static DrugMaker get(Context context) {
        if (sDrugMaker == null) {
            sDrugMaker = new DrugMaker(context);
        }
        return sDrugMaker;
    }

    private DrugMaker(Context context) {
        try {
            mdata = new DatabaseCreate(this).getDrugsDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mTotalList = new ArrayList<>();
        mOverdueDrugs = new ArrayList<>();
        mTakeNowDrugs = new ArrayList<>();
        mUpcomingDrugs = new ArrayList<>();

        Drug overdueHeadr = new Drug();
        overdueHeadr.setDrugName("Overdue");
        overdueHeadr.setTimeStarted(new GregorianCalendar());
        mOverdueDrugs.add(overdueHeadr);

        Drug takeNowHeader = new Drug();
        takeNowHeader.setDrugName("Take Now");
        takeNowHeader.setTimeStarted(new GregorianCalendar());
        mTakeNowDrugs.add(takeNowHeader);

        Drug upcomingHeader = new Drug();
        upcomingHeader.setDrugName("Upcoming");
        upcomingHeader.setTimeStarted(new GregorianCalendar());
        mUpcomingDrugs.add(upcomingHeader);

        try {
            drugRows = mdata.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Overdue Drugs Create
        for(Drugs drugObj : drugRows) {
            Drug temp = new Drug();
            GregorianCalendar time = new GregorianCalendar();
            temp.setDrugName(drugObj.name);
            temp.setTimeRepeatInterval(drugObj.interval);
            temp.setTimeStarted(drugObj.startTime);
            if(time.after(drugObj.interval)){
                mOverdueDrugs.add(temp);
            }else if(time.before(drugObj) && (time.HOUR_OF_DAY - drugObj.interval.HOUR_OF_DAY == 0) && (time.MINUTE - drugObj.interval.MINUTE < 10)){
                mTakeNowDrugs.add(temp);
            }else{
                mUpcomingDrugs.add(temp);
            }
        }

        //TakeNow Drugs Create

        //Upcoming Create

        //Copy Overdue List into Total List
        for (int i = 0; i < mOverdueDrugs.size(); i++) {
            mTotalList.add(mOverdueDrugs.get(i));
        }

        //Copy TakeNow List into Total List
        for (int i = 0; i < mOverdueDrugs.size(); i++) {
            mTotalList.add(mTakeNowDrugs.get(i));
        }

        //Copy Upcoming List into Total List
        for (int i = 0; i < mOverdueDrugs.size(); i++) {
            mTotalList.add(mUpcomingDrugs.get(i));
        }
    }

    public ArrayList<Drug> getDrugs(){
        return mTotalList;
    }
}
