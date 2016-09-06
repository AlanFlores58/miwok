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
        word.add(new Word(R.raw.phrase_where_are_you_going,"Where are you going?","minto wuksus"));
        word.add(new Word(R.raw.phrase_what_is_your_name,"What is your name?","tinnә oyaase'nә"));
        word.add(new Word(R.raw.phrase_my_name_is,"My name is...","oyaaset..."));
        word.add(new Word(R.raw.phrase_how_are_you_feeling,"How are you feeling?","michәksәs?"));
        word.add(new Word(R.raw.phrase_im_feeling_good,"I’m feeling good.","kuchi achit"));
        word.add(new Word(R.raw.phrase_are_you_coming,"Are you coming?","әәnәs'aa?"));
        word.add(new Word(R.raw.phrase_yes_im_coming,"Yes, I’m coming.","hәә’ әәnәm"));
        word.add(new Word(R.raw.phrase_im_coming,"I’m coming.","әәnәm"));
        word.add(new Word(R.raw.phrase_lets_go,"Let’s go.","ama"));
        word.add(new Word(R.raw.phrase_come_here,"Come here.","әnni'nem"));
        WordAdapter itemsAdapter = new WordAdapter(this,word,R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}
