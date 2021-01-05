package com.example.infotech.ifwallpaper;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    GridView gridview1;
    ImageView imageview1;
    Drawable drawable1;
    WallpaperManager wallmanager1;
    Integer [] imageArraylist={
            R.drawable.g,R.drawable.a,R.drawable.t,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridview1= (GridView) findViewById(R.id.gridveiw1);
        imageview1= (ImageView) findViewById(R.id.imageview1);
        Updathewall();
    }
    private void Updathewall(){
        wallmanager1= WallpaperManager.getInstance(getApplicationContext());
        drawable1=wallmanager1.getDrawable();
        imageview1.setImageDrawable(drawable1);
        gridview1.setAdapter(new imageadpteur(getApplicationContext()));

    }
    public class imageadpteur extends BaseAdapter{
        Context context1;
        public imageadpteur(Context applicationContext) {
            context1= applicationContext;
        }

        @Override
        public int getCount() {
            return imageArraylist.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ImageView gridview1;
            if (convertView==null){
                gridview1=new ImageView(context1);
                gridview1.setLayoutParams(new GridView.LayoutParams(514,514)  );
                gridview1.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }else {
                gridview1= (ImageView) convertView;
            }
            gridview1.setImageResource(imageArraylist[position]);
            gridview1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    try {
                        wallmanager1.setResource(imageArraylist[position]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Updathewall();

                }
            });
            return gridview1;
        }
    }
}
