package com.nomet.app.alarmer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class AlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        Toast.makeText(this, "kekkkekeke", Toast.LENGTH_SHORT).show();
        TextView text = (TextView)findViewById(R.id.itwork);

        text.setText("Сработало");
    }
}
