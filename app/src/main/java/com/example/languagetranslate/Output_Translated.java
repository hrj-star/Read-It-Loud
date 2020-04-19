package com.example.languagetranslate;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.text.method.ScrollingMovementMethod;
import android.speech.tts.TextToSpeech;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;


import java.util.Locale;

public class Output_Translated extends AppCompatActivity {
    TextView outputTextView;
    private TextToSpeech textToSpeech;
    private String outputstring;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output__translated);
        Button speakout = findViewById(R.id.speakbtn);


        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                textToSpeech.setLanguage(new Locale("hi"));
            }
        });
        outputTextView = findViewById(R.id.translatedText);
        outputTextView.setMovementMethod(new ScrollingMovementMethod());
       outputstring=getIntent().getExtras().getString("text");

        outputTextView.setText(outputstring);
        speakout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                textToSpeech.speak(outputstring, TextToSpeech.QUEUE_FLUSH,null, null);
            }
        });





    }

}
