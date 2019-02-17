package com.example.englishwords2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start:
                Intent intent = new Intent (this, Start.class);
                startActivity(intent);
                break;

            case R.id.add:
                Intent intent2 = new Intent (this, Add.class);
                startActivity(intent2);
                break;
        }

    }



}
