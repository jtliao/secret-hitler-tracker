package com.jtliao.secrethitlertracker;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;

import java.util.HashMap;
import java.util.Locale;

import static android.os.SystemClock.sleep;

public class GameIntro extends AppCompatActivity {

    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_intro);
    }

    public void playIntro(View view) {
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            int numPlayers = (Integer) getIntent().getSerializableExtra(GameSetup.EXTRA);

            @Override
            public void onInit(int status) {
                String introText = "Everybody close your eyes. ";
                String endText;
                int sleepTime;
                if(numPlayers < 7) {
                    introText += "Fascist and Hitler open your eyes and acknowledge each other.";
                    endText = "Everyone close their eyes. Now, everyone open their eyes.";
                    sleepTime = 10000;
                }
                else {
                    introText += "Extend your hand into a fist in front of you. " +
                            "Hitler, put your thumb up. Fascists open your eyes and acknowledge " +
                            "each other and Hitler. ";
                    endText = "Everyone close their eyes and put their thumbs down. " +
                            "Now, everyone open their eyes.";
                    sleepTime = 16000;
                }

                if(status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.US);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        ttsGreater21(introText);
                        sleep(sleepTime);
                        ttsGreater21(endText);
                    } else {
                        ttsUnder20(introText);
                        sleep(sleepTime);
                        ttsUnder20(endText);
                    }
                }
            }
        });
    }

    public void goNext (View view) {
        Intent i = new Intent(this, GameHome.class);
        startActivity(i);
    }

    @SuppressWarnings("deprecation")
    private void ttsUnder20(String text) {
        HashMap<String, String> map = new HashMap<>();
        map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "MessageId");
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, map);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void ttsGreater21(String text) {
        String utteranceId=this.hashCode() + "";
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId);
    }
}
