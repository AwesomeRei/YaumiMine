package id.its.yaumiapp;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import id.its.yaumiapp.broadcast_receivers.NotificationEventReceiver;

public class MainActivity extends AppCompatActivity {
    private Button newTab;
    private Button tab2;
    private Button xNotif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newTab = (Button)findViewById(R.id.button1);
        tab2 = (Button)findViewById(R.id.button2);
        xNotif = (Button)findViewById(R.id.button3);
        newTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ChartActivity.class                                                                                                                                        );
                startActivity(intent);
            }
        });
        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ProfileActivity.class                                                                                                                                        );
                startActivity(intent);
            }
        });
        xNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationEventReceiver.setupAlarm(getApplicationContext());
//                System.out.println("Syudah ditekan");
            }
        });

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    // To prevent crash on resuming activity  : interaction with fragments allowed only after Fragments Resumed or in OnCreate
    // http://www.androiddesignpatterns.com/2013/08/fragment-transaction-commit-state-loss.html
    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        // handleIntent();
    }
}
