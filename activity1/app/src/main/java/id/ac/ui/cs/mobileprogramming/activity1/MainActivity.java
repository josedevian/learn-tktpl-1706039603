package id.ac.ui.cs.mobileprogramming.activity1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final int MY_PERMISSIONS_ACCESS_COARSE_LOCATION = 1;
    WifiReceiver wifiReceiver;
    private ListView wifiList;
    private WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifiList = findViewById(R.id.list_wifi);
        Button scanBtn = findViewById(R.id.scanBtn);

        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        if (!wifiManager.isWifiEnabled()) {
            Toast.makeText(getApplicationContext(), R.string.wifi_disabled_message, Toast.LENGTH_LONG).show();
            wifiManager.setWifiEnabled(true);
        }

        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(
                            MainActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_ACCESS_COARSE_LOCATION);
                } else {
                    wifiReceiver = new WifiReceiver(wifiManager, wifiList);
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
                    MainActivity.this.registerReceiver(wifiReceiver, intentFilter);
                    wifiManager.startScan();
                    Toast.makeText(MainActivity.this, R.string.scanning, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}