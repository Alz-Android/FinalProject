package com.example;

import java.util.Random;

public class JokeWizard {
    public JokeWizard() {
    }

    public String getJoke() {
        String [] Jokes = new String[]{"joke1", "joke2", "joke3", "joke4"};
        Random random = new Random();
        int randomJokeNumber = random.nextInt(4);
        return(Jokes[randomJokeNumber]);
    }
}
