package com.example.batman.batmanmemegenerator;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.veinhorn.scrollgalleryview.ScrollGalleryView;

public class ChooseMemeActivity extends AppCompatActivity {
    private ScrollGalleryView scrollGalleryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_meme);

        scrollGalleryView = (ScrollGalleryView)findViewById(R.id.scroll_gallery_view);
        scrollGalleryView
                .setThumbnailSize(100)
                .setZoom(true)
                .setFragmentManager(getSupportFragmentManager())
                .addImage(convertDrawableToBitmap(R.drawable.main_activity_bg))
                .addImage(convertDrawableToBitmap(R.drawable.main_activity_bg))
                .addImage(convertDrawableToBitmap(R.drawable.main_activity_bg))
                .addImage(convertDrawableToBitmap(R.drawable.main_activity_bg))
                .addImage(convertDrawableToBitmap(R.drawable.main_activity_bg));
    }

    private Bitmap convertDrawableToBitmap(int image) {
        return ((BitmapDrawable)getResources().getDrawable(image)).getBitmap();
    }
}
