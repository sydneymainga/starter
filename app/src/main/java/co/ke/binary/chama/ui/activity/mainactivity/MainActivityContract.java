package co.ke.binary.chama.ui.activity.mainactivity;

import co.ke.binary.chama.ui.activity.base.BasePresenter;
import co.ke.binary.chama.ui.activity.base.BaseView;

public interface MainActivityContract {

    interface View extends BaseView<Presenter> {
        void onError(String message);
        void onSuccess(String message);
        void displayProgress(boolean display);
    }

    interface Presenter extends BasePresenter {

        void fetchUser();


    }

}
