package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        /*String[] words = new String[]{"one","two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};
        for(int i=0;i<10;i++)
            Log.v("Numbers activity",words[i]);*/

        ArrayList<String> words2 = new ArrayList<String>();
        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);

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
        }
    }
}
