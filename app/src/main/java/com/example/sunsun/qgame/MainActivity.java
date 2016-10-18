package com.example.sunsun.qgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.sunsun.qgame.model.negocio.GestorPreguntas;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void start(View v){
        GestorPreguntas gp = new GestorPreguntas(this);
        gp.insertarEnBBDD();
        Intent start_intent = new Intent (this,QuestionScreen.class);
        startActivity(start_intent);
    }
}
