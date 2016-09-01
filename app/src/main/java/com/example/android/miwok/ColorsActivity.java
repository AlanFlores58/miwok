package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.miwok.adapter.WordAdapter;
import com.example.android.miwok.model.Word;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> word = new ArrayList<Word>();
        word.add(new Word("red","wetetti"));
        word.add(new Word("green","chokokki"));
        word.add(new Word("brown","takaakki"));
        word.add(new Word("gray","toppopi"));
        word.add(new Word("black","kululli"));
        word.add(new Word("white","kelelli"));
        word.add(new Word("dusty yellow","topiise"));
        word.add(new Word("mustard yellow","chiwiite"));
        WordAdapter itemsAdapter = new WordAdapter(this,word);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}
