package com.example.al.androidjokes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class AndroidJokes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_jokes);

        Intent intent = getIntent();
        String joke = intent.getStringExtra("jokeExtra");
        displayJoke(joke);
    }


    public void displayJoke(String joke){

        TextView textViewJoke = (TextView) findViewById(R.id.jokeBox);
        textViewJoke.setText(joke);
    }

//    @Override
//    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
//         //super.onCreateView(parent, name, context, attrs);
//
//
//
//        Intent intent = getIntent();
//        String joke = intent.getStringExtra("jokeExtra");
//
//        View textViewJoke = (TextView) findViewById(R.id.jokeBox);
//        textViewJoke. setText(joke);
//
//        return textViewJoke;
//    }
}
