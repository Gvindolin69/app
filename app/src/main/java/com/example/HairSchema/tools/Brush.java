package com.example.HairSchema.tools;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;

import java.util.ArrayList;

public class Brush extends Shape{


    public Brush(ArrayList<Shape> shapes) {
        super(shapes);
    }

    public boolean onTouchEventBrush(MotionEvent event, Paint paint, Canvas canvas, Path path) {
        float touchX = event.getX();
        float touchY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                canvas.drawPath(path, paint);
                shapes.add(this);
                path.reset();
                break;
            default:
                return false;
        }

        return true;
    }
}
