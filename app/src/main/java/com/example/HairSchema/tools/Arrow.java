package com.example.HairSchema.tools;


import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;

import java.util.ArrayList;

public class Arrow extends Shape {
    private final float radius = 50;
    private final float angle = 30;

    public Arrow(ArrayList<Shape> shapes) {
        super(shapes);
    }

    public void drawArrow(Paint paint, Canvas canvas, float from_x, float from_y, float to_x, float to_y) {
        float anglerad, lineangle;
        // some angle calculations
        anglerad = (float) (Math.PI * angle / 180.0f);
        lineangle = (float) (Math.atan2(to_y - from_y, to_x - from_x));
        // tha line
        canvas.drawLine(from_x, from_y, to_x, to_y, paint);
        // tha triangle
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(to_x, to_y);
        path.lineTo((float) (to_x - radius * Math.cos(lineangle - (anglerad / 2.0))), (float) (to_y - radius * Math.sin(lineangle - (anglerad / 2.0))));
        path.lineTo((float) (to_x - radius * Math.cos(lineangle + (anglerad / 2.0))), (float) (to_y - radius * Math.sin(lineangle + (anglerad / 2.0))));
        path.close();
        canvas.drawPath(path, paint);
    }


    public boolean onTouchEventArrow(MotionEvent event, Paint paint, Canvas canvas, Path path) {
        float touchX = event.getX();
        float touchY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(touchX, touchY);
                this.setStartX(touchX);
                this.setStartY(touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(touchX, touchY);
                this.setEndX(touchX);
                this.setEndY(touchY);
                break;
            case MotionEvent.ACTION_UP:
                this.drawArrow(paint, canvas, this.getStartX(), this.getStartY(), this.getEndX(), this.getEndY());
                path.reset();
                break;
            default:
                return false;
        }

        return true;
    }
}
