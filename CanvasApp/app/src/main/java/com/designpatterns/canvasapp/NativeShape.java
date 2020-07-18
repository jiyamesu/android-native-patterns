package com.designpatterns.canvasapp;

import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;

public abstract class NativeShape extends Shape {
    private ShapeDrawable drawable;
    private Canvas canvas;

    @Override
    protected void draw() {
        super.draw();
        drawable.draw(canvas);
    }

    public void refreshBounds() {
        calculateAreaBounds();
        AreaBounds areaBounds = getAreaBounds();

        drawable.setBounds(
            (int) areaBounds.getLeft(),
            (int) areaBounds.getTop(),
            (int) areaBounds.getRight(),
            (int) areaBounds.getBottom()
        );
    }

    public ShapeDrawable getDrawable() {
        return drawable;
    }

    public void setDrawable(ShapeDrawable drawable) {
        this.drawable = drawable;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }
}
