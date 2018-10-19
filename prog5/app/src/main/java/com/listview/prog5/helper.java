package com.listview.prog5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class helper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="student.db";
    public static final String TABLE_NAME1="student_table";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="SURNAME";



    public helper(Context context) {
        super(context, DATABASE_NAME, null, 1 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE " + TABLE_NAME1 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, SURNAME TEXT)";
        db.execSQL("create table "+ TABLE_NAME1 +"(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT, SURNAME TEXT)" );
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
    onCreate(db);
    }
public boolean insertData(String id, String name, String surname) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    contentValues.put(COL_1,id);
    contentValues.put(COL_2,name);
    contentValues.put(COL_3,surname);
    long result = db.insert(TABLE_NAME1,null,contentValues);
    if(result == -1)
        return false;
    else
        return true;

    }
   public Cursor getAllData() {
       SQLiteDatabase db = this.getWritableDatabase();
       Cursor res = db.rawQuery("Select * from " + TABLE_NAME1, null);
       return res;
   }
public boolean updateData(String id, String name, String surname){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,id);
    contentValues.put(COL_2,name);
    contentValues.put(COL_3,surname);
    db.update(TABLE_NAME1,contentValues,"ID=?",new String[] {id});
    return true;
}
public Integer deleteData(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return  db.delete(TABLE_NAME1,"ID=?",new String[]{id});
}

}
