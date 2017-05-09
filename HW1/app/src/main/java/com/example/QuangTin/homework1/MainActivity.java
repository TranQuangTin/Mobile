package com.example.QuangTin.homework1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btWhite, btGreen, btRed, btnYellow;
    TextView imgView;
    LinearLayout ln;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgView = (TextView) findViewById(R.id.imgView);
        btnYellow = (Button)findViewById(R.id.btnYellow);
        btGreen = (Button)findViewById(R.id.btGreen);
        btWhite = (Button)findViewById(R.id.btWhite);
        btRed = (Button)findViewById(R.id.btRed);
        ln= (LinearLayout)findViewById(R.id.lnlayout);

        btRed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                imgView.setBackgroundColor(Color.RED);
                ln.setBackgroundColor(Color.RED);
            }
        });

        btWhite.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                imgView.setBackgroundColor(Color.WHITE);
                ln.setBackgroundColor(Color.WHITE);
            }
        });

        btnYellow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                imgView.setBackgroundColor(Color.YELLOW);
                ln.setBackgroundColor(Color.YELLOW);
            }
        });

        btGreen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                imgView.setBackgroundColor(Color.GREEN);
                ln.setBackgroundColor(Color.GREEN);
            }
        });
    }
}
