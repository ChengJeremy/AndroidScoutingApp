package com.example.jeremy.androidscoutingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jerem on 1/13/2016.
 */
public class ListDataAdapter extends ArrayAdapter{

    List list = new ArrayList();

    public ListDataAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler
    {

        TextView NAME, DESCRIPTION;

    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    //clarify on what exactly these get:
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        LayoutHandler layoutHandler;
        if(row == null)
        {
            //use Layout inflater service:
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout, parent, false);
            layoutHandler = new LayoutHandler();
            //ALWAYS CAST!:
            layoutHandler.NAME = (TextView)row.findViewById(R.id.text_robot_name);
            layoutHandler.DESCRIPTION = (TextView)row.findViewById(R.id.text_robot_description);
            row.setTag(layoutHandler);

        }
        else{
            layoutHandler = (LayoutHandler)row.getTag();
        }
        //set this item into the dataProvider object.
        DataProvider dataProvider = (DataProvider)this.getItem(position);
        layoutHandler.NAME.setText(dataProvider.getName());
        layoutHandler.DESCRIPTION.setText(dataProvider.getDescription());

        return row;
    }
}