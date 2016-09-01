package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.miwok.adapter.WordAdapter;
import com.example.android.miwok.model.Word;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> word = new ArrayList<Word>();
        word.add(new Word("father","әpә"));
        word.add(new Word("mother","әṭa"));
        word.add(new Word("son","angsi"));
        word.add(new Word("daughter","tune"));
        word.add(new Word("older brother","taachi"));
        word.add(new Word("younger brother","chalitti"));
        word.add(new Word("older sister","teṭe"));
        word.add(new Word("younger sister","kolliti"));
        word.add(new Word("grandmother","ama"));
        word.add(new Word("grandfather","paapa"));
        WordAdapter itemsAdapter = new WordAdapter(this,word);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}
