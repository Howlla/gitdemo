package com.example.bhavyesharma.alarms;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.AlarmManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b=(Button) findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlarmManager am=(AlarmManager) MainActivity.this.getSystemService(Context.ALARM_SERVICE);
                Intent i=new Intent (MainActivity.this,MyReceiver.class);
                PendingIntent pendingIntent= PendingIntent.getBroadcast(MainActivity.this,1,i,0);
                am.set(AlarmManager.RTC,System.currentTimeMillis(),pendingIntent);
            }
        });
    }
}
