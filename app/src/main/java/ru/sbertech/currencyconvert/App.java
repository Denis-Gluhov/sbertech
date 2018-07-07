package ru.sbertech.currencyconvert;

import android.app.Application;
import android.support.annotation.NonNull;

import ru.sbertech.currencyconvert.di.AppComponent;
import ru.sbertech.currencyconvert.di.AppModule;
import ru.sbertech.currencyconvert.di.DaggerAppComponent;
import ru.sbertech.currencyconvert.di.NetworkModule;
import ru.sbertech.currencyconvert.ui.list_valute.ListFragment;
import ru.sbertech.currencyconvert.ui.list_valute.ListFragmentComponent;
import ru.sbertech.currencyconvert.ui.list_valute.ListFragmentModule;

public class App extends Application {

    private static App instance;

    public static App getInstance() {
        return instance;
    }

    private AppComponent appComponent;
    private ListFragmentComponent listFragmentComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initDagger();
    }

    private void initDagger() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    public ListFragmentComponent initListFragmentComponent(@NonNull ListFragment listFragment) {
        listFragmentComponent = appComponent.listFragmentComponent(new ListFragmentModule(listFragment));
        return listFragmentComponent;
    }
}
