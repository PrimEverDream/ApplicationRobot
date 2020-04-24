package com.example.robotbluetooth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class a_propos extends AppCompatActivity {
String noms[];
int photos[];
ImageButton buttonImage6;
ImageButton buttonImage7;
ImageView imageView2;
TextView textView7;
int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        noms = new String[]{"Alan","Raphael","jack"};
        photos = new int[]{R.drawable.fleche_bas,R.drawable.fleche_haut, R.drawable.sambot};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_propos);
        buttonImage6 = findViewById(R.id.imageButton6);
        buttonImage7 = findViewById(R.id.imageButton7);
        imageView2 = findViewById(R.id.imageView2);
        textView7 = findViewById(R.id.textView7);
        imageView2.setImageResource(photos[0]);
        textView7.setText(noms[0]);
        buttonImage6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i>0) {
                    i = i - 1;
                    imageView2.setImageResource(photos[i]);
                    textView7.setText(noms[i]);
                }else{
                    i=2;
                    imageView2.setImageResource(photos[i]);
                    textView7.setText(noms[i]);
                }
            }
        });
        buttonImage7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i<2) {
                    i = i + 1;
                    imageView2.setImageResource(photos[i]);
                    textView7.setText(noms[i]);
                }else{
                    i=0;
                    imageView2.setImageResource(photos[i]);
                    textView7.setText(noms[i]);
                }
            }
        });
    }
}
