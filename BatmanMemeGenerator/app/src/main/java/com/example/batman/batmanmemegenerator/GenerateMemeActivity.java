package com.example.batman.batmanmemegenerator;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public void onMemeSave(View view){
        // TODO:
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.canvas);
        layout.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(layout.getDrawingCache());
        MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "Meme", "New meme");
        layout.setDrawingCacheEnabled(false);

    }
}
