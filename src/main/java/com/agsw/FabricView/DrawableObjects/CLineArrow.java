package com.agsw.FabricView.DrawableObjects;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;

/**
 * Created by Nguyen Hoang Anh Nguyen on 8/15/16.
 */
public class CLineArrow extends CLine {

    public CLineArrow(int xOrigin, int yOrigin, int xDest, int yDest, Paint p) {
        super(xOrigin, yOrigin, xDest, yDest, p);
    }

    @Override
    public void draw(Canvas canvas) {

        if (getXcoords() + getYcoords() + getXdest() + getYdest() == 0) {
            return;
        }

        canvas.drawLine(getXcoords(), getYcoords(), getXdest(), getYdest(), getPaint());
        Path arrowPath = getArrowPath(new PointF(getXcoords(), getYcoords()), new PointF(getXdest(), getYdest()));
        if (arrowPath != null) {
            canvas.drawPath(arrowPath, getPaint());
        }
    }

    private Path getArrowPath(PointF start, PointF stop) {
        Path path = new Path();

        float dx = stop.x - start.x;
        float dy = stop.y - start.y;

        if (dx + dy == 0) {
            return null;
        }

        float length = (float) Math.sqrt(dx * dx + dy * dy);

        float unitDx = dx / length;
        float unitDy = dy / length;

        final int arrowSize = (int) getPaint().getStrokeWidth() * 2;

        PointF p1 = new PointF(stop.x - unitDx * arrowSize - unitDy * arrowSize, stop.y - unitDy * arrowSize + unitDx * arrowSize);
        PointF p2 = new PointF(stop.x - unitDx * arrowSize + unitDy * arrowSize, stop.y - unitDy * arrowSize - unitDx * arrowSize);

        // normalize vector to range [0:1]
        PointF vector = normalize(new PointF(dx, dy));

        final float tailSize = getPaint().getStrokeWidth() * 2;

        path.moveTo(stop.x + tailSize * vector.x, stop.y + tailSize * vector.y);
        path.lineTo(p1.x, p1.y);
        path.lineTo(stop.x, stop.y);
        path.lineTo(p2.x, p2.y);
        path.close();

        return path;
    }

    private PointF normalize(PointF point) {
        float v = (float) Math.sqrt(point.x * point.x + point.y * point.y);
        return new PointF(point.x / v, point.y / v);
    }
}
