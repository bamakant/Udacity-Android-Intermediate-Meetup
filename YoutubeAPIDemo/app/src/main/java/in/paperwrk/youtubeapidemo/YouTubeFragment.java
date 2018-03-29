package com.kiu.example.youtubeapi;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

public class YouTubeFragment extends Fragment {

    private final String API_KEY = "AIzaSyDg43L3BeYoTDqcOzxuZZaG7GE1B4oS_TA";

    //Youtube Listenr
    private YouTubePlayer.OnInitializedListener onInitializedListener;
    //declare view
    YouTubePlayerSupportFragment fragment;
    Button play;

    public YouTubeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout f1or this fragment
        return inflater.inflate(R.layout.fragment_youtube, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        fragment = (YouTubePlayerSupportFragment) getChildFragmentManager()
                .findFragmentById(R.id.youtube_player);
        play = view.findViewById(R.id.play_btn);

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
                Toast.makeText(getActivity(), "Error: Can't load the video.", Toast.LENGTH_SHORT).show();
            }
        };
    }

    private void playView() {
        fragment.initialize(API_KEY,onInitializedListener);
    }
}
