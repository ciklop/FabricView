package com.agsw.FabricView.DrawableObjects;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by antwan on 10/3/2015.
 */
public class CText implements CDrawable {
    private String mText;
    private Paint mPaint;
    private int x, y, mRotDegree;

    public CText(String s, int x, int y, Paint p) {
        setText(s);
        setYcoords(y);
        setXcoords(x);
        setPaint(p);
    }

    public String getText() {
        return mText;
    }

    public void setText(String t) {
        mText = t;
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
        return x;
    }

    @Override
    public void setXcoords(int x) {
        this.x = x;
    }

    @Override
    public int getYcoords() {
        return y;
    }

    @Override
    public void setYcoords(int y) {
        this.y = y;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawText(getText(), (float) getXcoords(), (float) getYcoords(), mPaint);
    }

    @Override
    public int getRotation() {
        return mRotDegree;
    }

    @Override
    public void setRotation(int degree) {
        mRotDegree = degree;
    }

    /**
     * Measure text size
     *
     * @return Size of text on screen
     */
    public Rect getBounds() {
        Rect bounds = new Rect();
        mPaint.getTextBounds(mText, 0, mText.length(), bounds);
        return bounds;
    }
}
