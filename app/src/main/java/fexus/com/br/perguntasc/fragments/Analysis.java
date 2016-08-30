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
public class Analysis extends Fragment {

    TextView analysisText;
    String text = "Na fase anterior, o princípio da Universalidade foi aplicado para Vitória e seu filho João: ambos tiveram \n" +
            "direito aos cuidados de saúde oferecidos pelo Estado." +
            "\n" +
            "Na carta ao conselho, você pode reivindicar a necessidade da construção de um centro de saúde no bairro Alagoas, além de melhorias de saneamento. Isso exigiria um investimento maior neste bairro, comparado ao investimento médio nas outras áreas da cidade. Para isso, você pode se basear no princípio da equidade para considerar justa tal necessidade de “priorizar” investimentos neste local.";

    public Analysis() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View layout = inflater.inflate(R.layout.fragment_analysis, container, false);

        analysisText = (TextView) layout.findViewById(R.id.analysisText);
        analysisText.setMovementMethod(new ScrollingMovementMethod());
        analysisText.setText(text);

        return layout;
    }


}
