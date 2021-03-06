package ru.sbertech.currencyconvert.di;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class, DatabaseModule.class})
public interface AppComponent {
    ValutesComponent plusValutesComponent();
}
