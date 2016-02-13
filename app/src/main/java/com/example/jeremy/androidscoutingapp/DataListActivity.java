package com.example.jeremy.androidscoutingapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

public class DataListActivity extends AppCompatActivity {
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    RobotDbHelper robotDbHelper;
    Cursor cursor;
    //all default names; declaration is Capitalized, and subject of that declaration is lowercase.
    ListDataAdapter listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_list_layout);
        listView = (ListView)findViewById(R.id.list_view);
        listDataAdapter = new ListDataAdapter(getApplicationContext(), R.layout.row_layout);
        listView.setAdapter(listDataAdapter);
        //clarify on this:
        robotDbHelper = new RobotDbHelper(getApplicationContext());
        sqLiteDatabase = robotDbHelper.getReadableDatabase();
        cursor = robotDbHelper.getInformation(sqLiteDatabase);
        //return true if there is information available; return false if there isn't:
        if(cursor.moveToFirst())
        {
            do{

                String name, description;
                name = cursor.getString(0);
                description = cursor.getString(1);
                DataProvider dataProvider = new DataProvider(name, description);
                listDataAdapter.add(dataProvider);

            }while(cursor.moveToNext());
        }

    }

}
