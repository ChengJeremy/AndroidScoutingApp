package com.example.jeremy.androidscoutingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class AndroidScoutingApp extends Activity {
    static String TAG = "AndroidScoutingApp";
    //TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_scouting_app);

        Log.i(TAG, "Application is running, yay!");
        //textView = (TextView)findViewById(R.id.txtrobotInfo);

        //clicked();
            //inside the () is the view; Can declare
            // View v, but can also just declare within parenthesis
            //impromptu.
            //private EditText enterRobotInfo = (EditText)(findViewById(R.id.txtenterRobotInfo));
            //consider using btn and txt again; they are GOOD representations
            // of these objects; helps you tell them apart etc.
    }

    //view is an object of the View class
    public void clicked(View view)
    {
        //this method is more organized; {} going on separate lines seems more
        // organized and aesthetically pleasing.

        /*Button button = (Button) view;
        ((Button) view).setText("clicked");
        */

        String button_text;
        button_text = ((Button) view).getText().toString();
        if(button_text.equals("Enter Robot"))
        {
            Intent intent = new Intent(this, EnterRobot.class);
                startActivity(intent);
        }
        else if(button_text.equals("View Robot"))
        {
            //this, and the class that you INTENT to use for this function.
            Intent intent = new Intent(this, DataListActivity.class);
            startActivity(intent);
        }
    }

}
