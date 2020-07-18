package com.designpatterns.canvasapp;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;

import java.util.ArrayList;

public class CanvasBrush extends View {

    private ToolType currentTool;

    private ArrayList<NativeShape> shapes = new ArrayList<>();

    public CanvasBrush(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        setContentDescription(context.getResources().getString(R.string.my_view_desc));
    }

    protected void drawEllipseShape(MotionEvent event){
        // TODO
    }


    protected void drawTextShape(MotionEvent event) {
        // TODO
    }

    protected void drawRectShape(MotionEvent event) {
        RectangleShape rectangleShape = new RectangleShape();

        rectangleShape.getCoord().setX(event.getX());
        rectangleShape.getCoord().setY(event.getY());

        rectangleShape.refreshBounds();
        invalidate();

        shapes.add(rectangleShape);
    }

    @Override
    public void onDraw(Canvas canvas) {
        for (NativeShape shape : shapes) {
            shape.setCanvas(canvas);
            shape.draw();
        }
    }

    private void touchDown(MotionEvent event) {

    }

    private void touchUp(MotionEvent event) {

    }

    private void touchMove(MotionEvent event) {
        if (currentTool == ToolType.CIRCLE) {
            // TODO
        } else if (currentTool == ToolType.RECTANGLE) {
            drawRectShape(event);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = MotionEventCompat.getActionMasked(event);

        switch(action){
            case (MotionEvent.ACTION_DOWN): {
                touchDown(event);
                return true;
            }

            case (MotionEvent.ACTION_UP): {
                touchUp(event);
                return true;
            }

            case (MotionEvent.ACTION_MOVE): {
                touchMove(event);
                return true;
            }
        }

        return super.onTouchEvent(event);
    }

    public void clearAll() {
        shapes.clear();

        this.invalidate();
    }

    public ToolType getCurrentTool() {
        return currentTool;
    }

    public void setCurrentTool(ToolType currentTool) {
        this.currentTool = currentTool;
    }
}
