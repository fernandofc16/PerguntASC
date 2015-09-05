package fexus.com.br.perguntasc.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;

import fexus.com.br.perguntasc.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class Login extends Fragment {

    private ImageView button_login_back;
    private CallbackManager mCallbackManager;
    public static String userName = null, userId = null;
    private FacebookCallback<LoginResult> mCallBack;
    private AccessTokenTracker mTokenTracker;
    private ProfileTracker mProfileTracker;
    public static Profile profile;
    public static ProfilePictureView loginProfilePicture;
    public static TextView loginName, connectedText;


    {
        mCallBack = new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {
                //if(profile.getName() == userName) {
                    //startActivity(new Intent("android.intent.action.Logged"));
                //} else {
                    Log.e("FEXUS", "PASSOU NO ONSUCCESS");
                    //AccessToken accessToken = loginResult.getAccessToken();
                    setProfile();

                    startActivity(new Intent("android.intent.action.Logged"));
                    button_login_back.setVisibility(View.VISIBLE);
                    getActivity().finish();
                //}
            }

            @Override
            public void onCancel() {
                Log.e("FEXUS", "PASSOU NO ONCANCEL");
                Toast.makeText(getActivity().getApplicationContext(), "Não foi possível conectar ao Facebook", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException e) {
                Log.e("FEXUS", "PASSOU NO ONERROR" + "\n" + e.getMessage());
                Toast.makeText(getActivity().getApplicationContext(), "Não foi possível conectar ao Facebook", Toast.LENGTH_SHORT).show();
            }
        };

    }

    public Login() {

    }

    public void setProfile() {

            profile = Profile.getCurrentProfile();

            if (profile != null) {

                if (userName == null || !(userName.equals(profile.getName()))) {
                    userName = profile.getName();
                }

                if (userId == null || !(userId.equals(profile.getId()))) {
                    userId = profile.getId();
                }

                connectedText.setText("Conectado");
                connectedText.setTextColor(getResources().getColor(R.color.green));
                loginProfilePicture.setProfileId(userId);
                loginName.setText(userName);

            } else {
                button_login_back.setVisibility(View.GONE);
                userName = null;
                userId = null;
                connectedText.setText("Desconectado");
                connectedText.setTextColor(getResources().getColor(R.color.red));
                loginProfilePicture.setProfileId("");
                loginName.setText("Nome");
            }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());

        mCallbackManager = CallbackManager.Factory.create();
        mTokenTracker = new AccessTokenTracker() {

            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldToken, AccessToken newToken) {
                Log.w("FEXUS", "PASSOU NO ACCESSTOKENTRACKER");
                if (newToken == null) {
                    setProfile();
                }
            }
        };
        mProfileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile newProfile) {
                Log.w("FEXUS", "PASSOU NO ONCURRENTPROFILECHANGED");
                setProfile();
            }
        };
        mTokenTracker.startTracking();
        mProfileTracker.startTracking();
    }

    @Override
    public void onResume() {
        super.onResume();
        setProfile();
    }

    @Override
    public void onStop() {
        super.onStop();
        mTokenTracker.stopTracking();
        mProfileTracker.stopTracking();
        getActivity().finish();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        connectedText = (TextView) view.findViewById(R.id.connectedText);
        if(connectedText == null) { Toast.makeText(getActivity().getApplicationContext(), "connectedText equals NULL", Toast.LENGTH_LONG).show(); }
        loginProfilePicture = (ProfilePictureView) view.findViewById(R.id.loginProfilePicture);
        if(loginProfilePicture == null) { Toast.makeText(getActivity().getApplicationContext(), "loginProfilePicture equals NULL", Toast.LENGTH_LONG).show(); }
        loginName = (TextView) view.findViewById(R.id.nameLogin);
        if(loginName == null) { Toast.makeText(getActivity().getApplicationContext(), "loginName equals NULL", Toast.LENGTH_LONG).show(); }

        button_login_back = (ImageView) view.findViewById(R.id.button_next);
        button_login_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent("android.intent.action.Logged"));
            }
        });

        LoginButton loginButton = (LoginButton) view.findViewById(R.id.login_button);
        loginButton.setFragment(this);
        loginButton.registerCallback(mCallbackManager, mCallBack);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
