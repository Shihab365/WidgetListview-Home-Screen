package com.lupinesoft.widget_sqlite_recy;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fav;
    ListView listView;
    CustomAdapter customAdapter;

    SQLiteDBHelper sqLiteDBHelper;
    ArrayList<DBStorage> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fav = findViewById(R.id.fab_id);
        listView = findViewById(R.id.listview_id);

        sqLiteDBHelper = new SQLiteDBHelper(this);
        arrayList = new ArrayList<>();

        arrayList = sqLiteDBHelper.displayInfo();
        customAdapter = new CustomAdapter(this, arrayList);
        listView.setAdapter(customAdapter);

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CreateActivity.class));
            }
        });
    }
}
