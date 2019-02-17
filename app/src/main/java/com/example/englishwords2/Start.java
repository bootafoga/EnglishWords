package com.example.englishwords2;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class Start extends AppCompatActivity implements View.OnClickListener {


    Words[] words = new Words[26];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        initializeWords();
    }


    protected void initializeWords(){
        BufferedReader reader = null;

        InputStream is = getResources().openRawResource(R.raw.input);
        try {
            reader = new BufferedReader(new InputStreamReader(is, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String[] inputs = new String[26];


        for (int i = 0; i < 26; i++){
            words[i] = new Words();
        }

        for (int i = 0; i < 26; ++i) {
            try {
                inputs[i] = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String[] oneString;

        for (int i = 0; i < 26; i++){
            oneString = inputs[i].split(";");

            words[i].id = i;
            words[i].setEng(oneString[0]);
            words[i].setRus(oneString[1]);
            Words.countOfWords = i;
        }
    }

    public void onClick(View v){ //RUS WORD
        TextView trans = (TextView) findViewById(R.id.Translate);
        trans.setText("Translate");
        Random rand = new Random();
        int num = rand.nextInt(26);
        TextView rus = (TextView) findViewById(R.id.Word);;
        rus.setText(words[num].getRus());
        Words.currentWord = num;
        Words.flag = 0;
    }

    public void onClick2(View v){ //ENG WORD
        TextView trans = (TextView) findViewById(R.id.Translate);
        trans.setText("Translate");
        Random rand = new Random();
        int num = rand.nextInt(10);
        TextView eng = (TextView) findViewById(R.id.Word);
        eng.setText(words[num].getEng());
        Words.currentWord = num;
        Words.flag = 1;
    }

    public void Show(View v){ //ENG WORD
        TextView check = (TextView) findViewById(R.id.Translate);
        if (Words.flag == 1) check.setText(words[Words.currentWord].getRus());
        if (Words.flag == 0) check.setText(words[Words.currentWord].getEng());

    }
}



class Words{
    int id;
    private String eng;
    private String rus;

    static int countOfWords;
    static int currentWord;
    static int flag;

    void setEng(String eng){
        this.eng = eng;
    }

    void setRus(String rus){
        this.rus = rus;
    }

    String getRus(){
        return rus;
    }

    String getEng(){
        return eng;
    }
}