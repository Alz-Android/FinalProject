package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.content.Context;
import android.test.ApplicationTestCase;
import android.util.Pair;

import java.util.concurrent.ExecutionException;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);

        String resultJoke="";

        EndpointsAsyncTask asyncGetJOke = new EndpointsAsyncTask();
        try {
            resultJoke = asyncGetJOke.execute(new Pair<Context, String>(this.getContext(), "")).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        assertNotNull("Joke Not Found", resultJoke);
    }
}