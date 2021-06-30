package com.example.HairSchema.tools;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.MotionEvent;

import com.example.HairSchema.DrawingView;

import java.util.ArrayList;

public class Eraser extends Shape{


    public Eraser(ArrayList<Shape> shapes) {
        super(shapes);
    }

    public boolean onTouchEventEraser(MotionEvent event, Paint paint, Canvas canvas, Path path, DrawingView view) {
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
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                canvas.drawPath(path, paint);
                paint.setXfermode(null);
                path.reset();
                break;
            default:
                return false;
        }
        return true;
    }
}
