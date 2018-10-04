package com.example.adrianzabdiel.actividad10;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class MyService extends Service {
    private final IBinder mBinder = new binder();

    public class binder extends Binder {
        MyService getService(){
            return MyService.this;
        }
    }

        public MyService() {
        }

        public String MensajeUno(){
        return "Welcome";
        }

        public String MensajeDos(){
        return "Bound Service";
        }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    }