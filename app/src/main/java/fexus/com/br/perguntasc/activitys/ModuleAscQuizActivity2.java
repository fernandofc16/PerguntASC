package fexus.com.br.perguntasc.activitys;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import fexus.com.br.perguntasc.R;
import fexus.com.br.perguntasc.adapters.TabsAdapterQuestionsModuleASC1;
import fexus.com.br.perguntasc.adapters.TabsAdapterQuestionsModuleASC2;
import fexus.com.br.perguntasc.extras.SlidingTabLayout;

public class ModuleAscQuizActivity2 extends AppCompatActivity {
    public static String caseName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_asc_quiz2);

        //TOOLBAR
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar_asc2);
        if(mToolbar != null) {
            mToolbar.setTitle("  " + caseName);
            setSupportActionBar(mToolbar);
            mToolbar.setLogo(R.drawable.icon_modulos);
        }

        //TABS
        ViewPager mViewPager = (ViewPager) findViewById(R.id.vp_tabs_asc2);
        mViewPager.setAdapter(new TabsAdapterQuestionsModuleASC2(getSupportFragmentManager()));

        SlidingTabLayout mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.stl_tabs_asc2);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.colorAccent));
        mSlidingTabLayout.setViewPager(mViewPager);
        //all proprieties must be before set view pager
    }

}