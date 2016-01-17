package com.example.batman.batmanmemegenerator;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.veinhorn.scrollgalleryview.ScrollGalleryView;

import java.util.List;

public class ViewMemesActivity extends AppCompatActivity {
    private ScrollGalleryView scrollGalleryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_memes);

        scrollGalleryView = (ScrollGalleryView) findViewById(R.id.scroll_gallery_view);
        scrollGalleryView
                .setThumbnailSize(100)
                .setZoom(true)
                .setFragmentManager(getSupportFragmentManager());

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Meme");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> memes, ParseException e) {
                if (e == null) {
                    for (ParseObject meme : memes) {
                        ParseFile image = (ParseFile) meme.get("image");
                        image.getDataInBackground(new GetDataCallback() {
                            @Override
                            public void done(byte[] data, ParseException e) {
                                if (e == null) {
                                    Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                                    if (bitmap != null) {
                                        scrollGalleryView.addImage(bitmap);
                                    }
                                }
                                ;
                            }
                        });
                    }
                } else {
                    Toast.makeText(ViewMemesActivity.this, "Cannot connect to database", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
