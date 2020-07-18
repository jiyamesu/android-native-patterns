package com.designpatterns.canvasapp;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;

public class RectangleShape extends NativeShape {
    public RectangleShape() {
        super();

        this.setDrawable(new ShapeDrawable(new RectShape()));

        this.getDrawable().getPaint().setColor(0xffffAC23);

        Dim2d rectDim = new Dim2d();
        rectDim.setWidth(100);
        rectDim.setHeight(40);

        this.setDim(rectDim);
    }
}
