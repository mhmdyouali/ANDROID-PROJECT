package com.example.ieeetask2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class myDatabase extends SQLiteOpenHelper {

    public static final String DB_NAME = "users";
    public static final String USER_ID = "id";
    public static final String USER_NAME = "name";
    public static final String USER_EMAIL = "email";
    public static final String USER_PHONE = "phone";
    public static final String USER_PASS = "password";


    myDatabase (Context c)
    {
        super(c ,"users_data" ,null ,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+DB_NAME+" ("+USER_ID+" integer primary key autoincrement ," + " "+USER_NAME+" text not null , " +
                "" + ""+USER_EMAIL+" text not null unique,"+""+USER_PHONE+" text unique," + ""+USER_PASS+" text not null )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+DB_NAME);
        sqLiteDatabase.execSQL("create table "+DB_NAME+" ("+USER_ID+" integer primary key autoincrement ," + " "+USER_NAME+" text not null ," +
                " " + ""+USER_EMAIL+" text not null unique,"+""+USER_PHONE+" text unique," + ""+USER_PASS+" text not null )");
    }

    public boolean insert_user (user1 user)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues ();

        values.put(USER_NAME , user.getName());
        values.put(USER_EMAIL , user.getEmail());
        values.put(USER_PHONE ,user.getPhone());
        values.put(USER_PASS , user.getPass());

        // insert method return -1 if it no added and positive number if added

     long result = db.insert(DB_NAME ,null , values);

      return (result != -1) ;
    }

    public boolean update_user (user1 user)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues ();

        values.put(USER_NAME , user.getName());
        values.put(USER_EMAIL , user.getEmail());
        values.put(USER_PASS , user.getPass());

        String arr [] ={user.getEmail()+"" , user.getPhone()+""};

        // update method always return int (number of colums you edit in) ;

        int result = db.update(DB_NAME , values ,"email=? , phone=?" ,arr);

        return (result > 0) ;
    }

    public boolean delete_user (user1 user)
    {
        SQLiteDatabase db = getWritableDatabase();

        String arr [] ={user.getEmail()+"" , user.getPass()+""};
        int result = db.delete(DB_NAME ,"email=?" ,arr);

        return (result > 0) ;
    }

    public long get_count ()
    {
        SQLiteDatabase db = getWritableDatabase();

        return DatabaseUtils.queryNumEntries(db , DB_NAME);
    }

    public ArrayList<user1> get_all_data ()
    {
        SQLiteDatabase db = getReadableDatabase();

        ArrayList <user1> users = new ArrayList<>();

        Cursor cursor = db.rawQuery("select * from "+DB_NAME ,null);

        if(DB_NAME != null && cursor.moveToFirst())
        {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(USER_ID));
                String name = cursor.getString(cursor.getColumnIndex(USER_NAME));
                String email = cursor.getString(cursor.getColumnIndex(USER_EMAIL));
                String phone = cursor.getString(cursor.getColumnIndex(USER_PHONE));
                String pass = cursor.getString(cursor.getColumnIndex(USER_PASS));

                user1 user = new user1 (id ,name , email, phone,pass );

                users.add(user);

            }while(cursor.moveToNext());

           cursor.close();

        }

        return users;
    }
}
