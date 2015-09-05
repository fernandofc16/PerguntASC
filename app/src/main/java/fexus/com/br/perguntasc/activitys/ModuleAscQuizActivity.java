package fexus.com.br.perguntasc.activitys;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import fexus.com.br.perguntasc.R;
import fexus.com.br.perguntasc.adapters.TabsAdapterQuestionsModuleASC;
import fexus.com.br.perguntasc.extras.SlidingTabLayout;

public class ModuleAscQuizActivity extends AppCompatActivity {

    public static String caseName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_asc_quiz);

        //TOOLBAR
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar_asc);
        if(mToolbar != null) {
            mToolbar.setTitle(caseName);
            setSupportActionBar(mToolbar);
            mToolbar.setLogo(R.drawable.icon_modulos);
        }

        //TABS
        ViewPager mViewPager = (ViewPager) findViewById(R.id.vp_tabs_asc);
        mViewPager.setAdapter(new TabsAdapterQuestionsModuleASC(getSupportFragmentManager()));

        SlidingTabLayout mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.stl_tabs_asc);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.colorAccent));
        mSlidingTabLayout.setViewPager(mViewPager);
        //all proprieties must be before set view pager
    }

}
