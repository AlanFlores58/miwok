package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.miwok.adapter.WordAdapter;
import com.example.android.miwok.model.Word;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        /*String[] words = new String[]{"one","two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};
        for(int i=0;i<10;i++)
            Log.v("Numbers activity",words[i]);*/

        /*ArrayList<String> words2 = new ArrayList<String>();
        //LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);

        words2.add("one");
        words2.add("two");
        words2.add("Three");
        words2.add("Four");
        words2.add("Five");
        words2.add("Six");
        words2.add("Seven");
        words2.add("Eight");
        words2.add("Nine");
        words2.add("Ten");
        for (String letter:
                words2) {

            TextView textView = new TextView(this);
            textView.setText(letter);
            rootView.addView(textView);
        }*/

        //ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words2);
        /*GridView gridView = (GridView) findViewById(R.id.list);
        gridView.setAdapter(itemsAdapter);*/
        /*ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, R.layout.list_item, words2);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);*/


        final ArrayList<Word> word = new ArrayList<Word>();
        word.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        word.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        word.add(new Word("Three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        word.add(new Word("Four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        word.add(new Word("Five", "massokka", R.drawable.number_five, R.raw.number_five));
        word.add(new Word("Six", "temmokka", R.drawable.number_six, R.raw.number_six));
        word.add(new Word("Seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        word.add(new Word("Eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        word.add(new Word("Nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        word.add(new Word("Ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));
        WordAdapter itemsAdapter = new WordAdapter(this, word, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    releaseMediaPlayer();
                    int result = audioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                        mediaPlayer = MediaPlayer.create(NumbersActivity.this, word.get(position).getIdAudio());
                        mediaPlayer.start();

                        //one way
                        /*mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){

                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer){
                                releaseMediaPlayer();
                            }
                        });*/
                        mediaPlayer.setOnCompletionListener(onCompletionListener);
                        //Log.v("NumbersActivity","Current word: " + word.get(position));
                        //Toast.makeText(NumbersActivity.this,"List item clicked",Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Log.v("Erro", e.getMessage());
                }

            }
        });
    }

    @Override
    protected void onStop() {
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

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}
