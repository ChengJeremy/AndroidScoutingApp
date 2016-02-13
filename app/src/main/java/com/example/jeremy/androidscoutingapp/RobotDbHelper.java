package com.example.jeremy.androidscoutingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Jeremy Cheng.
 */
public class RobotDbHelper extends SQLiteOpenHelper{

    static String TAG = "RobotDbHelper";
    //system will call onCreate method if the table (database) does not already exist.
    //so call once only.
    //alt-enter just automatically does a lot of things for you.
    //so what is context?

    private static final String DATABASE_NAME = "ROBOTINFO.DB";
    private static final int DATABASE_VERSION = 1;
    //CREATING QUERY::: VERY IMPORTANT!
    //ALSO PUT SPACE AFTER TABLE!!! Pay attention to the spaces. >>>
    private static final String CREATE_QUERY =
    "CREATE TABLE " + RobotContract.NewRobotInfo.TABLE_NAME + "(" + RobotContract.NewRobotInfo.ROBOT_NAME + " TEXT," +
            RobotContract.NewRobotInfo.ROBOT_DESCRIPTION + " TEXT)";

    //BEFORE:::     "CREATE TABLE " + RobotContract.NewRobotInfo.TABLE_NAME + "(" + RobotContract.NewRobotInfo.ROBOT_NAME + " TEXT," +
    //RobotContract.NewRobotInfo.ROBOT_DESCRIPTION + " TEXT," + RobotContract.NewRobotInfo.ROBOT_DESCRIPTION + " TEXT" + ")";

    public RobotDbHelper(Context context)
    {
        //CREATE THE DATABASE:::

        //use these 2 {} whenever you can I suppose
        //clarify this? :::
        //takes in 4 parameters: super(context, dbname, any objects?, dbversion)
        //if there is a change, database will recreate database version
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS", "Database created / opened... ");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //ERROR HERE:
        //Log.e(TAG, "Application is running well, yay!");
        //CREATE THE TABLE:::
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS", "Table created... ");
        //Log is like the System.out.print() in netbeans, except in this case, the real display is
        // on the phone, and not on the

    }

    public void addInformation(String name, String description, SQLiteDatabase db)
    {
        //if you use that ^ you don't need to return after creating method head.
        //clarify on exactly how this works:
        ContentValues contentValues = new ContentValues();
        contentValues.put(RobotContract.NewRobotInfo.ROBOT_NAME, name);
        contentValues.put(RobotContract.NewRobotInfo.ROBOT_DESCRIPTION, description);
        //will not insert new value if last value is null. NO CONTENT VALUES:
        db.insert(RobotContract.NewRobotInfo.TABLE_NAME, null, contentValues);
        Log.e("DATABASE OPERATIONS", "One row inserted... ");

    }

    public Cursor getInformation(SQLiteDatabase db)
    {
        //will get information RETURNED in the form of a cursor object.
        Cursor cursor;
        //now need elements in this Array that are "name, description"
        //name, description
        String[] projections = {RobotContract.NewRobotInfo.ROBOT_NAME, RobotContract.NewRobotInfo.ROBOT_DESCRIPTION};
        //use sqlite class to call its methods:
        //table name (db name), projection (name of columns? ), selection, selection arguments
        //, group rows, filter by row groups, sort order
        //BUT HERE you only need name and (projection) - the column names of the database table; so rest are null values.
        cursor = db.query(RobotContract.NewRobotInfo.TABLE_NAME, projections, null, null, null, null, null);
        return cursor;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
