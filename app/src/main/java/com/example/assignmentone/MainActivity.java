package com.example.assignmentone;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Runs when any of the four topic buttons is clicked.
    // Each button's android:tag holds its position (0-3), so one method
    // can serve all four buttons without any if or switch.
    public void onTopicClick(View view) {
        int topicIndex = Integer.parseInt(view.getTag().toString());

        // Show the matching topic title from arrays.xml as confirmation.
        String[] titles = getResources().getStringArray(R.array.string_array_titles);
        Toast.makeText(this, titles[topicIndex].trim() + " clicked!", Toast.LENGTH_SHORT).show();
    }
}