package com.example.kamuela94.fhirry_adventure;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;

/**
 * Created by Jason on 3/18/2017.
 */

public class PINCheck {

    private static final String TAG = "Check";
    private String pin;
    Context context;

    PINCheck (String pin, Context context){

        this.pin = pin;
        this.context = context;

    }

    public boolean check() throws IOException {

        byte byteData[] = new byte[0];

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(pin.getBytes());

            byteData = md.digest();
        } catch (Exception e){

        }

        StringBuffer hexString = new StringBuffer();
        for (int i=0;i<byteData.length;i++) {
            String hex = Integer.toHexString(0xff & byteData[i]);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        Log.d(TAG, hexString.toString());

        File file = new File(context.getFilesDir(), "PIN.txt");
                FileInputStream fileInputStream = new FileInputStream(file);
        if(fileInputStream.read() == -1){
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            try {
                bufferedWriter.write(hexString.toString());
            }catch(Exception e){
                e.getStackTrace();
            }
            try {
                bufferedWriter.close();
            }catch(Exception e){
                e.getStackTrace();
            }
        } else {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String read;
            StringBuilder builder = new StringBuilder("");

            read = bufferedReader.readLine();
            while (read != null) {
                builder.append(read);
            }

            String storedHex = builder.toString();
            Log.d(TAG, storedHex);
            Log.d(TAG, hexString.toString());
            if(storedHex.equals(hexString.toString())){

                return true;
            }

            return false;
        }

        return true;
    }
}
