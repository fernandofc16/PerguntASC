package fexus.com.br.perguntasc.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;

import fexus.com.br.perguntasc.fragments.ModuleASC;
import fexus.com.br.perguntasc.fragments.ModuleHealth;
import fexus.com.br.perguntasc.fragments.Ranking;

public class TabsAdapterMain extends FragmentPagerAdapter {

    private String[] titles = {" RANKING  ", "MÓDULO ASC", "MÓDULO PDS"};

    public TabsAdapterMain(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;

        switch (position) {
            case 0:
                frag = new Ranking();
                break;
            case 1:
                frag = new ModuleASC();
                break;
            case 2:
                frag = new ModuleHealth();
                break;
        }

        Bundle bundle = new Bundle();
        bundle.putInt("position", position);

        if (frag != null) {
            frag.setArguments(bundle);
        }

        return frag;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return (titles[position]);
    }

}
