package com.example.sunsun.qgame.model.persistencia;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sunsun.qgame.model.entidad.Pregunta;


public class AlmacenPreguntas {

    private DataBaseHelper db=null;
    private SQLiteDatabase sql = null;

    public AlmacenPreguntas(Context context){
        db = new DataBaseHelper(context);
        sql = db.getWritableDatabase();
    }
    public void cerrar(){
        db.close();
    }

    public void crearBBDD(Pregunta pregunta) {
        //Para crear la base de datos con todas las preguntas
        //esta función se llamaría recorriendo una array con las preguntas
        ContentValues contentValues = new ContentValues();

        contentValues.put(DataBaseHelper.CAMPO1, pregunta.getPregunta());
        contentValues.put(DataBaseHelper.CAMPO2, pregunta.getRes1());
        contentValues.put(DataBaseHelper.CAMPO3, pregunta.getRes2());
        contentValues.put(DataBaseHelper.CAMPO4, pregunta.getRes3());
        contentValues.put(DataBaseHelper.CAMPO5, pregunta.getResCorrecta());

        sql.insert(DataBaseHelper.TABLA, null, contentValues);
    }


    public Pregunta sacarPregunta(String id){
        //para sacar una pregunta
        Pregunta pregunta =null;
        String columnasABuscar[] = {"_id",DataBaseHelper.CAMPO1,DataBaseHelper.CAMPO2,DataBaseHelper.CAMPO3,DataBaseHelper.CAMPO4,DataBaseHelper.CAMPO5};
        String where = "_id=?";
        String argumentosWhere[] = {id};

        Cursor cursor = sql.query(DataBaseHelper.TABLA,columnasABuscar,where,argumentosWhere,null,null,null);
        if(cursor.moveToNext()){

            pregunta = new Pregunta(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getInt(5));
            //pregunta.setId(cursor.getInt(0));
           // pregunta.setPregunta(cursor.getString(1));
            //pregunta.setRes1(cursor.getString(2));
           // pregunta.setRes2(cursor.getString(3));
            //pregunta.setRes3(cursor.getString(4));
            //pregunta.setResCorrecta(cursor.getInt(5));

        }
        return pregunta;
    }

    /*public Pregunta sacarPregunta(int id){
        GestorPreguntas gp = new GestorPreguntas(context);
        ArrayList<Pregunta> arrayQ = gp.cogerArray();
        Pregunta pregunta = arrayQ.get(id);
        return pregunta;
    }*/

}
