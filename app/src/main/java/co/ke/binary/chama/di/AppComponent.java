package co.ke.binary.chama.di;

import android.app.Application;

import javax.inject.Singleton;

import co.ke.binary.chama.App;
import co.ke.binary.chama.di.modules.ActivityBuilderModule;
import co.ke.binary.chama.di.modules.AppModule;
import co.ke.binary.chama.di.modules.NetworkModule;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Richard Kamere on 1/6/2019.
 */


@Singleton
@Component(modules = {
        /*internal dagger modules*/
        AndroidSupportInjectionModule.class,

        /*this module provide application scoped resources, retrofit, database....*/
        AppModule.class,

        /*we map all activity here*/
        ActivityBuilderModule.class,

        /* network */
        NetworkModule.class


})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }
    void inject(App app);
}