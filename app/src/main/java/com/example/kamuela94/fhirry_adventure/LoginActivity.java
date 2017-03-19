package com.example.kamuela94.fhirry_adventure;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.database.Cursor;

import android.util.Log;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kamuela94.fhirry_adventure.DBFunctions.DatabaseCreate;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * A login screen for login by PIN.
 */
public class LoginActivity extends AppCompatActivity {
    private int counter = 0;
    private int[] password = new int[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.

    }

    public void hitButton(View v){
        password[counter] = (parseInt((String) v.getTag()) - 1);
        switch(counter){
            case 0:
                findViewById(R.id.pinView1).setBackground(getResources().getDrawable(R.drawable.pincode_entered));
                break;
            case 1:
                findViewById(R.id.pinView2).setBackground(getResources().getDrawable(R.drawable.pincode_entered));
                break;
            case 2:
                findViewById(R.id.pinView3).setBackground(getResources().getDrawable(R.drawable.pincode_entered));
                break;
            case 3:
                findViewById(R.id.pinView4).setBackground(getResources().getDrawable(R.drawable.pincode_entered));
                break;
        }
        if(counter == 3){
            Intent drugMaker = new Intent(getApplicationContext(), DrugMaker.class);
            startActivity(drugMaker);
        }
        counter++;
    }

}

