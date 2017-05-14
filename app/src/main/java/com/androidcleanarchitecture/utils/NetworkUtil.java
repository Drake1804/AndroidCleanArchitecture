package com.androidcleanarchitecture.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by drake1804 on 5/14/17.
 */

public class NetworkUtil {

    public static  boolean isNetworkAvailable(Context context) {
        if(context == null) { return false; }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        // if no network is available networkInfo will be null, otherwise check if we are connected
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return true;
            }
        } catch (Exception ignored) {
        }
        return false;
    }

}
