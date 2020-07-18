package com.designpatterns.canvasapp;

public abstract class Shape {
    private Coord coord;
    private Dim2d dim;
    private AreaBounds areaBounds = new AreaBounds();

    public Shape() {
        Coord defaultCoord = new Coord();
        defaultCoord.setX(0);
        defaultCoord.setY(0);

        Dim2d defaultDim2d = new Dim2d();
        defaultDim2d.setHeight(0);
        defaultDim2d.setWidth(0);

        setCoord(defaultCoord);
        setDim(defaultDim2d);
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Dim2d getDim() {
        return dim;
    }

    public void setDim(Dim2d dim) {
        this.dim = dim;
    }

    public AreaBounds getAreaBounds() {
        return areaBounds;
    }

    protected void calculateAreaBounds() {
        areaBounds.setLeft(coord.getX());
        areaBounds.setTop(coord.getY());
        areaBounds.setRight(coord.getX() + dim.getWidth());
        areaBounds.setBottom(coord.getY() + dim.getHeight());
    }

    protected void draw() {
        this.calculateAreaBounds();
    }
}
