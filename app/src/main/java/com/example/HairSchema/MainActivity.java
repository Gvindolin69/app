package com.example.HairSchema;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.UUID;
import android.provider.MediaStore;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.example.HairSchema.things.Dialogs;
import com.example.HairSchema.things.ScreenThread;


public class MainActivity extends AppCompatActivity implements OnClickListener {
    private LinearLayout paintLayout;
    private DrawingView drawView;
    private Bitmap screenShoot;
    private ArrayList<Bitmap> screenShoots;

    //init buttons
    private void setupButtons(){
        ImageButton drawBtn = (ImageButton) findViewById(R.id.draw_btn);
        drawBtn.setOnClickListener(this);

        ImageButton eraseBtn = (ImageButton) findViewById(R.id.erase_btn);
        eraseBtn.setOnClickListener(this);

        ImageButton newBtn = (ImageButton) findViewById(R.id.new_btn);
        newBtn.setOnClickListener(this);

        ImageButton saveBtn = (ImageButton) findViewById(R.id.save_btn);
        saveBtn.setOnClickListener(this);

        ImageButton lineBtn = (ImageButton) findViewById(R.id.line_btn);
        lineBtn.setOnClickListener(this);

        ImageButton dotedLineBtn = (ImageButton) findViewById(R.id.doted_line_btn);
        dotedLineBtn.setOnClickListener(this);

        ImageButton paletteBtn = (ImageButton) findViewById(R.id.palette_btn);
        paletteBtn.setOnClickListener(this);

        ImageButton arrowBtn = (ImageButton) findViewById(R.id.arrow_btn);
        arrowBtn.setOnClickListener(this);

        ImageButton smoothLineBtn = (ImageButton) findViewById(R.id.smoothLine_btn);
        smoothLineBtn.setOnClickListener(this);

        ImageButton brushSizeBtn = (ImageButton) findViewById(R.id.brush_size_btn);
        brushSizeBtn.setOnClickListener(this);

        ImageButton headBtn = (ImageButton) findViewById(R.id.head_btn);
        headBtn.setOnClickListener(this);

    }

    //button actions
    @Override
    public void onClick(View view) {
        //respond to clicks
        if (view.getId() == R.id.draw_btn) {
            //draw button clicked
            drawView.setTool("default");

        } else if (view.getId() == R.id.brush_size_btn) {

            Dialog brushSizeDialog = new Dialog(this);
            brushSizeDialog.setTitle("SizeDialog");
            brushSizeDialog.setContentView(R.layout.brush_chooser);
            Dialogs.initSizeDialog(drawView, brushSizeDialog);

        } else if (view.getId() == R.id.palette_btn) {

            Dialog colorsDialog = new Dialog(this);
            colorsDialog.setTitle("Colors:");
            colorsDialog.setContentView(R.layout.color_choser);
            Dialogs.initColorDialog(drawView, paintLayout, colorsDialog);

        }else if(view.getId() == R.id.head_btn){

            Dialog headsDialog = new Dialog(this);
            headsDialog.setTitle("Heads:");
            headsDialog.setContentView(R.layout.head_chooser);
            Dialogs.initHeadsDialog(headsDialog, drawView);

        }else if(view.getId()==R.id.line_btn){
            drawView.setTool("line");

        }else if(view.getId()==R.id.doted_line_btn){
            drawView.setTool("dotedLine");

        }else if(view.getId()==R.id.arrow_btn){
            drawView.setTool("arrow");

        }else if(view.getId()==R.id.smoothLine_btn) {
            drawView.setTool("smoothLine");

        }else if(view.getId()==R.id.erase_btn){
            drawView.setTool("eraser");

        }else if(view.getId()==R.id.new_btn){
            //new button
            AlertDialog.Builder newDialog = new AlertDialog.Builder(this);
            newDialog.setTitle("New drawing");
            newDialog.setMessage("Start new drawing (you will lose the current drawing)?");
            newDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which){
                    drawView.startNew();
                    dialog.dismiss();
                }
            });
            newDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which){
                    dialog.cancel();
                }
            });
            newDialog.show();
        }else if(view.getId()==R.id.save_btn){
            //save drawing
            AlertDialog.Builder saveDialog = new AlertDialog.Builder(this);
            saveDialog.setTitle("Save drawing");
            saveDialog.setMessage("Save drawing to device Gallery?");
            saveDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which){
                    //save drawing
                    drawView.setDrawingCacheEnabled(true);
                    String imgSaved = MediaStore.Images.Media.insertImage(
                            getContentResolver(), drawView.getDrawingCache(),
                            UUID.randomUUID().toString()+".png", "drawing");
                    if(imgSaved!=null){
                        Toast savedToast = Toast.makeText(getApplicationContext(),
                                "Drawing saved to Gallery!", Toast.LENGTH_SHORT);
                        savedToast.show();
                    }
                    else{
                        Toast unsavedToast = Toast.makeText(getApplicationContext(),
                                "Oops! Image could not be saved.", Toast.LENGTH_SHORT);
                        unsavedToast.show();
                    }
                    drawView.destroyDrawingCache();
                }
            });
            saveDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which){
                    dialog.cancel();
                }
            });
            saveDialog.show();
        }

    }

    //app start
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //buttons
        setupButtons();

        //canvas for drawing
        drawView = (DrawingView)findViewById(R.id.drawing);

        //brushes and default brush size
        drawView.setBrushSize(getResources().getInteger(R.integer.small_size));

        //current color window
        paintLayout = (LinearLayout)findViewById(R.id.current_color);
        paintLayout.setBackgroundColor(drawView.getColor());



        ScreenThread screenThread = new ScreenThread(drawView, screenShoot);
        screenThread.setDaemon(true);
        screenThread.start();


    }




}