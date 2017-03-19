package com.example.kamuela94.fhirry_adventure;

import com.j256.ormlite.field.types.DateTimeType;

import java.util.GregorianCalendar;
import java.util.UUID;

/**
 * Created by racosta on 3/18/17.
 */

public class Drug {

    private UUID mUUID;
    private String mDrugName;
    private String mTimeStarted;
    private String mTimeRepeatInterval;


    public UUID getUUID() {
        return mUUID;
    }

    public void setUUID() {
        mUUID = UUID.randomUUID();
    }

    public String getTimeRepeatInterval() {
        return mTimeRepeatInterval;
    }

    public void setTimeRepeatInterval(String timeRepeatInterval) {
        mTimeRepeatInterval = timeRepeatInterval;
    }

    public String getTimeStarted() {

        return mTimeStarted;
    }

    public void setTimeStarted(String timeStarted) {
        mTimeStarted = timeStarted;
    }

    public String getDrugName() {

        return mDrugName;
    }

    public void setDrugName(String drugName) {
        mDrugName = drugName;
    }
}
