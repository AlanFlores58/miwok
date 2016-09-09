package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.miwok.adapter.WordAdapter;
import com.example.android.miwok.model.Word;

import java.util.ArrayList;

/**
 * Created by alan_flores on 9/09/16.
 */
public class PhrasesFragment extends Fragment{
    private MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    private AudioManager audioManager;

    AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        mediaPlayer.pause();
                        mediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        mediaPlayer.start();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        releaseMediaPlayer();
                    }
                }
            };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container,false);
        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
        final ArrayList<Word> word = new ArrayList<Word>();
        word.add(new Word(R.raw.phrase_where_are_you_going, "Where are you going?", "minto wuksus"));
        word.add(new Word(R.raw.phrase_what_is_your_name, "What is your name?", "tinnә oyaase'nә"));
        word.add(new Word(R.raw.phrase_my_name_is, "My name is...", "oyaaset..."));
        word.add(new Word(R.raw.phrase_how_are_you_feeling, "How are you feeling?", "michәksәs?"));
        word.add(new Word(R.raw.phrase_im_feeling_good, "I’m feeling good.", "kuchi achit"));
        word.add(new Word(R.raw.phrase_are_you_coming, "Are you coming?", "әәnәs'aa?"));
        word.add(new Word(R.raw.phrase_yes_im_coming, "Yes, I’m coming.", "hәә’ әәnәm"));
        word.add(new Word(R.raw.phrase_im_coming, "I’m coming.", "әәnәm"));
        word.add(new Word(R.raw.phrase_lets_go, "Let’s go.", "ama"));
        word.add(new Word(R.raw.phrase_come_here, "Come here.", "әnni'nem"));
        WordAdapter itemsAdapter = new WordAdapter(getActivity(), word, R.color.category_phrases);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    releaseMediaPlayer();
                    int result = audioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                        mediaPlayer = MediaPlayer.create(getActivity(), word.get(position).getIdAudio());
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(onCompletionListener);
                    }
                } catch (Exception e) {
                    Log.v("Erro", e.getMessage());
                }

            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            audioManager.abandonAudioFocus(onAudioFocusChangeListener);
        }
    }
}
