package com.example.wujing.warframe_dps_sim.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Wujing on 2017/4/12.
 */

public class WeaponBaseHelper extends SQLiteOpenHelper{
    private static final int VERSION=1;
    private static final String DATABASE_NAME="weaponbase.db";
    public WeaponBaseHelper(Context context)
    {
        super(context,DATABASE_NAME,null,VERSION) ;
    }
    @Override
    public void onCreate(SQLiteDatabase db){}
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){}
}
