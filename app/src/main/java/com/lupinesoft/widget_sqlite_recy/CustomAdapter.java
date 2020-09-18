package com.lupinesoft.widget_sqlite_recy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    ArrayList<DBStorage> arrayList;

    CustomAdapter(Context context, ArrayList<DBStorage> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_sample, parent,false);
        }
        TextView tvName = convertView.findViewById(R.id.list_nameID);
        TextView tvCGPA = convertView.findViewById(R.id.list_cgpaID);

        final DBStorage info_storage = arrayList.get(position);
        tvName.setText(info_storage.getName());
        tvCGPA.setText(info_storage.getCgpa());

        return convertView;
    }
}
