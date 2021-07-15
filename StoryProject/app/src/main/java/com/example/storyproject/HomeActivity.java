 package com.example.storyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Locale;

public class HomeActivity extends AppCompatActivity {
    Button playPause;
    TextView cnt;
    TextToSpeech textToSpeech;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        playPause=findViewById(R.id.play);
        cnt=findViewById(R.id.content);
        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                

                    if (status==textToSpeech.SUCCESS){
                        int lang=textToSpeech.setLanguage(Locale.ENGLISH);
                    }



                    }







        });
            playPause.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String s = cnt.getText().toString();
                    int speech = textToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                    Toast.makeText(HomeActivity.this, "Go Back,To stop the audio", Toast.LENGTH_SHORT).show();
                }

            });







    }
    public void onPause(){
        if (textToSpeech!=null){
            textToSpeech.stop();
            textToSpeech.shutdown();

        }
        super.onPause();
    }

    }

