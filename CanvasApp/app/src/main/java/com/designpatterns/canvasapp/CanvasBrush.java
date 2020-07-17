package com.designpatterns.canvasapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;

import java.util.ArrayList;

public class CanvasBrush extends View {

    private String currentTool = "ellipseTool";

    private ShapeDrawable drawable;

    private ArrayList<ShapeDrawable> shapeDrawables = new ArrayList<>();

    public CanvasBrush(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        setContentDescription(context.getResources().getString(R.string.my_view_desc));

    }

    protected void drawEllipseShape(int x, int y, int width, int height){
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());

        shapeDrawable.getPaint().setColor(0xff74AC23);

        shapeDrawable.setBounds(x, y, x + width, y + height);

        shapeDrawables.add(shapeDrawable);
    }

    protected void drawTextShape(MotionEvent event) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
        TextView text = new TextView(this.getContext());

        text.setText("Hello!");
        text.setX(event.getX());
        text.setY(event.getY());
    }

    protected void drawRectShape(MotionEvent event) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());

        shapeDrawable.getPaint().setColor(0xff74AC23);

        shapeDrawable.setBounds((int) event.getX(), (int) event.getY(), (int) event.getX() + 100, (int) event.getY() + 40);

        shapeDrawables.add(shapeDrawable);
    }

    @Override
    public void onDraw(Canvas canvas) {

        for (ShapeDrawable shape:shapeDrawables) {
            shape.draw(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = MotionEventCompat.getActionMasked(event);

        switch(action){
            case (MotionEvent.ACTION_DOWN):
                return true;

            case (MotionEvent.ACTION_UP):
                return true;

            case (MotionEvent.ACTION_MOVE):
                switch (currentTool) {
                    case ("ellipseTool"):
                        drawEllipseShape((int) event.getX(), (int) event.getY(), 15, 15);
                        this.postInvalidate((int) event.getX(), (int) event.getY(), ((int) event.getX() + 15), ((int) event.getY() + 15));
                        break;

                    case ("rectTool"):
                        drawRectShape(event);
                        this.postInvalidate((int) event.getX(), (int) event.getY(), ((int) event.getX() + 15), ((int) event.getY() + 15));
                        break;
                }


                return true;
        }

        return super.onTouchEvent(event);
    }

    public void clearAll() {
        shapeDrawables.clear();

        this.invalidate();
    }

    public String getCurrentTool() {
        return currentTool;
    }

    public void setCurrentTool(String currentTool) {
        this.currentTool = currentTool;
    }
}
