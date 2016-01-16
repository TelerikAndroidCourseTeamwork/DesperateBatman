package com.example.batman.batmanmemegenerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Meme");
        query.getInBackground("jWnsvrDIbs", new GetCallback<ParseObject>() {
            public void done(ParseObject meme, ParseException e) {
                if (e == null) {
                    Toast.makeText(MainActivity.this, meme.get("cat").toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "shit", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
