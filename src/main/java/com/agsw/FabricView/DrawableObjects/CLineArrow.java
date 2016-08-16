package com.agsw.FabricView.DrawableObjects;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;

/**
 * Created by ekino on 8/15/16.
 */
// TODO: 8/15/16 Line Arrow support PointF
public class CLineArrow extends CLine {

    public CLineArrow(int xOrigin, int yOrigin, int xDest, int yDest, Paint p) {
        super(xOrigin, yOrigin, xDest, yDest, p);
    }

    @Override
    public void draw(Canvas canvas) {

        if (getXcoords() + getYcoords() + getXdest() + getYdest() == 0) {
            return;
        }

        Paint p = new Paint(getPaint());
        p.setStyle(Paint.Style.FILL);

        canvas.drawLine(getXcoords(), getYcoords(), getXdest(), getYdest(), getPaint());
        canvas.drawPath(getArrowPath(new PointF(getXcoords(), getYcoords()), new PointF(getXdest(), getYdest())), p);
    }

    private Path getArrowPath(PointF start, PointF stop) {
        float dx, dy;
        PointF p1, p2;
        Path auxPath = new Path();

        dx = stop.x - start.x;
        dy = stop.y - start.y;

        float length = (float) Math.sqrt(dx * dx + dy * dy);

        float unitDx = dx / length;
        float unitDy = dy / length;

        final int arrowSize = (int) getPaint().getStrokeWidth();

        p1 = new PointF(stop.x - unitDx * arrowSize - unitDy * arrowSize, stop.y - unitDy * arrowSize + unitDx * arrowSize);
        p2 = new PointF(stop.x - unitDx * arrowSize + unitDy * arrowSize, stop.y - unitDy * arrowSize - unitDx * arrowSize);

        // normalize vector to range [0:1]
        float vx = dx / 1.f;
        float vy = dy / 1.f;

        final float tailSize = 0.1f;

        auxPath.moveTo(stop.x + tailSize * vx, stop.y + tailSize * vy);
        auxPath.lineTo(p1.x, p1.y);
        auxPath.lineTo(stop.x, stop.y);

        auxPath.moveTo(stop.x + tailSize * vx, stop.y + tailSize * vy);
        auxPath.lineTo(p2.x, p2.y);
        auxPath.lineTo(stop.x, stop.y);

        auxPath.close();

        return auxPath;
    }
}
