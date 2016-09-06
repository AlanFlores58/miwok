package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.miwok.adapter.WordAdapter;
import com.example.android.miwok.model.Word;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        final ArrayList<Word> word = new ArrayList<Word>();
        word.add(new Word("red","wetetti",R.drawable.color_red,R.raw.color_red));
        word.add(new Word("green","chokokki",R.drawable.color_green,R.raw.color_green));
        word.add(new Word("brown","takaakki",R.drawable.color_brown,R.raw.color_brown));
        word.add(new Word("gray","toppopi",R.drawable.color_gray,R.raw.color_gray));
        word.add(new Word("black","kululli",R.drawable.color_black,R.raw.color_black));
        word.add(new Word("white","kelelli",R.drawable.color_white,R.raw.color_white));
        word.add(new Word("dusty yellow","topiise",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        word.add(new Word("mustard yellow","chiwiite",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
        WordAdapter itemsAdapter = new WordAdapter(this,word,R.color.category_colors);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        //listView.setBackgroundColor(0x8800A0);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                try {
                    mediaPlayer = MediaPlayer.create(ColorsActivity.this,word.get(position).getIdAudio());
                    mediaPlayer.start();
                    Toast.makeText(ColorsActivity.this,"List item clicked",Toast.LENGTH_SHORT).show();
                }catch (Exception e)
                {
                    Log.v("Erro",e.getMessage());
                }

            }
        });
    }
}
