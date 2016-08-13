package com.agsw.FabricView.DrawableObjects;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by nguyen on 8/13/16.
 */
public class CRect implements CDrawable {

    private int xOrigin, yOrigin;
    private int xDest, yDest;
    private Paint mPaint;
    private int mRotDegree;

    public CRect(int xOrigin, int yOrigin, int xDest, int yDest, Paint p) {
        setXcoords(xOrigin);
        setYcoords(yOrigin);
        setXdest(xDest);
        setYdest(yDest);
        setPaint(p);
    }

    @Override
    public Paint getPaint() {
        return mPaint;
    }

    @Override
    public int getXcoords() {
        return xOrigin > xDest ? xDest : xOrigin;
    }

    @Override
    public int getYcoords() {
        return yOrigin > yDest ? yDest : yOrigin;
    }

    public int getXdest() {
        return xDest < xOrigin ? xOrigin : xDest;
    }

    public int getYdest() {
        return yDest < yOrigin ? yOrigin : yDest;
    }

    @Override
    public void setXcoords(int x) {
        this.xOrigin = x;
    }

    @Override
    public void setYcoords(int y) {
        this.yOrigin = y;
    }

    @Override
    public void setPaint(Paint p) {
        mPaint = p;
    }

    @Override
    public void draw(Canvas canvas) {

        if (getXcoords() + getYcoords() + getXdest() + getYdest() == 0) {
            return;
        }

        canvas.drawRect(getXcoords(), getYcoords(), getXdest(), getYdest(), mPaint);
    }

    @Override
    public int getRotation() {
        return mRotDegree;
    }

    @Override
    public void setRotation(int degree) {
        mRotDegree = degree;
    }

    public void setXdest(int xDest) {
        this.xDest = xDest;
    }

    public void setYdest(int yDest) {
        this.yDest = yDest;
    }
}
