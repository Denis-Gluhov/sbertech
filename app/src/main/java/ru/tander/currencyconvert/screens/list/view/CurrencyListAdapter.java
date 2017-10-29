package ru.tander.currencyconvert.screens.list.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.tander.currencyconvert.R;
import ru.tander.currencyconvert.model.Currency;

public class CurrencyListAdapter extends RecyclerView.Adapter<CurrencyListAdapter.CurrencyViewHolder> {

    private List<Currency> data;
    private LayoutInflater inflater;

    public CurrencyListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public CurrencyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_currency, parent, false);
        return new CurrencyViewHolder(view);
    }

    public void setData(List<Currency> data) {
        this.data = data;
    }

    @Override
    public void onBindViewHolder(CurrencyViewHolder holder, int position) {
        Currency currency = data.get(position);
        holder.name.setText(currency.getName());
        holder.fullText.setText(currency.getNominal() + " " + currency.getCharCode() + " = " + currency.getValue() + " руб.");
    }

    @Override
    public int getItemCount() {
        if (data == null)
            return 0;
        else
            return data.size();
    }

    class CurrencyViewHolder extends RecyclerView.ViewHolder{
        CardView cardCurrency;
        TextView name, fullText;
        CurrencyViewHolder(View itemView) {
            super(itemView);
            cardCurrency = (CardView) itemView.findViewById(R.id.card_currency);
            name = (TextView) itemView.findViewById(R.id.name_currency);
            fullText = (TextView) itemView.findViewById(R.id.full_text);
        }
    }
}
