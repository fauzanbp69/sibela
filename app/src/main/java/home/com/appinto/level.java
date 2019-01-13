package home.com.appinto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class level extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        findViewById(R.id.C1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrefManager prefManager = new PrefManager(getApplicationContext());
                prefManager.setFirstTimeLaunch(true);
                startActivity(new Intent(level.this, ActivityMain2.class));
                finish();
            }
        });
    }}