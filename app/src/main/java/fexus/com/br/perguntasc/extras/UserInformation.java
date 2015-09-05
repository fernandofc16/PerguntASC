package fexus.com.br.perguntasc.extras;

/**
 * Created by Fernando
 */
public class UserInformation {

    private String idFacebook, name, backgroundImage;

    public String getIdFacebook() { return idFacebook; }
    public String getName() { return name; }
    public String getBackgroundImage() { return backgroundImage; }


    public UserInformation(String idFacebook, String name, String backgroundImage) {
        this.idFacebook = idFacebook;
        this.name = name;
        this.backgroundImage = backgroundImage;
    }

}