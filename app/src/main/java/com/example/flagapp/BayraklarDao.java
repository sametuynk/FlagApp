package com.example.flagapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Currency;

public class BayraklarDao {


    public ArrayList<Bayraklar>rastgele5Getir(Database vt){
        ArrayList<Bayraklar>bayraklarArrayList=new ArrayList<>();
        SQLiteDatabase db=vt.getWritableDatabase();
        Cursor c =db.rawQuery("SELECT * FROM bayraklar ORDER BY RANDOM() LIMIT 5",null);

        while (c.moveToNext()){
            Bayraklar b = new Bayraklar(c.getInt(c.getColumnIndex("bayrak_id"))
                    , c.getString(c.getColumnIndex("bayrak_ad"))
                    , c.getString(c.getColumnIndex("bayrak_resim")));

            bayraklarArrayList.add(b);
        }
        return bayraklarArrayList;
    }

    public ArrayList<Bayraklar>rastgele3YanlisSecenekGetir(Database vt,int bayrak_id){
        ArrayList<Bayraklar>bayraklarArrayList=new ArrayList<>();
        SQLiteDatabase db=vt.getWritableDatabase();
        Cursor c =db.rawQuery("SELECT * FROM bayraklar WHERE bayrak_id !="+bayrak_id+" ORDER BY RANDOM() LIMIT 5",null);

        while (c.moveToNext()){
            Bayraklar b = new Bayraklar(c.getInt(c.getColumnIndex("bayrak_id"))
                    , c.getString(c.getColumnIndex("bayrak_ad"))
                    , c.getString(c.getColumnIndex("bayrak_resim")));

            bayraklarArrayList.add(b);
        }
        return bayraklarArrayList;
    }

}
