package com.example.robotbluetooth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonpilotage;
    Button buttonP;
    Button buttoninfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonpilotage = findViewById(R.id.buttonpilotage);
        buttoninfo = findViewById(R.id.buttoninfo);
        buttonP = findViewById(R.id.buttonP);
        buttonpilotage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ecran_pilotage.class);
                startActivity(intent);
            }
        });
        buttonP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this,Parametres.class);
                startActivity(intent2);
            }
        });
        buttoninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, a_propos.class);
                startActivity(intent3);
            }
        });

    }
}
