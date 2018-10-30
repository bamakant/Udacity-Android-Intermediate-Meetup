package com.kiu.example.youtubeapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

public class MainActivity extends AppCompatActivity {

    private final String API_KEY = "AIzaSyDg43L3BeYoTDqcOzxuZZaG7GE1B4oS_TA";

    //Youtube Listenr
    private YouTubePlayer.OnInitializedListener onInitializedListener;
    //declare view
    YouTubePlayerSupportFragment fragment;
    Button play,frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment = (YouTubePlayerSupportFragment) getSupportFragmentManager()
                .findFragmentById(R.id.youtube_player);

        play = findViewById(R.id.play_btn);
        frag = findViewById(R.id.frag_btn);

        frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,FragmentActivity.class));
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playView();
            }
        });

        initPlayer();


    }

    private void initPlayer() {
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("D7w-v0zbV10");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(MainActivity.this, "Error: Can't load the video.", Toast.LENGTH_SHORT).show();
            }
        };
    }

    private void playView() {
        fragment.initialize(API_KEY,onInitializedListener);
    }
}
