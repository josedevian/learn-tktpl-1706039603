package id.ac.ui.cs.mobileprogramming.activity1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

class WifiReceiver extends BroadcastReceiver {
    WifiManager wifiManager;
    ListView wifiDeviceList;
    ArrayList<String> temp = new ArrayList<>();
    private final OkHttpClient client = new OkHttpClient();

    public WifiReceiver(WifiManager wifiManager, ListView wifiDeviceList) {
        this.wifiManager = wifiManager;
        this.wifiDeviceList = wifiDeviceList;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION.equals(action)) {
            List<ScanResult> wifiList = wifiManager.getScanResults();

            for (ScanResult scanResult : wifiList) {
                temp.add(scanResult.SSID + " - " + scanResult.capabilities);
            }

            ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, temp.toArray());
            wifiDeviceList.setAdapter(arrayAdapter);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private String makePost() {
        RequestBody requestBody = null;
        MultipartBody.Builder multipart = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("Application", "lab-5-tktpl");

        for(int i = 0; i < temp.size(); i++) {
            multipart.addFormDataPart("Access Point-Name-" + i, temp.get(i));
        }

        requestBody = multipart.build();

        Request request = new Request.Builder()
                .url("https://bd90d34b4c34886991d50978fb62a9b2.m.pipedream.net")
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            Headers responseHeaders = response.headers();
            for (int i = 0; i < responseHeaders.size(); i++) {
                System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
            }
            return response.body().string();
        } catch (IOException e) {
            return "Error:"+ e.getMessage();
        }
    }

    class IOAsyncTask extends AsyncTask<Void, Void, String> {

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected String doInBackground(Void... params) {
            return makePost();
        }

        @Override
        protected void onPostExecute(String response) {
            Log.d("networking", response);
        }
    }
}
