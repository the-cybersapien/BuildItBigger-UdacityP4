package xyz.cybersapien.jokeprovider;

import java.util.Random;

public class JokeProvider {

    private static final String[] jokes = new String[]{
            "A lot of people cry when they cut onions. The trick is not to form an emotional bond.",
            "How does a train eat? It cheww chewws!!",
            "The missing sailor was a little too into swabbing the deck. I think he went Overboard!",
            "Who designed king arthur's round table? Sir Cumference!",
            "All pro athletes are bilingual. They speak English and profanity",
            "I bought one of those tapes to teach you Spanish in your sleep. During the night, " +
                    "the tap skipped. Now I can only stutter in Spanish.",
            "Instagram is just Twitter for people who go outside!",
            "There is nothing more awkward than the moment you realize you're getting a double-cheek kiss.",
            "You'll never be as lazy as whoever named the fireplace!",
            "Bifocals are God's way of saying, \"Keep your chin up.\"",
            "\"Just because you can’t dance doesn’t mean you shouldn’t dance.\" \u2028—Alcohol",
            "Try an internship! Internships give you all the experience of a summer job without the hassle of a paycheck."
    };

    private static final Random randomizer = new Random();

    public static String getJoke() {
        int newNumber = randomizer.nextInt(jokes.length - 1);
        return jokes[newNumber];
    }

}
