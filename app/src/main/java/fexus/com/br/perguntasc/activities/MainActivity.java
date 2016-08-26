/**
 *  Created by Fernando Ferreira Cunha
 */

package fexus.com.br.perguntasc.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.ProfilePictureView;

import java.io.IOException;

import fexus.com.br.perguntasc.R;
import fexus.com.br.perguntasc.adapters.TabsAdapterMain;
import fexus.com.br.perguntasc.database.DatabaseDrawableHandler;
import fexus.com.br.perguntasc.extras.SlidingTabLayout;
import fexus.com.br.perguntasc.fragments.Login;


public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    String userFirstName, userSecondName, userThirdName;
    DatabaseDrawableHandler dbHandler;
    ImageView drawerHeader;
    Bitmap bitmap;
    Uri imageUri = Uri.parse("android.resource://br.com.fexus.perguntasc/drawable/background_drawer");

    private void setUserName(String userName) {
       String[] userFullNameSplit = userName.split(" ");

        for(int i = 0; i < userFullNameSplit.length; i++) {
            switch (i) {
                case 0:
                    userFirstName = userFullNameSplit[i];
                    break;
                case 1:
                    userSecondName = userFullNameSplit[i];
                    break;
                case 2:
                    userThirdName = userFullNameSplit[i];
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(this);

        setContentView(R.layout.activity_main);

        dbHandler = new DatabaseDrawableHandler(getApplicationContext());

        /*
        drawableSalvo = dbHandler.isDrawableSave();

        if(drawableSalvo) {
            drawableNavigationHeader = new BitmapDrawable(BitmapFactory.decodeByteArray(dbHandler.getDrawable(), 0, dbHandler.getDrawable().length));
        }
        if(drawableNavigationHeader != null) {
            drawerHeader.setBackground(drawableNavigationHeader);
        }
        */

        setUserName(Login.userName);
        String userId = Login.userId;
        String userScore = "Score: 500";
        String userPosition = "Position: 1º";

        //TOOLBAR
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if(mToolbar != null) {
            mToolbar.setTitle("PerguntASC");
            setSupportActionBar(mToolbar);
        }

        //Initialising DrawerLayout.
        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        //Set Head NavigationDrawer
        ProfilePictureView userHeadPicture = (ProfilePictureView) findViewById(R.id.picture_drawer);
        userHeadPicture.setProfileId(userId);
        TextView userHeadName = (TextView) findViewById(R.id.text_drawer_name);

        char[] userSecondNameChars = null;
        char[] userThirdNameChars = null;

        if(userSecondName != null) {
            userSecondNameChars = userSecondName.toCharArray();
        } else {
            userSecondName = " ";
        }

        if(userThirdName != null) {
            userThirdNameChars = userThirdName.toCharArray();
        } else {
            userThirdName = " ";
        }

        if ((userFirstName.length() + userSecondName.length() + userThirdName.length()) < 22) {
            userHeadName.setText(userFirstName + " " + userSecondName + " " + userThirdName);
        } else if ((userFirstName.length() + userThirdName.length()) < 20) {
            userHeadName.setText(userFirstName + " " + userSecondNameChars[0] + ". " + userThirdName);
        } else {
            userHeadName.setText(userFirstName + " " + userSecondNameChars[0] + ". " + userThirdNameChars[0]);
        }

        TextView userHeadScore = (TextView) findViewById(R.id.text_drawer_score_position);
        userHeadScore.setText(userScore + "  |  " + userPosition);

        //Ranking
        if (drawerLayout == null) {
            Log.e("FEXUS", "drawerLayout equals NULL - onCreate - MAIN ACTIVITY");
        }


        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        //Setting OnNavigationItemSelectedListener to the Navigation View.
        //This is used to perform specific action when an item is clicked.
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                //Navigation View must close when any of this item is clicked.
                //To do this we use the closeDrawers() method.
                if (drawerLayout != null) drawerLayout.closeDrawers();

                //Using switch case to identify the ID of the menu item
                // and then performing relevant action.

                switch (menuItem.getItemId()){
                    case R.id.logout:
                        LoginManager.getInstance().logOut();
                        finish();
                        return true;
                    case R.id.item1:
                        Toast.makeText(getApplicationContext(),"You clicked item 1", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.item2:
                        Toast.makeText(getApplicationContext(),"You clicked item 2", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.item3:
                        Toast.makeText(getApplicationContext(),"You clicked item 3", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.perfilEdit:
                        Intent intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(Intent.createChooser(intent, "Select Contact Image:"), 1);
                        return true;
                    default:
                        Toast.makeText(getApplicationContext(),"Something went wrong", Toast.LENGTH_SHORT).show();
                        return true;
                }
            }
        });

        //Initialising ActionBarDrawerToggle and overriding its methods
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close){
            //We can perform a particular action when the
            // Navigation View is opened by overriding the
            // onDrawerOpened() method.
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //Toast.makeText(getApplicationContext(),"Drawer Opened",Toast.LENGTH_SHORT).show();
            }

            //We can perform a particular action when the
            // Navigation View is closed by overriding the
            // onDrawerClosed() method.
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                //Toast.makeText(getApplicationContext(),"Drawer Closed",Toast.LENGTH_SHORT).show();
            }
        };

        //Finally setting up the drawer listener for DrawerLayout
        if (drawerLayout != null) drawerLayout.setDrawerListener(drawerToggle);

        //Sync State of the navigation icon on the toolbar
        // with the drawer when the drawer is opened or closed.
        drawerToggle.syncState();

        //TABS
        ViewPager mViewPager = (ViewPager) findViewById(R.id.vp_tabs);
        mViewPager.setAdapter(new TabsAdapterMain(getSupportFragmentManager()));

        SlidingTabLayout mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.stl_tabs);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.colorAccent));
        mSlidingTabLayout.setViewPager(mViewPager);
        //all proprieties must be before set view pager

    }

    public Bitmap convertAndScaleUriToBitmap(Uri uri, int width, int height) {
        Log.e("uri:", uri.toString());
        try {
            bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bitmap = Bitmap.createScaledBitmap(bitmap, height, width, true);

        return bitmap;
    }

    public void onActivityResult(int reqCode, int resCode, Intent data) {
        if (resCode == RESULT_OK) {
            if (reqCode == 1) {
                drawerHeader = (ImageView) findViewById(R.id.backgroundDrawer);
                drawerHeader.setImageBitmap(convertAndScaleUriToBitmap(data.getData(), 195, 300));
                imageUri = data.getData();

                /*
                Drawable backgroundDrawable;
                try {
                    InputStream inputStream = getContentResolver().openInputStream(data.getData());
                    backgroundDrawable = Drawable.createFromStream(inputStream, data.getData().toString());
                } catch (FileNotFoundException e) {
                    backgroundDrawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.background_drawer);
                }
                drawerHeader.setImageDrawable(backgroundDrawable);
                */

                /*
                Resources res = getResources();
                Drawable drawable = res.getDrawable(R.drawable.background_drawer);
                Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] bitMapData = stream.toByteArray();
                dbHandler.deleteDrawable();
                dbHandler.saveDrawable(bitMapData);
                */
            }
        }
    }

}
