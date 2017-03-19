package com.example.kamuela94.fhirry_adventure;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by racosta on 3/18/17.
 */

public class DrugMaker extends AppCompatActivity {

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

        mTotalList = new ArrayList<>();
        mOverdueDrugs = new ArrayList<>();
        mTakeNowDrugs = new ArrayList<>();
        mUpcomingDrugs = new ArrayList<>();

        Drug overdueHeadr = new Drug();
        overdueHeadr.setDrugName("Overdue");
        overdueHeadr.setTimeStarted(0);
        mOverdueDrugs.add(overdueHeadr);

        Drug takeNowHeader = new Drug();
        takeNowHeader.setDrugName("Take Now");
        takeNowHeader.setTimeStarted(0);
        mTakeNowDrugs.add(takeNowHeader);

        Drug upcomingHeader = new Drug();
        upcomingHeader.setDrugName("Upcoming");
        upcomingHeader.setTimeStarted(0);
        mUpcomingDrugs.add(upcomingHeader);

        //Overdue Drugs Create
        for (int i = 1; i < 6; i++) {
            Drug drug = new Drug();

            drug.setUUID();
            drug.setDrugName(i + " Drug");
            drug.setTimeStarted(10);

            mOverdueDrugs.add(drug);
        }

        //TakeNow Drugs Create
        for (int i = 1; i < 6; i++) {
            Drug drug = new Drug();

            drug.setUUID();
            drug.setDrugName(i + " Drug");
            drug.setTimeStarted(20);

            mTakeNowDrugs.add(drug);
        }

        //Upcoming Create
        for (int i = 1; i < 6; i++) {
            Drug drug = new Drug();

            drug.setUUID();
            drug.setDrugName(i + " Drug");
            drug.setTimeStarted(30);

            mUpcomingDrugs.add(drug);
        }

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
