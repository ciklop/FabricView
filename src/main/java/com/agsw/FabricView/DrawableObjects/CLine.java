package com.agsw.FabricView.DrawableObjects;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Nguyen Hoang Anh Nguyen on 8/15/16.
 */
public class CLine implements CDrawable {

    private int xOrigin, yOrigin;
    private int xDest, yDest;
    private Paint mPaint;
    private int mRotDegree;

    public CLine(int xOrigin, int yOrigin, int xDest, int yDest, Paint p) {
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
    public void setPaint(Paint p) {
        mPaint = p;
    }

    @Override
    public int getXcoords() {
        return xOrigin;
    }

    @Override
    public void setXcoords(int x) {
        this.xOrigin = x;
    }

    @Override
    public int getYcoords() {
        return yOrigin;
    }

    @Override
    public void setYcoords(int y) {
        this.yOrigin = y;
    }

    public int getXdest() {
        return xDest;
    }

    public void setXdest(int xDest) {
        this.xDest = xDest;
    }

    public int getYdest() {
        return yDest;
    }

    public void setYdest(int yDest) {
        this.yDest = yDest;
    }

    @Override
    public void draw(Canvas canvas) {

        if (getXcoords() + getYcoords() + getXdest() + getYdest() == 0) {
            return;
        }

        canvas.drawLine(getXcoords(), getYcoords(), getXdest(), getYdest(), mPaint);
    }

    @Override
    public int getRotation() {
        return mRotDegree;
    }

    @Override
    public void setRotation(int degree) {
        mRotDegree = degree;
    }

    @Override
    public void translateTo(int x, int y) {
        int dx = getXdest() - getXcoords();
        int dy = getYdest() - getYcoords();

        // CENTER ANCHOR
        x = x - dx / 2;
        y = y - dy / 2;
        // CENTER ANCHOR

        setXcoords(x);
        setYcoords(y);
        setXdest(x + dx);
        setYdest(y + dy);
    }
}
