package com.udacity.gradle.builditbigger.free;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.al.androidjokes.AndroidJokes;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){

        String resultJoke="";

        EndpointsAsyncTask asyncGetJOke = new EndpointsAsyncTask();
        try {
            resultJoke = asyncGetJOke.execute(new Pair<Context, String>(this, "")).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Log.i("appMain", "AndoidLib");
        Intent jokeIntent = new Intent(this, AndroidJokes.class);
        jokeIntent.putExtra("jokeExtra", resultJoke);
        startActivity(jokeIntent);

     //   Toast.makeText(this, resultJoke, Toast.LENGTH_SHORT).show();
    }

}
