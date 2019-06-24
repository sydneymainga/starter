package co.ke.binary.chama;

import android.app.Activity;
import android.content.Context;
import android.support.multidex.MultiDexApplication;

import javax.inject.Inject;

import co.ke.binary.chama.di.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import timber.log.Timber;

public class App extends MultiDexApplication implements HasActivityInjector {

    private static App instance;

    public static Context getContext() {
        return instance;
    }

    public static App getInstance() {
        return instance;
    }

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public void onCreate() {

        super.onCreate();
        instance = this;



        /* dagger init */
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this);

        /* timber */
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }


    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
