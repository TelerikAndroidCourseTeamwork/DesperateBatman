package com.example.batman.batmanmemegenerator;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GenerateMemeActivity extends AppCompatActivity {
    private static Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_meme);
        Intent intent = getIntent();
        bitmap = (Bitmap) intent.getParcelableExtra("BitmapImage");
        BitmapDrawable drawable = new BitmapDrawable(bitmap);
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.canvas);
        layout.setBackgroundDrawable(drawable);
    }

    public void onMemeTextUpdate(View view){
        EditText topEdit = (EditText)findViewById(R.id.topTextInput);
        EditText bottomEdit = (EditText)findViewById(R.id.bottomTextInput);

        TextView topText = (TextView)findViewById(R.id.topText);
        topText.setText(topEdit.getText().toString());

        TextView bottomText = (TextView)findViewById(R.id.bottomText);
        bottomText.setText(bottomEdit.getText().toString());
    }
}
