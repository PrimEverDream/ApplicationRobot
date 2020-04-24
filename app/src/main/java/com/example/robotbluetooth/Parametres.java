package com.example.robotbluetooth;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
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
    TextView textView3, textView4, textView5, textBlue;
    ListView scanList;
    ArrayList<String> stringArrayList = new ArrayList<String>();
    ArrayAdapter<String> arrayAdapter;
    Button buttonScan, buttonON, buttonOFF;
    BluetoothAdapter myBluetoothAdapter;

    Intent btEnablingIntent;
    int requestCodeForEnable;
    //=================
    SeekBar sbLumi;
    boolean success = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);
        textBlue = findViewById(R.id.textblue);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);


        //gestion de la luminosité
        sbLumi = findViewById(R.id.seekBar);
        sbLumi.setMax(255);
        sbLumi.setProgress(getLumi());

        sbLumi.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser && success){
                    setLumi(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (!success){
                    Toast.makeText(Parametres.this,"Permission not granted",Toast.LENGTH_SHORT).show();
                }
            }
        });





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
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == requestCodeForEnable) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(getApplicationContext(), "Bluetooth disponible", Toast.LENGTH_LONG).show();
            } else if (resultCode == RESULT_OK) {
                Toast.makeText(getApplicationContext(), "Bluetooth arrêté", Toast.LENGTH_LONG).show();
            }
        }
        if (requestCode == 1000) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                boolean value = Settings.System.canWrite(getApplicationContext());
                if (value) {
                    success = true;
                } else {
                    Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT).show();
                }
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


    //=========================================================================
    //Fonctions pour la luminosite
    private void setLumi (int lumi){
        if (lumi < 0){
            lumi = 0;
        }
        else if(lumi > 255){
            lumi = 255;
        }
        ContentResolver contentResolver = getApplicationContext().getContentResolver();
        Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS, lumi);
    }

    private int getLumi(){
        int lumi = 100;
        try {
            ContentResolver contentResolver = getApplicationContext().getContentResolver();
            lumi = Settings.System.getInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS);
        }catch(Settings.SettingNotFoundException e){
            e.printStackTrace();
        }
        return lumi;
    }

    private void getPermission(){
        boolean value;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            value = Settings.System.canWrite(getApplicationContext());
            if(value){
                success = true;
            }else{
                Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                intent.setData(Uri.parse("package:" + getApplicationContext().getPackageName()));
                startActivity(intent);
            }
        }
    }
    //Version partielle
    /*@Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        if (requestCode == 1000) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                boolean value = Settings.System.canWrite(getApplicationContext());
                if (value) {
                    success = true;
                } else {
                    Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }*/
}
