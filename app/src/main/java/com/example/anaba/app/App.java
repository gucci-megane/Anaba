package com.example.anaba.app;

import android.app.Application;

import com.deploygate.sdk.DeployGate;

/**
 * Created by gucci on 2014/11/08.
 */
public class App extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        DeployGate.install(this);
    }
}
