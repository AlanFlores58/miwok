package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.miwok.adapter.WordAdapter;
import com.example.android.miwok.model.Word;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

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


        ArrayList<Word> word = new ArrayList<Word>();
        word.add(new Word("one","lutti"));
        word.add(new Word("two","otiiko"));
        word.add(new Word("Three","tolookosu"));
        word.add(new Word("Four","oyyisa"));
        word.add(new Word("Five","massokka"));
        word.add(new Word("Six","temmokka"));
        word.add(new Word("Seven","kenekaku"));
        word.add(new Word("Eight","kawinta"));
        word.add(new Word("Nine","wo'e"));
        word.add(new Word("Ten","na'aacha"));
        WordAdapter itemsAdapter = new WordAdapter(this,word);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}
