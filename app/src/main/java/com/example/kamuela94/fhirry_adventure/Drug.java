package com.example.kamuela94.fhirry_adventure;

import java.util.GregorianCalendar;
import java.util.UUID;

/**
 * Created by racosta on 3/18/17.
 */

public class Drug {

    private UUID mUUID;
    private String mDrugName;
    private GregorianCalendar mTimeStarted;
    private GregorianCalendar mTimeRepeatInterval;


    public UUID getUUID() {
        return mUUID;
    }

    public void setUUID() {
        mUUID = UUID.randomUUID();
    }

    public GregorianCalendar getTimeRepeatInterval() {
        return mTimeRepeatInterval;
    }

    public void setTimeRepeatInterval(GregorianCalendar timeRepeatInterval) {
        mTimeRepeatInterval = timeRepeatInterval;
    }

    public GregorianCalendar getTimeStarted() {

        return mTimeStarted;
    }

    public void setTimeStarted(GregorianCalendar timeStarted) {
        mTimeStarted = timeStarted;
    }

    public String getDrugName() {

        return mDrugName;
    }

    public void setDrugName(String drugName) {
        mDrugName = drugName;
    }
}
