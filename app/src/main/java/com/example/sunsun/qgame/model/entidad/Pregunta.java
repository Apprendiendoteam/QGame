package com.example.sunsun.qgame.model.entidad;



public class Pregunta {

    private int id,resCorrecta;
    private String ques,res1,res2,res3;

    public Pregunta(){

    }

    public Pregunta(int id,String ques, String res1, String res2, String res3, int resCorrecta){

        this.ques=ques;
        this.res1=res1;
        this.res2=res2;
        this.res3=res3;
        this.resCorrecta=resCorrecta;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPregunta() {
        return ques;
    }

    public void setPregunta(String ques) {
        this.ques = ques;
    }

    public String getRes1() {
        return res1;
    }

    public void setRes1(String res1) {
        this.res1 = res1;
    }

    public String getRes2() {
        return res2;
    }

    public void setRes2(String res2) {
        this.res2 = res2;
    }

    public String getRes3() {
        return res3;
    }

    public void setRes3(String res3) {
        this.res3 = res3;
    }

    public int getResCorrecta() {
        return resCorrecta;
    }

    public void setResCorrecta(int resCorrecta) {
        this.resCorrecta = resCorrecta;
    }


    public static Pregunta p0 = new Pregunta(0,"¿Quién descubrió America?","Marco Polo","Cristobal Colón","Ronald",2);
    public static Pregunta p1 = new Pregunta(1,"Película de Will Smith","300","Los invencibles","Soy leyenda",3);
    public static Pregunta p2 = new Pregunta(2,"Ganador de la Liga ACB 2016","Real Madrid","Unicaja","FC Barcelona",1);
    public static Pregunta p3 = new Pregunta(3,"Ganador del Premio Nobel de Literatura","Bob Dylan","Mo Yan","Mario Vargas Llosa",1);
    public static Pregunta p4 = new Pregunta(4,"Altura del hombre más corto del mundo","71 cm","54 cm","43 cm",2);
    public static Pregunta p5 = new Pregunta(5,"Candidatos para la presidencia de los Estados Unidos, año 2016","Hillary Clinton y Marco Rubio","Ted Cruz y Donald Trump","Donald Trump y Hillary Clinton",3);
    public static Pregunta p6 = new Pregunta(6,"¿Cuántos meses de gestación tiene la ballena?","3 meses","11 o 12 meses","15 o 16 meses",2);
    public static Pregunta p7 = new Pregunta(7,"¿Cuántas horas duermen los koalas?","22 horas","8 horas","3 horas",1);

    public static int numeroQ = 8;


}
