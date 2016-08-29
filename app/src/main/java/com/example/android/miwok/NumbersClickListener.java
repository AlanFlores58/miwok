package com.example.android.miwok;

import android.view.View;
import android.widget.Toast;

/**
 * Created by alan_flores on 29/08/16.
 */
public class NumbersClickListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(),"Hola",Toast.LENGTH_LONG).show();
    }
}
