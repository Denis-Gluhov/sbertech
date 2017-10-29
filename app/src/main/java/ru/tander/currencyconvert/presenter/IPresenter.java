package ru.tander.currencyconvert.presenter;

import java.util.List;

import ru.tander.currencyconvert.model.Currency;

public interface IPresenter {
    void setData(List<Currency> data);
    String convert(String sum);
    void setValueSource(double valueSource);
    void setValueFinal(double valueFinal);
    void setNominal(int nominal);
}
