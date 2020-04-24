package com.example.robotbluetooth;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Parametres extends AppCompatActivity {
    SeekBar seekBar;
    TextView textView3, textView4, textView5, textBlue;
    ListView scanList;
    ArrayList<String> stringArrayList = new ArrayList<String>();
    ArrayAdapter<String> arrayAdapter;
    Button buttonScan, buttonON, buttonOFF;
    BluetoothAdapter myBluetoothAdapter;

    Intent btEnablingIntent;
    int requestCodeForEnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);
        textBlue = findViewById(R.id.textblue);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);

        //gestion de la luminosité
        seekBar = findViewById(R.id.seekBar);
        //activation du blutooth
        buttonScan = findViewById(R.id.buttonScan);


        buttonON = findViewById(R.id.buttonON);
        buttonOFF = findViewById(R.id.buttonOFF);
        myBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        btEnablingIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        requestCodeForEnable = 1;

        bluetoothONMethode();
        blutoothOFFMethode();

    }


    private void blutoothOFFMethode() {
        buttonOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myBluetoothAdapter.isEnabled())
                {
                    myBluetoothAdapter.disable();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == requestCodeForEnable) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(getApplicationContext(), "Bluetooth disponible", Toast.LENGTH_LONG).show();
            } else if (resultCode == RESULT_OK) {
                Toast.makeText(getApplicationContext(), "Bluetooth arrêté", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void bluetoothONMethode() {
        buttonON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myBluetoothAdapter==null)
                {
                    Toast.makeText(getApplicationContext(),"le Bluetooth n'est pas supporté",Toast.LENGTH_LONG).show();
                }else
                {
                    if(!myBluetoothAdapter.isEnabled())
                    {
                        startActivityForResult(btEnablingIntent, requestCodeForEnable);
                    }
                }
            }
        });
    }

}
