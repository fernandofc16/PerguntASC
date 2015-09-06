package fexus.com.br.perguntasc.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import fexus.com.br.perguntasc.fragments.Analysis;
import fexus.com.br.perguntasc.fragments.Cases;
import fexus.com.br.perguntasc.fragments.Performance;
import fexus.com.br.perguntasc.fragments.Question1;
import fexus.com.br.perguntasc.fragments.Question2;
import fexus.com.br.perguntasc.fragments.Resume;

public class TabsAdapterQuestionsModuleASC2 extends FragmentPagerAdapter {

    private String[] titles = {"  Análise ", "  Resumo  ", "Desempenho"};
    public static boolean question1Answered = false, question2Answered = false;

    public TabsAdapterQuestionsModuleASC2(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;

        switch (position) {
            case 0:
                frag = new Analysis();
                break;
            case 1:
                frag = new Resume();
                break;
            case 2:
                frag = new Performance();
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
