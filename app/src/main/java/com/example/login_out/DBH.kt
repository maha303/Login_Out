package com.example.login_out

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBH (context: Context):SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {
    companion object{
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "MyDB"
        private const val TABLE_USERS = "UsersTable"

        private const val KEY_ID = "_id"
        private const val KEY_NAME = "_name"
        private const val KEY_MOBILE="_mobile"
        private const val KEY_LOCATION="_location"
        private const val KEY_PASSWORD="_password"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createT=("CREATE TABLE $TABLE_USERS($KEY_ID INTEGER PRIMARY KEY ,$KEY_NAME TEXT ,$KEY_MOBILE text,$KEY_LOCATION TEXT,$KEY_PASSWORD TEXT)")
        db?.execSQL(createT)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
    fun addUser(user: User): Long {
        val db=this.writableDatabase
        val cv=ContentValues()
        cv.put(KEY_NAME,user.Name)
        cv.put(KEY_MOBILE,user.Mobile)
        cv.put(KEY_LOCATION,user.Location)
        cv.put(KEY_PASSWORD,user.Password)
        val success = db.insert(TABLE_USERS,null,cv)
        //db.close()
        return success
    }

    fun getdata(name2:String): String {
        val db=this.writableDatabase
        var c:Cursor?
        c = db.query(TABLE_USERS,null,"$KEY_NAME=?", arrayOf(name2),null,null,null)
        c.moveToFirst()
        var loc = "Name: "+c.getString(c.getColumnIndex("$KEY_NAME"))+"\n"+"Mobile: "+c.getString(c.getColumnIndex("$KEY_MOBILE"))+"\n"+"Location: "+c.getString(c.getColumnIndex("$KEY_LOCATION"))+"\n"+"Password: "+c.getString(c.getColumnIndex("$KEY_PASSWORD"))
        return loc
    }

    fun Delete1(name2:String){
        val db=this.writableDatabase
        db.delete(TABLE_USERS,"$KEY_NAME=?", arrayOf(name2))
    }
}