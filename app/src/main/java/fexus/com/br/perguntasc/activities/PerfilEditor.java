package fexus.com.br.perguntasc.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.login.widget.ProfilePictureView;

import fexus.com.br.perguntasc.R;

public class PerfilEditor extends AppCompatActivity {

    ProfilePictureView editProfilePicture;
    Button buttonEditProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_editor);

        editProfilePicture = (ProfilePictureView) findViewById(R.id.editProfilePicture);
        buttonEditProfile = (Button) findViewById(R.id.buttonEditProfile);

        editProfilePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Contact Image:"), 1);
            }
        });

    }

    public void onActivityResult(int reqCode, int resCode, Intent data) {
        if (resCode == RESULT_OK) {
            if (reqCode == 1) {
                //imgContactEdit.setImageBitmap(convertAndScaleUriToBitmap(data.getData(), 100, 100));
                //imageUri = data.getData();
            }
        }
    }

}
