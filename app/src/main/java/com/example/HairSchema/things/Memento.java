package com.example.HairSchema.things;

import android.graphics.Bitmap;
import android.graphics.Canvas;


public class Memento {
    private Bitmap bitmap;

    public Memento(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Bitmap getState(){
        return bitmap;
    }

    public void setState(Bitmap bitmap){
        this.bitmap = bitmap;
    }
}
