package co.ke.binary.chama.di.modules;

import co.ke.binary.chama.di.modules.activitybuilders.MainActivityModule;
import co.ke.binary.chama.ui.activity.mainactivity.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Richard Kamere on 1/6/2019.
 */
@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();


}
