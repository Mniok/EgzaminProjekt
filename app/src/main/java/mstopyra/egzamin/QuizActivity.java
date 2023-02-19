package mstopyra.egzamin;

//package jp.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.content.Intent;
import android.view.View.OnClickListener;
import android.widget.Toast;
import static android.widget.Toast.LENGTH_LONG;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import static android.widget.Toast.LENGTH_LONG;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class QuizActivity extends Activity {
    TextView tv1,tv2;
    RadioButton a, b, c, d, e, f;
    Button btn, back;
    RadioGroup rg;
    int qnumber,score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        //back
        back=(Button)findViewById(R.id.ButtonBackToMenu);
        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        //quiz
        tv1=(TextView)findViewById(R.id.question);
        tv2=(TextView)findViewById(R.id.response);
        rg=(RadioGroup)findViewById(R.id.optionGroup);
        a=(RadioButton)findViewById(R.id.option1);
        b=(RadioButton)findViewById(R.id.option2);
        c=(RadioButton)findViewById(R.id.option3);
        d=(RadioButton)findViewById(R.id.option4);
        e=(RadioButton)findViewById(R.id.option5);
        f=(RadioButton)findViewById(R.id.option6);
        btn=(Button)findViewById(R.id.next);
        qnumber=0;
        score=0;
    }

    public void setQuestionContent(String question, String[] answers){
        tv1.setText(question);
        a.setVisibility(View.GONE);
        b.setVisibility(View.GONE);
        c.setVisibility(View.GONE);
        d.setVisibility(View.GONE);
        e.setVisibility(View.GONE);
        f.setVisibility(View.GONE);
        switch(answers.length){
            case 6: {
                f.setText(answers[5]);
                f.setVisibility(View.VISIBLE);
            }
            case 5: {
                e.setText(answers[4]);
                e.setVisibility(View.VISIBLE);
            }
            case 4: {
                d.setText(answers[3]);
                d.setVisibility(View.VISIBLE);
            }
            case 3: {
                c.setText(answers[2]);
                c.setVisibility(View.VISIBLE);
            }
            case 2: {
                b.setText(answers[1]);
                b.setVisibility(View.VISIBLE);
            }
            case 1: {
                a.setText(answers[0]);
                a.setVisibility(View.VISIBLE);
            }
        }
    }
    public void quiz(View v){ //onclick btn
        switch (qnumber){
            case 0:
            {
                rg.setVisibility(View.VISIBLE);
                rg.clearCheck();
                tv2.setText("");
                a.setEnabled(true);
                b.setEnabled(true);
                c.setEnabled(true);
                d.setEnabled(true);
                e.setEnabled(true);
                f.setEnabled(true);
                btn.setText("Next");
                score=0;
                setQuestionContent("1. Pakiet biblioteki Swing ?",
                        new String[] {"java.swing",
                        "java.awt",
                        "javax.swing",
                        "javax.awt"}
                );
                qnumber=1;
                break;
            }
            case 1:
            {
                setQuestionContent("2. Która technologia jest związana z JavaFX ?",
                        new String[] {"JSP",
                        "FXML",
                        "JSF",
                        "EJB",
                        "SAS",
                        "DOM"}
                );
                if (c.isChecked()){
                    score=score+1;
                }
                qnumber=2;
                rg.clearCheck();
                break;
            }
            case 2:
            {
                setQuestionContent("3. Który pakiet związany jest z serwletami ?",
                        new String[] {"javax.servlet",
                        "java.servlet",
                        "javaee.servlet",
                        "javae.servlet"}
                );
                if (b.isChecked()){
                    score=score+1;
                }
                qnumber=3;
                rg.clearCheck();
                break;
            }
            case 3:
            {
                setQuestionContent("4. Który pakiet związany jest z platformą Android ?",
                        new String[] {"javax.android",
                        "java.android",
                        "android.java",
                        "android.app",
                        "javaee.android"}
                );
                if (a.isChecked()){ score=score+1; }
                qnumber=4;
                rg.clearCheck();
                break;
            }
            case 4:
            {
                setQuestionContent("5. Która technologia jest bezpośrednio związana z obsługą transakcji ?",
                        new String[] {"JDBC",
                        "EJB",
                        "JTA",
                        "JPA",
                        "FXML",
                        "JSP"}
                );
                if (d.isChecked()){
                    score=score+1;
                }
                qnumber=5;
                rg.clearCheck();
                break;
            }
            case 5:
            {
                setQuestionContent("6. Czy w języku Java istnieją wyrażenia lambda ?",
                        new String[] {"Tak",
                        "Nie"}
                );
                if (c.isChecked()){
                    score=score+1;
                }
                qnumber=6;
                rg.clearCheck();
                break;
            }
            case 6:
            {
                setQuestionContent("7. W wyniku kompilacji kodu otrymano pliki MyClass$1.class i MyClass$2.\nPliki te zostały wygenerowane, ponieważ:",
                        new String[] {"Istnieją dwie klasy: MyClass$1 i MyClass$2",
                        "Klasa MyClass zawiera dwie klasy wewnętrzne o nazwach 1 i 2",
                        "Klasa MyClass zawiera dwie anonimowe klasy wewnętrzne"}
                );
                if (a.isChecked()){ score=score+1; }
                qnumber=7;
                //uncheckAll();
                rg.clearCheck();
                btn.setText("Finish");
                break;
            }
            case 7:
            {
                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                e.setEnabled(false);
                f.setEnabled(false);
                //uncheckAll();
                rg.clearCheck();
                if (c.isChecked()){
                    score=score+1;
                }
                tv1.setText("");
                tv2.setText("Wynik testu: " + score + "/7");
                btn.setText("Restart");
                qnumber=0;
                break;
            }
        }
    }
}