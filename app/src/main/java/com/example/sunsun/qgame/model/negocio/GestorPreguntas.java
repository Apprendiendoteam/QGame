package com.example.sunsun.qgame.model.negocio;


import android.content.Context;

import com.example.sunsun.qgame.model.entidad.Pregunta;
import com.example.sunsun.qgame.model.persistencia.AlmacenPreguntas;

import java.util.ArrayList;
import java.util.Random;

public class GestorPreguntas {

    private Context context;
    private int cont;
    private static ArrayList<Integer> nums;
    Random rdn = new Random();

    public GestorPreguntas(Context context) {
        this.context = context;
    }

    public ArrayList<Pregunta> cogerArray(){
        ArrayList<Pregunta> arrayQ= new ArrayList<>();
        arrayQ.add(Pregunta.p0);
        arrayQ.add(Pregunta.p1);
        arrayQ.add(Pregunta.p2);
        arrayQ.add(Pregunta.p3);
        arrayQ.add(Pregunta.p4);
        arrayQ.add(Pregunta.p5);
        arrayQ.add(Pregunta.p6);
        arrayQ.add(Pregunta.p7);
        return arrayQ;
    }

    public void insertarEnBBDD(){
        ArrayList<Pregunta> arrayQ=cogerArray();
        AlmacenPreguntas ap = new AlmacenPreguntas(context);
      //consultar como no crear BBDD cada vez que se abra la app
        for (Pregunta p:arrayQ) {
            ap.crearBBDD(p);
        }
        ap.cerrar();

    }

    public Pregunta iniciarPartida(){
        cont=1;
        nums = new ArrayList<>();
        int aleatorio = rdn.nextInt(Pregunta.numeroQ);
        nums.add(aleatorio);
        AlmacenPreguntas ap = new AlmacenPreguntas(context);
        Pregunta pregunta = ap.sacarPregunta(String.valueOf(aleatorio));

        return pregunta;
    }

    public Pregunta siguientePregunta(){
        cont += 1;
        boolean ok;
        int aleatorio;
        do {
            ok=false;
            aleatorio = rdn.nextInt(Pregunta.numeroQ);
            for (int i : nums) {
                if (i == aleatorio) {
                    ok = true;
                }
            }
        }while (ok);
        AlmacenPreguntas ap = new AlmacenPreguntas(context);
        Pregunta pregunta = ap.sacarPregunta(String.valueOf(aleatorio));
        return pregunta;
    }

    public boolean checkRespuesta(int res,Pregunta pregunta){
        boolean correcta=false;
        if (res==pregunta.getResCorrecta()){
            correcta=true;
        }
        return correcta;
    }
}
