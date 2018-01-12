package com.ritikrishu.mylibrary;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ritikrishu on 12/01/18.
 */

public class ToastLibrary {

    public static void builder(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static void getIPAndStoreInCache(final Context context){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(2, TimeUnit.MINUTES);
        builder.readTimeout(2, TimeUnit.MINUTES);

        final OkHttpClient okHttpClient = builder.build();
        final Request request = new Request.Builder()
                .url("http://www.ip-api.com/json")
                .build();

        new AsyncTask<String,String,String>(){
            @Override
            protected String doInBackground(String... strings) {
                try {
                Response response = okHttpClient.newCall(request).execute();
                if (response.isSuccessful()) {

                        JSONObject ipCheckResponse = new JSONObject(response.body().string());
                        return ipCheckResponse.getString("query");
                }
                return "null";
                } catch (Exception e) {
                    e.printStackTrace();
                    return "error";
                }
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Toast.makeText(context,s,Toast.LENGTH_LONG).show();
            }
        }.execute("123");
    }

}
