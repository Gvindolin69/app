package com.example.HairSchema.things;


import android.graphics.Bitmap;

import com.example.HairSchema.DrawingView;

public class ScreenThread extends Thread {
    private final DrawingView view;


    public ScreenThread(DrawingView view, Bitmap bitmap) {
        this.view = view;

    }


    @Override
    public void run() {
        while (true) {
            System.out.println(view.getScreens());
            }
        }

}
