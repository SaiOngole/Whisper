package com.is3av.whisper;

import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class MainActivity extends ActionBarActivity  {
    private Button button;
    private TextView tv;
    private MediaRecorder myAudioRecorder;
    private String outputFile = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setText("Start");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button.getText().equals("Start")) {
                    button.setText("Stop");
                    // Start recording here
                    try {
                        myAudioRecorder.prepare();
                        myAudioRecorder.start();
                    } catch (IllegalStateException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    Toast.makeText(getApplicationContext(), "Recording started", Toast.LENGTH_LONG).show();
                }
                else {
                    button.setText("Start");
                    // save the file here
                    myAudioRecorder.stop();
                    myAudioRecorder.release();
                    myAudioRecorder  = null;
                    Toast.makeText(getApplicationContext(), "Audio recorded successfully",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        outputFile = (Environment.getExternalStorageDirectory().getAbsolutePath()).toString() + File.separator + "recording.mp4";

        myAudioRecorder = new MediaRecorder();


    }



    public void stop(View view){

    }

}
