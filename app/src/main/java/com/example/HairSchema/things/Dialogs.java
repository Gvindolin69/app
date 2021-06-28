package com.example.HairSchema.things;

import android.app.Dialog;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.HairSchema.DrawingView;
import com.example.HairSchema.R;

public class Dialogs {
    private static float smallBrush;
    private static float mediumBrush;
    private static float largeBrush;

    public static void initColorDialog(DrawingView view, LinearLayout layout, Dialog dialog){
        ImageButton brownColor = (ImageButton)dialog.findViewById(R.id.brown);
        brownColor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //currPaint=(ImageButton)brownColor;
                String color = brownColor.getTag().toString();
                view.setColor(color);
                layout.setBackgroundColor(view.getColor());
                dialog.dismiss();
            }
        });

        ImageButton redColor = (ImageButton)dialog.findViewById(R.id.red);
        redColor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //currPaint=(ImageButton)brownColor;
                String color = redColor.getTag().toString();
                view.setColor(color);
                layout.setBackgroundColor(view.getColor());
                dialog.dismiss();
            }
        });

        ImageButton orangeColor = (ImageButton)dialog.findViewById(R.id.orange);
        orangeColor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //currPaint=(ImageButton)brownColor;
                String color = orangeColor.getTag().toString();
                view.setColor(color);
                layout.setBackgroundColor(view.getColor());
                dialog.dismiss();
            }
        });

        ImageButton yellowColor = (ImageButton)dialog.findViewById(R.id.yellow);
        yellowColor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //currPaint=(ImageButton)brownColor;
                String color = yellowColor.getTag().toString();
                view.setColor(color);
                layout.setBackgroundColor(view.getColor());
                dialog.dismiss();
            }
        });

        ImageButton greenColor = (ImageButton)dialog.findViewById(R.id.green);
        greenColor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //currPaint=(ImageButton)brownColor;
                String color = greenColor.getTag().toString();
                view.setColor(color);
                layout.setBackgroundColor(view.getColor());
                dialog.dismiss();
            }
        });

        ImageButton blueColor = (ImageButton)dialog.findViewById(R.id.blue);
        blueColor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //currPaint=(ImageButton)brownColor;
                String color = blueColor.getTag().toString();
                view.setColor(color);
                layout.setBackgroundColor(view.getColor());
                dialog.dismiss();
            }
        });

        ImageButton darkBlueColor = (ImageButton)dialog.findViewById(R.id.darkBlue);
        darkBlueColor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //currPaint=(ImageButton)brownColor;
                String color = darkBlueColor.getTag().toString();
                view.setColor(color);
                layout.setBackgroundColor(view.getColor());
                dialog.dismiss();
            }
        });

        ImageButton purpleColor = (ImageButton)dialog.findViewById(R.id.purple);
        purpleColor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //currPaint=(ImageButton)brownColor;
                String color = purpleColor.getTag().toString();
                view.setColor(color);
                layout.setBackgroundColor(view.getColor());
                dialog.dismiss();
            }
        });

        ImageButton pinkColor = (ImageButton)dialog.findViewById(R.id.pink);
        pinkColor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //currPaint=(ImageButton)brownColor;
                String color = pinkColor.getTag().toString();
                view.setColor(color);
                layout.setBackgroundColor(view.getColor());
                dialog.dismiss();
            }
        });

        ImageButton whiteColor = (ImageButton)dialog.findViewById(R.id.white);
        whiteColor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //currPaint=(ImageButton)brownColor;
                String color = whiteColor.getTag().toString();
                view.setColor(color);
                layout.setBackgroundColor(view.getColor());
                dialog.dismiss();
            }
        });

        ImageButton greyColor = (ImageButton)dialog.findViewById(R.id.grey);
        greyColor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //currPaint=(ImageButton)brownColor;
                String color = greyColor.getTag().toString();
                view.setColor(color);
                layout.setBackgroundColor(view.getColor());
                dialog.dismiss();
            }
        });

        ImageButton blackColor = (ImageButton)dialog.findViewById(R.id.black);
        blackColor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //currPaint=(ImageButton)brownColor;
                String color = blackColor.getTag().toString();
                view.setColor(color);
                layout.setBackgroundColor(view.getColor());
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private static void setupBrushes(){
        smallBrush = 3;
        mediumBrush = 5;
        largeBrush = 8;
    }

    //size dialog
    public static void initSizeDialog(DrawingView view, Dialog dialog){
        setupBrushes();
        ImageButton smallBtn = (ImageButton)dialog.findViewById(R.id.small_brush);
        smallBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                view.setBrushSize(smallBrush);
                view.setLastBrushSize(smallBrush);
                dialog.dismiss();
            }
        });

        ImageButton mediumBtn = (ImageButton)dialog.findViewById(R.id.medium_brush);
        mediumBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                view.setBrushSize(mediumBrush);
                view.setLastBrushSize(mediumBrush);
                dialog.dismiss();
            }
        });

        ImageButton largeBtn = (ImageButton)dialog.findViewById(R.id.large_brush);
        largeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                view.setBrushSize(largeBrush);
                view.setLastBrushSize(largeBrush);
                dialog.dismiss();
            }
        });

        dialog.show();
    }


    //heads dialog
    public static void initHeadsDialog(Dialog dialog, DrawingView view){
        ImageButton fullFaceBtn = (ImageButton)dialog.findViewById(R.id.full_face);
        fullFaceBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                view.setBackgroundResource(R.drawable.face);
                dialog.dismiss();
            }
        });
        ImageButton leftFaceBtn = (ImageButton)dialog.findViewById(R.id.left_face);
        leftFaceBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                view.setBackgroundResource(R.drawable.left_side);
                dialog.dismiss();
            }
        });
        ImageButton rightFaceBtn = (ImageButton)dialog.findViewById(R.id.right_face);
        rightFaceBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                view.setBackgroundResource(R.drawable.right_side);
                dialog.dismiss();
            }
        });
        ImageButton aboveFaceBtn = (ImageButton)dialog.findViewById(R.id.face_above);
        aboveFaceBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                view.setBackgroundResource(R.drawable.head_above);
                dialog.dismiss();
            }
        });
        ImageButton napeBtn = (ImageButton)dialog.findViewById(R.id.nape);
        napeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                view.setBackgroundResource(R.drawable.nape);
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}
