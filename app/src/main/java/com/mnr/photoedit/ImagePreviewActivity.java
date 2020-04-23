package com.mnr.photoedit;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ImagePreviewActivity extends AppCompatActivity {
    Toolbar mControlToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_preview);

        mControlToolbar = (Toolbar) findViewById(R.id.toolbar2);
        mControlToolbar.setTitle(getString(R.string.app_name));
        mControlToolbar.setNavigationIcon(R.drawable.logo);
        mControlToolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
    }
}
