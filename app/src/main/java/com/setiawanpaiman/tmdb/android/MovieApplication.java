package com.setiawanpaiman.tmdb.android;

import android.app.Application;
import android.support.annotation.NonNull;

import com.setiawanpaiman.tmdb.android.di.component.ApplicationComponent;
import com.setiawanpaiman.tmdb.android.di.component.DaggerApplicationComponent;

/**
 * Created by Setiawan Paiman on 24/6/17.
 */

public class MovieApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder().build();
    }

    @NonNull
    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
