package com.mnr.photoedit;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.squareup.picasso.Picasso;


public class ControlActivity extends AppCompatActivity {
    Toolbar mControlToolbar;
    ImageView mTickImageView;
    ImageView mCenterImageView;
    final static int PICK_IMAGE =2;
    ImageView mFirstImageView;
    ImageView mSecondImageView;
    ImageView mThirdImageView;
    ImageView mFourthImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        mCenterImageView = (ImageView) findViewById(R.id.centerImageView);
        mFirstImageView = (ImageView) findViewById(R.id.imageView1);
        mSecondImageView = (ImageView) findViewById(R.id.imageView2);
        mThirdImageView = (ImageView) findViewById(R.id.imageView3);
        mFourthImageView = (ImageView) findViewById(R.id.imageView4);


        mControlToolbar = (Toolbar) findViewById(R.id.toolbar);
        mControlToolbar.setTitle(getString(R.string.app_name));
        mControlToolbar.setNavigationIcon(R.drawable.logo);
        mControlToolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));

        mTickImageView = (ImageView) findViewById(R.id.tickImageView);
        mTickImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(ControlActivity.this,ImagePreviewActivity.class);
                startActivity(intent);
            }
        });


        mCenterImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("Image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Picture"),PICK_IMAGE);
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data) {
        if(requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            Uri selectedImageUri = data.getData();
            Picasso.with(ControlActivity.this).load(selectedImageUri).into(mCenterImageView);
            Picasso.with(ControlActivity.this).load(selectedImageUri).into(mFirstImageView);
            Picasso.with(ControlActivity.this).load(selectedImageUri).into(mSecondImageView);
            Picasso.with(ControlActivity.this).load(selectedImageUri).into(mThirdImageView);
            Picasso.with(ControlActivity.this).load(selectedImageUri).into(mFourthImageView);
        }
    }
}
