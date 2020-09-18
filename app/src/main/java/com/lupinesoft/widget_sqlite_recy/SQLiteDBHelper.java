package com.lupinesoft.widget_sqlite_recy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;

public class SQLiteDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "StudentData";
    private static final int DB_VERSION = 1;
    private static final String DB_TABLE = "StudentResult";
    private static final String NAME = "Name";
    private static final String CGPA = "CGPA";
    private static final String SELECT_TABLE = "SELECT * FROM "+DB_TABLE;

    private Context context;
    public static SQLiteDatabase sqLiteDatabase;

    public SQLiteDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query=String.format("CREATE TABLE "+DB_TABLE+"(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " "+NAME+" VARCHAR(20),"+CGPA+" VARCHAR(10));");
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query=String.format("DELETE TABLE IF EXISTS %s",DB_TABLE);
        db.execSQL(query);
        onCreate(db);
    }

    public long InsertInfo(String name,String cgpa)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(CGPA, cgpa);
        long rowID=sqLiteDatabase.insert(DB_TABLE,null, contentValues);
        return rowID;
    }

    public ArrayList<DBStorage> displayInfo()
    {
        DBStorage info_storage;
        ArrayList<DBStorage> arrayList=new ArrayList<>();
        sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery(SELECT_TABLE,null);
        while(cursor.moveToNext())
        {
            info_storage = new DBStorage();
            info_storage.setName(cursor.getString(cursor.getColumnIndex("Name")));
            info_storage.setCgpa(cursor.getString(cursor.getColumnIndex("CGPA")));
            arrayList.add(info_storage);
        }
        return arrayList;
    }
}
