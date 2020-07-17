package com.designpatterns.canvasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {

    private Button btnClearCanvas;
    private Button btnRectTool;
    private Button btnCircleTool;

    private CanvasBrush canvasBrush;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnClearCanvas = (Button) findViewById(R.id.btnClearCanvas);
        btnRectTool = (Button) findViewById(R.id.btnRectTool);
        btnCircleTool = (Button) findViewById(R.id.btnCircleTool);

        canvasBrush = (CanvasBrush) findViewById(R.id.canvasBrush);

        btnClearCanvas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                canvasBrush.clearAll();
            }
        });

        btnRectTool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                canvasBrush.setCurrentTool("rectTool");
            }
        });

        btnCircleTool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                canvasBrush.setCurrentTool("ellipseTool");
            }
        });
    }

}