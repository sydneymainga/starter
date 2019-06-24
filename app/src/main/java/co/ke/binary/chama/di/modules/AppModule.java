package co.ke.binary.chama.di.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Richie on 10/22/2018.
 */

/* class that provides instances */

@Module(includes = {
        NetworkModule.class
})
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application){
        return application;
    }

}
