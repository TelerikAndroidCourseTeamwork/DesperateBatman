package com.example.batman.batmanmemegenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.enableLocalDatastore(this);
        Parse.initialize(this);
    }

    public void goToGallery(View view) {
        Intent intent = new Intent(this, ChooseMemeActivity.class);
        startActivity(intent);
    }

    public void goToCapture(View view) {
        Intent intent = new Intent(this, TakeAPictureActivity.class);
        startActivity(intent);
    }

    public void goToMemeGeneration(View view) {
        Intent intent = new Intent(this, GenerateMemeActivity.class);
        startActivity(intent);
    }
}
