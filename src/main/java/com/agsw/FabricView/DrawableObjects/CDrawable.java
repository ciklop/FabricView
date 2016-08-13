package com.agsw.FabricView.DrawableObjects;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by antwan on 10/3/2015.
 */
public interface CDrawable {
    Paint getPaint();

    void setPaint(Paint p);

    int getXcoords();

    void setXcoords(int x);

    int getYcoords();

    void setYcoords(int y);

    void draw(Canvas canvas);

    int getRotation();

    void setRotation(int degree);
}
