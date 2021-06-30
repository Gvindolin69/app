package com.example.HairSchema.tools;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.example.HairSchema.DrawingView;
import com.example.HairSchema.things.Memento;

import java.util.Stack;

public class Undo {
    private DrawingView view;
    private Stack<Canvas> screenShoots;


    public Undo(DrawingView view, Stack<Canvas> screenShoots) {
        this.view = view;
        this.screenShoots = screenShoots;

    }

    public void undo(){
        if(screenShoots.size() > 0){
            screenShoots.pop();
            view.setDrawCanvas(screenShoots.peek());
        }else System.out.println("Stack is empty");

    }
}

