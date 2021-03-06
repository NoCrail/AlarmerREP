package com.nomet.app.alarmer;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    public int hour;
    public int minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button set = (Button)findViewById(R.id.set);
        final TimePicker time = (TimePicker)findViewById(R.id.timePicker);
        final Calendar cal = new GregorianCalendar();
        Calendar cur_cal = new GregorianCalendar();
        cur_cal.setTimeInMillis(System.currentTimeMillis());
        cal.add(Calendar.DAY_OF_YEAR, cur_cal.get(Calendar.DAY_OF_YEAR));

        //cal.set(Calendar.SECOND, cur_cal.get(Calendar.SECOND));
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, cur_cal.get(Calendar.MILLISECOND));
        cal.set(Calendar.DATE, cur_cal.get(Calendar.DATE));
        cal.set(Calendar.MONTH, cur_cal.get(Calendar.MONTH));

        final AlarmManager alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmActivity.class);
        final PendingIntent pintent = PendingIntent.getActivity(this, 0, intent, 0);
        //alarm.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), 0, pintent);


        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Setted", Toast.LENGTH_SHORT).show();
                int h = time.getCurrentHour();
                int m = time.getCurrentMinute();
                cal.set(Calendar.HOUR_OF_DAY, h);
                hour =h;
                minute = m;
                cal.set(Calendar.MINUTE, m);
                alarm.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pintent);
            }
        });

    }

}
