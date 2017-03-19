package com.example.kamuela94.fhirry_adventure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.example.kamuela94.fhirry_adventure.DBFunctions.DatabaseFunctions;
import com.j256.ormlite.field.types.DateTimeType;

import java.util.GregorianCalendar;

import static java.lang.Integer.parseInt;

/**
 * Created by kamuela94 on 3/18/17.
 */

public class NewDrug extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_drug);

    }

    public void send(View v){
 /*       DateTimeType x;
        String name = ((EditText)findViewById(R.id.drugEditText)).getText().toString();
        GregorianCalendar interval = new GregorianCalendar();
        interval.set(interval.HOUR_OF_DAY, interval.HOUR_OF_DAY + parseInt(((EditText)findViewById(R.id.intervalEditText)).getText().toString()));

        DatabaseFunctions.insert(this, name, x, interval);*/


    }
}
