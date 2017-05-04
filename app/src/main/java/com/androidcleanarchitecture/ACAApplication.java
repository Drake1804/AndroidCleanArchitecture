package com.androidcleanarchitecture;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.support.multidex.MultiDexApplication;
import android.text.TextUtils;

import com.androidcleanarchitecture.di.ApplicationComponent;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Pavel.Shkaran on 4/26/2017.
 */

public class ACAApplication extends MultiDexApplication {

    private static RealmConfiguration config;
    private ApplicationComponent mApplicationComponent;

    public static ACAApplication get(Context context) {
        return (ACAApplication) context.getApplicationContext();
    }

    public static void initRealm(Context context) {
        if (BuildConfig.DEBUG) {
            Realm.init(context);
        } else {
            ActivityManager activityManager =
                    (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            for (ActivityManager.RunningAppProcessInfo processInfo : activityManager.getRunningAppProcesses()) {
                if (Process.myPid() == processInfo.pid) {
                    if (TextUtils.equals(processInfo.processName, BuildConfig.APPLICATION_ID)) {
                        Realm.init(context);
                    }
                    break;
                }
            }
        }

        config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
        Realm.compactRealm(config);
    }

    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        initRealm(this);
    }
}
