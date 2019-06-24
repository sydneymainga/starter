package co.ke.binary.chama.di.modules.activitybuilders;



import co.ke.binary.chama.data.services.UsersService;
import co.ke.binary.chama.ui.activity.mainactivity.MainActivity;
import co.ke.binary.chama.ui.activity.mainactivity.MainActivityContract;
import co.ke.binary.chama.ui.activity.mainactivity.MainActivityPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Richard Kamere on 1/10/2019.
 */

@Module
public class MainActivityModule {

    @Provides
    MainActivityContract.View providesView(MainActivity airtimeActivity) {
        return airtimeActivity;
    }
    @Provides
    MainActivityContract.Presenter providesPresenter(MainActivityContract.View view, UsersService usersService){
        return new MainActivityPresenter(usersService,view);
    }


}
