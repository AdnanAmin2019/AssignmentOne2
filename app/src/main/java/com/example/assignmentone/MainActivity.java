package com.example.assignmentone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // The key used to pass the chosen topic's position to DetailActivity.
    // A shared constant means both activities use the exact same key.
    public static final String EXTRA_TOPIC_INDEX = "topic_index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Runs when any of the four topic buttons is clicked. The button's
    // android:tag holds its position (0-3), so one method serves all four
    // buttons with no if or switch.
    public void onTopicClick(View view) {
        int topicIndex = Integer.parseInt(view.getTag().toString());

        // Quick confirmation using the matching title from arrays.xml.
        String[] titles = getResources().getStringArray(R.array.string_array_titles);
        Toast.makeText(this, titles[topicIndex].trim() + " clicked!", Toast.LENGTH_SHORT).show();

        // Open the detail screen and tell it which topic to show.
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(EXTRA_TOPIC_INDEX, topicIndex);
        startActivity(intent);
    }
}