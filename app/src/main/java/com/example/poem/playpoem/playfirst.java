package com.example.poem.playpoem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.poem.MainActivity;
import com.example.poem.R;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class playfirst extends AppCompatActivity {
    VideoView videoView;
    Uri uri;
    MediaPlayer md;
    ImageView back;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playfirst);
        b1 =(Button)findViewById(R.id.b1);
        back= (ImageView)findViewById(R.id.back);
        videoView = (VideoView) findViewById(R.id.video);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sweetalertfunction();
            }
        });

MediaPlayer mp = new MediaPlayer();
        MediaController mediaController = new MediaController(playfirst.this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playFunction();




            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // call function
                backfunction();
            }
        });




    }
    public void backfunction()
    {
        // intent code
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(myIntent);
    }
    public void playFunction()
    {
        uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.poem);
        videoView.setVideoURI(uri);
        videoView.start();




    }
    public void sweetalertfunction(){
        new SweetAlertDialog(playfirst.this,SweetAlertDialog.SUCCESS_TYPE)
        .setTitleText("Do you Want to Play Video Again?")
                .setConfirmText("yes")
        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog s) {
                s.dismissWithAnimation();
                playFunction();
            }
        })
                .setCancelText("No")
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismissWithAnimation();
                        backfunction();
                    }
                }).show();

}

}