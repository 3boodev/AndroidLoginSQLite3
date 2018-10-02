package com.example.abdullah.task1

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Database(context: Context) : SQLiteOpenHelper(context, "login.db", null, 1) {


    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE User(email TEXT primary key ,password TEXT)")
     }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS User")
    }

    //Insert Function
    fun insert(email:String,pass:String):Boolean{
        val DB:SQLiteDatabase=this.writableDatabase
        val values=ContentValues()
        values.put("email",email)
        values.put("password",pass)
        val  insert=DB.insert("User",null,values)
        DB.close()
        return !insert.equals(-1)
    }
    //check if email is exists .
    fun checkemail(email: String):Boolean{

        val DB:SQLiteDatabase=this.readableDatabase
        val cursor:Cursor=DB.rawQuery("SELECT * FROM User WHERE email=? ", arrayOf(email))
        return cursor.count <= 0
    }

    //check if email & password exists .
    fun chexhall(email:String,pass:String):Boolean{
        val DB:SQLiteDatabase=this.readableDatabase
        val cursor:Cursor=DB.rawQuery("SELECT * FROM User WHERE email=? and password=? ", arrayOf(email,pass))
        return cursor.count>0
    }
}


