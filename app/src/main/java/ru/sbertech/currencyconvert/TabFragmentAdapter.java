package ru.sbertech.currencyconvert;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import ru.sbertech.currencyconvert.convert_valute.ConvertFragment;
import ru.sbertech.currencyconvert.list_valute.ListFragment;

public class TabFragmentAdapter extends FragmentPagerAdapter {

    private List<TabFragment> tab;
    private ListFragment listFragment;
    private ConvertFragment convertFragment;

    public TabFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        initTabs(context);
    }

    private void initTabs(Context context) {
        tab = new ArrayList<>(2);
        listFragment = ListFragment.getInstance(context);
        tab.add(listFragment);
        convertFragment = ConvertFragment.getInstance(context);
        tab.add(convertFragment);
    }

    @Override
    public Fragment getItem(int position) {
        return tab.get(position);
    }

    @Override
    public int getCount() {
        return tab.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tab.get(position).getTitle();
    }
}
