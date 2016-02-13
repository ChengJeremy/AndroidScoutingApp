package com.example.jeremy.androidscoutingapp;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Jeremy Cheng.
 */
//extends to inherit parent methods: thus onCreate() inherited;
//just convenient.
//ends up creating imports to app.Activity ^
public class EnterRobot extends Activity{

    static String TAG = "EnterRobot";
    EditText RobotName, RobotDescription;
    //wat >>>
    Context context = this;
    RobotDbHelper robotDbHelper;
    SQLiteDatabase sqLiteDatabase;

    //when you create this automatically, the Bundle is automatically
    //imported as well. ^
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_robot);
        RobotName = (EditText) findViewById(R.id.txtName);
        RobotDescription = (EditText) findViewById(R.id.txtDescription);

    }

    //use logcat for logs and debugging etc.
    //this method automatically invokes itself:
    // (onClick listener implemented within the xml file directly calls this one: )
    public void addRobot(View view)
    {

        String name = RobotName.getText().toString();
        String description = RobotDescription.getText().toString();
        robotDbHelper = new RobotDbHelper(context);
        //THIS ONE:::
        sqLiteDatabase = robotDbHelper.getWritableDatabase();
        //ISOLATE ^^^
        robotDbHelper.addInformation(name, description, sqLiteDatabase);
        Toast.makeText(getBaseContext(), "Data Saved", Toast.LENGTH_LONG).show();
        //   >>>close at end??<<<
        robotDbHelper.close();

    }

}
