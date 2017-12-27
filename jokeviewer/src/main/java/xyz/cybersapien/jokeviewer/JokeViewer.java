package xyz.cybersapien.jokeviewer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeViewer extends AppCompatActivity {

    private String jokeMessage;
    public static final String JOKE_MESSAGE = "joke";

    public static Intent getIntent(Context context, String jokeMessage) {
        Intent intent = new Intent(context, JokeViewer.class);
        intent.putExtra(JOKE_MESSAGE, jokeMessage);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_viewer);

        if (savedInstanceState == null) {
            Intent intent = getIntent();
            if (intent != null) {
                jokeMessage = intent.getStringExtra(JOKE_MESSAGE);
            } else {
                throw new IllegalArgumentException("Activity must contain intent");
            }
        } else {
            jokeMessage = savedInstanceState.getString(JOKE_MESSAGE);
        }

        TextView jokeTextView = findViewById(R.id.joke_text_view);
        jokeTextView.setText(jokeMessage);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(JOKE_MESSAGE, jokeMessage);
    }
}
