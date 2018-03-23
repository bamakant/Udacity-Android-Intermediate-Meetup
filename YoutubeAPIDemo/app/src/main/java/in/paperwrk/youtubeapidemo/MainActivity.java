package in.paperwrk.youtubeapidemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

public class MainActivity extends AppCompatActivity {

    // variables
    public static final String API_KEY = "AIzaSyCkl_enaDqw9na3KnpqeYx92wzQiHEyHGA"; //AIzaSyCkl_enaDqw9na3KnpqeYx92wzQiHEyHGA
    Button button;
    private YouTubePlayer.OnInitializedListener monInitializedListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button_play);
        final YouTubePlayerSupportFragment frag =  (YouTubePlayerSupportFragment) getSupportFragmentManager()
                .findFragmentById(R.id.youtube_fragment);


        initPlayer();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frag.initialize("AIzaSyCfXBy8Z9GDpeDnc-dWXMtEpS-0BnpJA4U",monInitializedListener);
            }
        });


    }

    private void initPlayer() {
        monInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("e8nm-EwPpYU");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


}
