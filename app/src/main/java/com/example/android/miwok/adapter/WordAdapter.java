package com.example.android.miwok.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.miwok.R;
import com.example.android.miwok.model.Word;

import java.util.ArrayList;

/**
 * Created by alan_flores on 30/08/16.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();

    public WordAdapter(Activity context, ArrayList<Word> words){
        super(context,0,words);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        Word currentWord = getItem(position);

        TextView text1 = (TextView) listItemView.findViewById(R.id.text1);
        text1.setText(currentWord.getEnglish());

        TextView text2 = (TextView) listItemView.findViewById(R.id.text2);
        text2.setText(currentWord.getMiwoz());


        return listItemView;
    }
}
