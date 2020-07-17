package com.designpatterns.canvasapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;

import java.util.ArrayList;

public class CanvasBrush extends View {

    private ShapeDrawable drawable;
    private ArrayList<ShapeDrawable> shapeDrawables = new ArrayList<>();

    public CanvasBrush(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        setContentDescription(context.getResources().getString(R.string.my_view_desc));

    }

    protected void drawEllipseShape(int x, int y, int width, int height){
        //drawable = new ShapeDrawable(new OvalShape());
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());

        shapeDrawable.getPaint().setColor(0xff74AC23);

        shapeDrawable.setBounds(x, y, x + width, y + height);

        shapeDrawables.add(shapeDrawable);
    }

    @Override
    public void onDrawForeground(Canvas canvas) {

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
                System.out.println((int) event.getX() + "," + (int) event.getY());

                drawEllipseShape((int) event.getX(), (int) event.getY(), 15, 15);
                this.postInvalidate((int) event.getX(), (int) event.getY(), ((int) event.getX() + 15), ((int) event.getY() + 15));

                return true;
        }

        return super.onTouchEvent(event);
    }
}
