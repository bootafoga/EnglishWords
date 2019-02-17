package com.example.englishwords2;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Add extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

    }


    public void onClick(View v){ //RUS WORD
        EditText editText = (EditText) findViewById(R.id.Word);

        TextView tview = (TextView)findViewById(R.id.Translate);
        String result = editText.getText().toString();

        tview.setText(result);
    }
}
