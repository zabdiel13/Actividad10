package com.example.adrianzabdiel.actividad10;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    MyService servicio;
    boolean isBound = false;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView =(TextView) findViewById(R.id.textView);
        Intent intent = new Intent(this,MyService.class);
        bindService(intent, conexion, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection conexion = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
           MyService.binder b =(MyService.binder) service;
           servicio = b.getService();
           isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        isBound = false;
        }
    };
        @Override
        protected void onStop(){
            super.onStop();
            if(isBound){
                unbindService(conexion);
                isBound = false;
            }
        }

    public void MensajeUno(View view) {
       String mensaje;
       mensaje = servicio.MensajeUno();
       textView.setText(mensaje);
    }

    public void MensajeDos(View view) {
        String mensaje;
        mensaje = servicio.MensajeDos();
        textView.setText(mensaje);
    }

}
