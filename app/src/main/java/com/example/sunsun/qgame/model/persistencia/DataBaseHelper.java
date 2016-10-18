package com.example.sunsun.qgame.model.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper{

    private static final String NOMBRE_BD = "QGame";
    private static final int VERSION = 1;
    public static final String TABLA = "Preguntas";
    public static final String CAMPO1 = "question";
    public static final String CAMPO2 = "res1";
    public static final String CAMPO3 = "res2";
    public static final String CAMPO4 = "res3";
    public static final String CAMPO5 = "resCorrect";

    public static final String BD_CREATE_PREGUNTAS = "create table "+TABLA+
            "(_id integer primary key autoincrement,"+
            CAMPO1+" text not null,"+
            CAMPO2+" text not null,"+
            CAMPO3+" text not null,"+
            CAMPO4+" text not null,"+
            CAMPO5+" text not null)";
    public DataBaseHelper (Context context){
        super (context,NOMBRE_BD,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(BD_CREATE_PREGUNTAS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exist"+TABLA);
        db.execSQL(BD_CREATE_PREGUNTAS);
    }
}
