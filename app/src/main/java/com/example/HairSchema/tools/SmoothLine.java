package com.example.HairSchema.tools;


import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;

public class SmoothLine extends Shape{
    int countTouch = 0;
    float quadX = 0;
    float quadY = 0;

    public boolean onTouchEventSmoothLine(MotionEvent event, Paint paint, Canvas canvas, Path path) {
        float touchX = event.getX();
        float touchY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                this.increaseCountTouch(1);
                if (this.getCountTouch() < 3) {
                    path.moveTo(touchX, touchY);
                    this.setStartX(touchX);
                    this.setStartY(touchY);
                } else {
                    this.setQuadX(touchX);
                    this.setQuadY(touchY);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (this.getCountTouch() < 3) {
                    this.setEndX(touchX);
                    this.setEndY(touchY);
                    path.lineTo(touchX, touchY);
                } else {
                    path.reset();
                    this.setQuadX(touchX);
                    this.setQuadY(touchY);
                    path.moveTo(this.getStartX(), this.getStartY());
                    path.quadTo(this.getQuadX(), this.getQuadY(),
                            this.getEndX(), this.getEndY());
                }
                break;
            case MotionEvent.ACTION_UP:
                this.increaseCountTouch(1);
                if (this.getCountTouch() < 3) {
                    this.setEndX(touchX);
                    this.setEndY(touchY);
                    path.lineTo(touchX, touchY);
                } else {
                    this.setQuadX(touchX);
                    this.setQuadY(touchY);
                    path.moveTo(this.getStartX(), this.getStartY());
                    path.quadTo(this.getQuadX(), this.getQuadY(),
                            this.getEndX(), this.getEndY());
                    canvas.drawPath(path, paint);
                    this.setCountTouch(0);
                    path.reset();
                }

                break;
            default:
                return false;
        }

        return true;
    }

    public int getCountTouch() {
        return countTouch;
    }

    public void setCountTouch(int countTouch) {
        this.countTouch = countTouch;
    }

    public void increaseCountTouch(int countTouch) {
        this.countTouch += countTouch;
    }

    public float getQuadX() {
        return quadX;
    }

    public void setQuadX(float quadX) {
        this.quadX = quadX;
    }

    public float getQuadY() {
        return quadY;
    }

    public void setQuadY(float quadY) {
        this.quadY = quadY;
    }
}
