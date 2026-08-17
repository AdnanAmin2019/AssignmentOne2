package com.example.assignmentone;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Detail screen. Shows the title, image, and description for the
 * topic that was selected on the main screen.
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // The three views we need to fill in.
        ImageView topicImage = findViewById(R.id.detail_image);
        TextView titleText = findViewById(R.id.detail_title);
        TextView contentText = findViewById(R.id.detail_content);

        // Load all three arrays from arrays.xml.
        String[] titles = getResources().getStringArray(R.array.string_array_titles);
        String[] contents = getResources().getStringArray(R.array.string_array_content);
        String[] imageNames = getResources().getStringArray(R.array.string_array_images);

        // Which topic did the user pick? MainActivity sent its position.
        int topicIndex = getIntent().getIntExtra(MainActivity.EXTRA_TOPIC_INDEX, 0);

        // Set the title and content (trim removes the spare spaces in arrays.xml).
        titleText.setText(titles[topicIndex].trim());
        contentText.setText(contents[topicIndex].trim());

        // The array stores an image NAME like "img_cs". Turn that name into
        // its drawable resource id, then show it. This avoids any if or switch.
        String imageName = imageNames[topicIndex].trim();
        int imageId = getResources().getIdentifier(imageName, "drawable", getPackageName());
        topicImage.setImageResource(imageId);
    }
}