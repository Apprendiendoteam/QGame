package com.example.sunsun.qgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sunsun.qgame.model.entidad.Pregunta;
import com.example.sunsun.qgame.model.negocio.GestorPreguntas;

import java.util.ArrayList;

public class QuestionScreen extends AppCompatActivity {

    TextView tvPregunta;
    RadioButton rb1,rb2,rb3;
    RadioGroup rgRes;
    int contador=0;
    int numAciertos=0;
    Pregunta pregunta;
    GestorPreguntas gp;
    Button bt_next,bt_finish;
    ArrayList<Pregunta> arrayQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_screen);

        gp = new GestorPreguntas(this);

        //arrayQ=gp.cogerArray();
        tvPregunta = (TextView)findViewById(R.id.question_tv);
        rb1 = (RadioButton)findViewById(R.id.rb1);
        rb2 = (RadioButton)findViewById(R.id.rb2);
        rb3 = (RadioButton)findViewById(R.id.rb3);
        rgRes = (RadioGroup)findViewById(R.id.rgRes);
        bt_next=(Button)findViewById(R.id.next_bt);
        bt_finish=(Button)findViewById(R.id.finish_bt);
        if (contador==0) {
            pregunta = gp.iniciarPartida();
            contador++;
        }

        if (pregunta!=null) {
            tvPregunta.setText(pregunta.getPregunta().toString());
            rb1.setText(pregunta.getRes1().toString());
            rb2.setText(pregunta.getRes2().toString());
            rb3.setText(String.valueOf(pregunta.getRes3()));
        }

        rgRes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int res=0;
                if (contador<Pregunta.numeroQ){
                    bt_next.setVisibility(View.VISIBLE);
                    if (checkedId==R.id.rb1){
                        res=1;
                    }else if(checkedId==R.id.rb2){
                        res=2;
                    }else if (checkedId==R.id.rb3){
                        res=3;
                    }
                    boolean correcto=gp.checkRespuesta(res,pregunta);
                    String frase;
                    if (correcto){
                        frase="Respuesta CORRECTA";
                        numAciertos++;
                    //mostrar el botón y recoger y comprobar.
                    Toast.makeText(QuestionScreen.this,frase,Toast.LENGTH_LONG).show();
                    }
                    else {
                        frase="Respuesta INCORRECTA";
                        Toast.makeText(QuestionScreen.this,frase,Toast.LENGTH_LONG).show();
                    }
                }
                if (contador==Pregunta.numeroQ){
                    bt_finish.setVisibility(View.VISIBLE);
                }
            }
        });


    }

    public void siguienteQ(View v){
        pregunta=gp.siguientePregunta();
        tvPregunta.setText(pregunta.getPregunta().toString());
        rb1.setText(pregunta.getRes1().toString());
        rb2.setText(pregunta.getRes2().toString());
        rb3.setText(pregunta.getRes3().toString());
        //llamar al métdo siguientePreg y volver a setText y checked
    }

}
