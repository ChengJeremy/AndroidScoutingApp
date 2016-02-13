package com.example.jeremy.androidscoutingapp;

/**
 * Created by Jeremy Cheng.
 */
public class RobotContract {

    //this class will store the robot specific values.
    //contract class will determine the overall structure of your database.
    // so if there are multiple tables, then you need to create seperate classes to
    // pertain with those respective tables.

    public static abstract class NewRobotInfo
    {
        //declarations and placeholders:
        //all-caps seem pretty legit
        public static final String ROBOT_NAME = "robot_name";
        public static final String ROBOT_DESCRIPTION = "robot_description";
        public static final String TABLE_NAME = "robot_info";

    }

}
