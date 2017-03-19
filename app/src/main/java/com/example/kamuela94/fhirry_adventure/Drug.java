package com.example.kamuela94.fhirry_adventure;

import java.util.UUID;

/**
 * Created by racosta on 3/18/17.
 */

public class Drug {

    private UUID mUUID;
    private String mDrugName;
    private int mTimeStarted;
    private int mTimeRepeatInterval;


    public UUID getUUID() {
        return mUUID;
    }

    public void setUUID() {
        mUUID = UUID.randomUUID();
    }

    public int getTimeRepeatInterval() {
        return mTimeRepeatInterval;
    }

    public void setTimeRepeatInterval(int timeRepeatInterval) {
        mTimeRepeatInterval = timeRepeatInterval;
    }

    public int getTimeStarted() {

        return mTimeStarted;
    }

    public void setTimeStarted(int timeStarted) {
        mTimeStarted = timeStarted;
    }

    public String getDrugName() {

        return mDrugName;
    }

    public void setDrugName(String drugName) {
        mDrugName = drugName;
    }
}
