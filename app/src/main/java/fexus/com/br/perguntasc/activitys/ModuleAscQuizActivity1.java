package fexus.com.br.perguntasc.activitys;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import fexus.com.br.perguntasc.R;
import fexus.com.br.perguntasc.adapters.TabsAdapterQuestionsModuleASC1;
import fexus.com.br.perguntasc.extras.SlidingTabLayout;

public class ModuleAscQuizActivity1 extends AppCompatActivity {

    public static String caseName = "";
    public static int answer1, answer2;
    static Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_asc_quiz1);

        answer1 = 0;
        answer2 = 0;
        activity = this;

        //TOOLBAR
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar_asc1);
        if(mToolbar != null) {
            mToolbar.setTitle("  " + caseName);
            setSupportActionBar(mToolbar);
            mToolbar.setLogo(R.drawable.icon_modulos);
        }

        //TABS
        ViewPager mViewPager = (ViewPager) findViewById(R.id.vp_tabs_asc1);
        mViewPager.setAdapter(new TabsAdapterQuestionsModuleASC1(getSupportFragmentManager()));

        SlidingTabLayout mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.stl_tabs_asc1);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.colorAccent));
        mSlidingTabLayout.setViewPager(mViewPager);
        //all proprieties must be before set view pager
    }

    public static void checkQuestionsAnswered(Context context) {
        if(answer1 != 0 && answer2 != 0) {
            AlertDialog diaBox = AskOption(context);
            diaBox.show();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        finish();
    }

    private static AlertDialog AskOption(final Context context)
    {
        AlertDialog myQuittingDialogBox = new AlertDialog.Builder(activity)
                //set message, title, and icon
                .setTitle("Confirmar")
                .setMessage("Deseja confirmar as respostas selecionadas?")
                .setIcon(R.drawable.icon_modulos)

                .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        //your deleting code
                        Intent i = new Intent().setClass(context, ModuleAscQuizActivity2.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(i);
                        dialog.dismiss();
                    }

                })



                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }
                })
                .create();
        return myQuittingDialogBox;

    }


}
