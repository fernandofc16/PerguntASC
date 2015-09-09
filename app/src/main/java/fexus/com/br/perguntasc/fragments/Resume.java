package fexus.com.br.perguntasc.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fexus.com.br.perguntasc.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Resume extends Fragment {

    TextView resumeText;
    String text = "Equidade x Igualdade\n" +
            "\n" +
            "Em situações onde recursos devem ser priorizados, o critério de equidade atende melhor para a justiça social. Por exemplo, em filas comumente cheias, opta-se pela preferência para idosos, gestantes e deficientes.\n" +
            "\n" +
            "Participação popular no SUS\n" +
            "\n" +
            "Ocorre através de conselhos e conferências:\n" +
            "Os conselhos de saúde trabalham continuamente, e existem em âmbito municipal, estadual e nacional. Cabem a eles aprovar o plano de saúde, o orçamento, acompanhar a execução das políticas de saúde, avaliar os serviços de saúde e fiscalizar a aplicação dos recursos financeiros.\n" +
            "\n" +
            "Nas conferências, debate-se sobre a política de saúde. Ocorrem periodicamente, se reunindo por convocação do gestor ou do conselho de saúde. Também existem nas três esferas do poder: as conferências municipais precedem as estaduais e estas a nacional. Nas duas primeiras são escolhidos delegados para representação na conferência nacional. Esta é o nível mais alto de decisão sobre a saúde no Brasil.";

    public Resume() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_resume, container, false);

        resumeText = (TextView) layout.findViewById(R.id.resumeText);
        resumeText.setMovementMethod(new ScrollingMovementMethod());
        resumeText.setText(text);

        return layout;
    }


}
