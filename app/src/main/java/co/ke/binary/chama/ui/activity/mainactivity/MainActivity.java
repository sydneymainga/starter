package co.ke.binary.chama.ui.activity.mainactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import co.ke.binary.chama.R;
import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{

    @Inject
    MainActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void setPresenter(MainActivityContract.Presenter presenter) {
       this.presenter = presenter;
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onSuccess(String message) {

    }

    @Override
    public void displayProgress(boolean display) {

    }
}
