package com.example.robotbluetooth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ecran_pilotage extends AppCompatActivity {
    ImageButton imageButton, imageButton2, imageButton3, imageButton4, imageButton5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_pilotage);
        imageButton = findViewById(R.id.imageButton);
        imageButton2 = findViewById(R.id.imageButton2);
        imageButton3 = findViewById(R.id.imageButton3);
        imageButton4 = findViewById(R.id.imageButton4);
        imageButton5  = findViewById(R.id.imageButton5);


    }
    // on crée  les fonctions permettant d'envoyer les comandes au robot
    /*public void Avancer(View v){
        Parametres.getInstance().sendData(this,"8");
        Log.d("Avancer","send: avance");
    }
    public void Reculer(View v){
        Parametres.getInstance().sendData(this,"2");
        Log.d("reculer","send: recule");
    }
    public void Gauche(View v){
        Parametres.getInstance().sendData(this,"4");
        Log.d("Gauche","send: gauche");
    }
    public void Droite(View v){
        Parametres.getInstance().sendData(this,"6");
        Log.d("Droite","send: droite");
    }
    public void Stop(View v){
        Parametres.getInstance().sendData(this,"5");
        Log.d("Stop","send: stop");
    }*/

/*private class SendReceive extends Thread
{
    private final BluetoothSocket bluetoothSocket;
    private final InputStream inputStream;
    private final OutputStream outputStream;



    public SendReceive (BluetoothSocket socket)
    {
        bluetoothSocket = socket;
        InputStream tempIn = null;
        OutputStream tempOut = null;

        try {
            tempIn = bluetoothSocket.getInputStream();
            tempOut = bluetoothSocket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        inputStream = tempIn;
        outputStream = tempOut;
    }
    public void run()
    {
        byte[] buffer = new byte[1024];
        int bytes;

        while (true)
        {
            try{
                bytes = inputStream.read(buffer);
                //handler.ob
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/
}