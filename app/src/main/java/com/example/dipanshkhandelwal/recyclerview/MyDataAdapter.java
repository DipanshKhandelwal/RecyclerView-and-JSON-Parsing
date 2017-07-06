package com.example.dipanshkhandelwal.recyclerview;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by DIPANSH KHANDELWAL on 29-05-2017.
 */

public class MyDataAdapter extends ArrayAdapter<MyData> {

    public MyDataAdapter(Context context, int resource, List<MyData> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView==null){
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.mydata_layout, parent ,false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.name_p);
        TextView address = (TextView) convertView.findViewById(R.id.address_p);
        TextView phone = (TextView) convertView.findViewById(R.id.phone_p);
        TextView number = (TextView) convertView.findViewById(R.id.number);

        MyData md = getItem(position);

        name.setText(md.getName());
        address.setText(md.getAddress());
        phone.setText(md.getPhoneNumber());
        number.setText(Integer.toString(position));

        return convertView;
    }
}
