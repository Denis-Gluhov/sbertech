package ru.tander.currencyconvert.screens.list.presenter;

import java.util.List;

import ru.tander.currencyconvert.model.Currency;

public interface IListPresenter {
    void setData(List<Currency> data);
    void onRefreshData();
}
