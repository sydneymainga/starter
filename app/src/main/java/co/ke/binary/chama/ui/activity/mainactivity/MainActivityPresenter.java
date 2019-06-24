package co.ke.binary.chama.ui.activity.mainactivity;

import javax.inject.Inject;

import co.ke.binary.chama.data.services.UsersService;
import io.reactivex.disposables.CompositeDisposable;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private CompositeDisposable compositeDisposable;
    private UsersService usersService;
    private MainActivityContract.View view;

    @Inject
    public MainActivityPresenter(UsersService usersService, MainActivityContract.View view) {
        this.usersService = usersService;
        this.view = view;
        this.compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void fetchUser() {

    }

    @Override
    public void start() {

    }

    @Override
    public void onDestroy() {

    }
}
