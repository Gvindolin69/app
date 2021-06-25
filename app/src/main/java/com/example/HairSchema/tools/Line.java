package com.example.HairSchema.tools;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;

public class Line extends Shape{
    //for doted line
    private float[] dots = {50, 50};
    public float[] getDots() {
        return dots;
    }

    public boolean onTouchEventLine(MotionEvent event, Paint paint, Canvas canvas, Path path) {
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
                canvas.drawLine(this.getStartX(), this.getStartY(), this.getEndX(), this.getEndY(), paint);
                path.reset();
                break;
            default:
                return false;
        }
        return true;
    }

    public boolean onTouchEventDotedLine(MotionEvent event, Paint paint, Canvas canvas, Path path) {
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
                paint.setPathEffect(new DashPathEffect(this.getDots(), 0));
                canvas.drawLine(this.getStartX(), this.getStartY(), this.getEndX(), this.getEndY(),
                        paint);
                path.reset();
                paint.setPathEffect(null);
                break;
            default:
                return false;
        }
        return true;
    }
}
