package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.miwok.adapter.WordAdapter;
import com.example.android.miwok.model.Word;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> word = new ArrayList<Word>();
        word.add(new Word("Where are you going?","minto wuksus"));
        word.add(new Word("What is your name?","tinnә oyaase'nә"));
        word.add(new Word("My name is...","oyaaset..."));
        word.add(new Word("How are you feeling?","michәksәs?"));
        word.add(new Word("I’m feeling good.","kuchi achit"));
        word.add(new Word("Are you coming?","әәnәs'aa?"));
        word.add(new Word("Yes, I’m coming.","hәә’ әәnәm"));
        word.add(new Word("I’m coming.","әәnәm"));
        word.add(new Word("Let’s go.","ama"));
        word.add(new Word("Come here.","әnni'nem"));
        WordAdapter itemsAdapter = new WordAdapter(this,word,R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}
