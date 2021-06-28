package com.example.HairSchema;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;

import android.graphics.PorterDuff;
import android.util.TypedValue;

import androidx.annotation.Nullable;

import com.example.HairSchema.tools.Arrow;
import com.example.HairSchema.tools.Brush;
import com.example.HairSchema.tools.Eraser;
import com.example.HairSchema.tools.Line;
import com.example.HairSchema.tools.Shape;
import com.example.HairSchema.tools.SmoothLine;
import com.example.HairSchema.tools.Undo;

import java.util.Stack;

public class DrawingView extends View {
    //drawing path
    private Path drawPath;
    //drawing and canvas paint
    private Paint drawPaint, canvasPaint;
    //initial color
    private int paintColor = 0xFF000000;
    //canvas
    private Canvas drawCanvas;
    //canvas bitmap
    private Bitmap canvasBitmap;

    private float brushSize, lastBrushSize;

    //tools
    private final Stack<Shape> shapes = new Stack<>();
    private String tool = "default";
    private final Line line = new Line(shapes);
    private final Arrow arrow = new Arrow();
    private final SmoothLine smoothLine = new SmoothLine();
    private final Brush brush = new Brush();
    private final Eraser eraser = new Eraser();


    private Stack<Bitmap> screens;

    public DrawingView(Context context) {
        super(context);
    }

    public DrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setupDrawing();
    }

    public Bitmap makeScreenShoot(){
       return canvasBitmap;
    }

    public void setDrawPaint(){
        drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(20);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
        drawPaint.setStrokeWidth(brushSize);
    }

    public void setupDrawing(){
        drawPath = new Path();
        drawPaint = new Paint();
        this.setDrawPaint();

        canvasPaint = new Paint(Paint.DITHER_FLAG);

        brushSize = getResources().getInteger(R.integer.medium_size);
        lastBrushSize = brushSize;

    }

    public void setTool(String anotherTool){
        tool = anotherTool;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    //view given size
        super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
    //draw view
        canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
        canvas.drawPath(drawPath, drawPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
            //brush
        if (tool.equals("default")) {
            brush.onTouchEventBrush(event, drawPaint, drawCanvas, drawPath);


            //line
        } else if (tool.equals("line")) {
            line.onTouchEventLine(event, drawPaint, drawCanvas, drawPath);


            //doted_line
        } else if (tool.equals("dotedLine")) {
        //TODO::изменить на включения стиля пунктира для всех инстурментов!!(а может и не изменить)
            line.onTouchEventDotedLine(event, drawPaint, drawCanvas, drawPath);


            //arrow
        } else if (tool.equals("arrow")) {
            arrow.onTouchEventArrow(event, drawPaint, drawCanvas, drawPath);


            //smoothLine
        } else if (tool.equals("smoothLine")){
            smoothLine.onTouchEventSmoothLine(event, drawPaint, drawCanvas, drawPath);


            //eraser
        }else if(tool.equals("eraser")){
            eraser.onTouchEventEraser(event, drawPaint, drawCanvas, drawPath, this);

        }
        invalidate();
        return true;
    }

    public void setColor(String newColor){
    //set color
        invalidate();
        paintColor = Color.parseColor(newColor);
        drawPaint.setColor(paintColor);
    }

    public int getColor(){
        return paintColor;
    }

    public void setBrushSize(float newSize){
    //update size
        float pixelAmount = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                newSize, getResources().getDisplayMetrics());
        brushSize=pixelAmount;
        drawPaint.setStrokeWidth(brushSize);
    }
    public void setLastBrushSize(float lastSize){
        lastBrushSize=lastSize;
    }
    public float getLastBrushSize(){
        return lastBrushSize;
    }

    public void startNew(){
        drawCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        invalidate();
    }

    public Stack<Shape> getShapes() {
        return shapes;
    }

    public Paint getDrawPaint() {
        return drawPaint;
    }

    public Canvas getDrawCanvas() {
        return drawCanvas;
    }
}
