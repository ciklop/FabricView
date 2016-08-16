package com.agsw.FabricView.DrawableObjects;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

/**
 * Created by antwan on 10/3/2015.
 */
public class CPath implements CDrawable {
    private int x, y;
    private Path mPath;
    private Paint mPaint;
    private int mRotDegree;

    public CPath() {
        mPath = new Path();
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
        canvas.drawPath(mPath, mPaint);
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

        // ANCHOR CENTER
        RectF bounds = new RectF();
        mPath.computeBounds(bounds, true);
        PointF centerBounds = new PointF(bounds.left + bounds.width() / 2.f, bounds.top + bounds.height() / 2.f);
        PointF vector = new PointF(getXcoords() - centerBounds.x, getYcoords() - centerBounds.y);
        x = (int) (x + vector.x);
        y = (int) (y + vector.y);
        // ANCHOR CENTER

        float dx = x - getXcoords();
        float dy = y - getYcoords();

        Matrix matrix = new Matrix();
        matrix.postTranslate(dx, dy);
        mPath.transform(matrix);

        setXcoords(x);
        setYcoords(y);
    }

    public void lineTo(float eventX, float eventY) {
        mPath.lineTo(eventX, eventY);
    }

    public void moveTo(float eventX, float eventY) {
        mPath.moveTo(eventX, eventY);
    }
}

