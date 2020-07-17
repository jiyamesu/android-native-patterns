package com.designpatterns.canvasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //btnHello = (Button) findViewById(R.id.btn1);
        //btnHello.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        System.out.println(">>>>>>>>>>>> hello");

    }
}