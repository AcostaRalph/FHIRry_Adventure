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
    Drug drug;
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
  /*      try {
            mdata = new DatabaseCreate(this).getDrugsDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        mTotalList = new ArrayList<>();
        mOverdueDrugs = new ArrayList<>();
        mTakeNowDrugs = new ArrayList<>();
        mUpcomingDrugs = new ArrayList<>();

        Drug overdueHeadr = new Drug();
        overdueHeadr.setDrugName("Overdue");
        overdueHeadr.setTimeStarted("");
        mOverdueDrugs.add(overdueHeadr);

        Drug takeNowHeader = new Drug();
        takeNowHeader.setDrugName("Take Now");
        takeNowHeader.setTimeStarted("");
        mTakeNowDrugs.add(takeNowHeader);

        Drug upcomingHeader = new Drug();
        upcomingHeader.setDrugName("Upcoming");
        upcomingHeader.setTimeStarted("");
        mUpcomingDrugs.add(upcomingHeader);

/*        try {
            drugRows = mdata.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        //Overdue Drugs Create
        drug = new Drug();

        drug.setUUID();
        drug.setDrugName("1." + " Xanax");
        drug.setTimeStarted("10 minutes over");
        mOverdueDrugs.add(drug);

        drug = new Drug();

        drug.setUUID();
        drug.setDrugName("2." + " Vicodin");
        drug.setTimeStarted("30 minutes over");
        mOverdueDrugs.add(drug);

        drug = new Drug();

        drug.setUUID();
        drug.setDrugName("3." + " Oxycodone");
        drug.setTimeStarted("1 hour over");
        mOverdueDrugs.add(drug);


        //TakeNow Drugs Create
            drug = new Drug();

            drug.setUUID();
            drug.setDrugName("1." + " Insulin");
            drug.setTimeStarted("TAKE NOW");
            mTakeNowDrugs.add(drug);

            drug = new Drug();

            drug.setUUID();
            drug.setDrugName("2." + " Ibuprofen");
            drug.setTimeStarted("TAKE NOW");
            mTakeNowDrugs.add(drug);


        //Upcoming Create
            Drug drug = new Drug();

            drug.setUUID();
            drug.setDrugName("1." + " Acetaminophen");
            drug.setTimeStarted("15 minutes");

            mUpcomingDrugs.add(drug);

            drug = new Drug();

            drug.setUUID();
            drug.setDrugName("2." + " Warfarin");
            drug.setTimeStarted("45 minutes");

            mUpcomingDrugs.add(drug);

        //Copy Overdue List into Total List
        for (int i = 0; i < mOverdueDrugs.size(); i++) {
            mTotalList.add(mOverdueDrugs.get(i));
        }

        //Copy TakeNow List into Total List
        for (int i = 0; i < mTakeNowDrugs.size(); i++) {
            mTotalList.add(mTakeNowDrugs.get(i));
        }

        //Copy Upcoming List into Total List
        for (int i = 0; i < mUpcomingDrugs.size(); i++) {
            mTotalList.add(mUpcomingDrugs.get(i));
        }
    }

    public ArrayList<Drug> getDrugs(){
        return mTotalList;
    }
}
