package fexus.com.br.perguntasc.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fexus.com.br.perguntasc.R;

public class Cases extends Fragment {

    TextView caseText;
    String text = "Encontramos menções de Medicina Social desde o século XVIII. Na Alemanha, Inglaterra,  França, citando alguns exemplos, já desenvolviam-se modelos institucionalizados de medidas sociais relacionadas à saúde, de acordo com as necessidades de cada lugar.\n" +
            "Verdadeiramente, a  Medicina Social surgiu  através das necessidades que ligam ações sanitaristas como: desinfecção urbana, atendimento e acompanhamento da população de baixa renda e menos favorecida e de trabalhadores em geral, regulamentação de residências e centros urbanos, controle higiênico em prisões, hospitais e outros lugares públicos, à ações onde haveria uma maior possibilidade de saúde, organização, conforto, arborização, enfim, modificações que objetivavam um mais harmonioso e inteligente desenvolvimento urbano.\n" +
            "\n" +
            "Com o advento da Medicina Social, observa-se também a organização das cidades, adequando-se populações com princípios diretos de higienização, salubridade, controle dos transportes e de diversos  animais, tarefas domésticas e destino correto do lixo em geral.\n" +
            "\n" +
            "Veremos também que, na época da origem da Medicina Social a preocupação com a descontaminação do ar e da água tornou-se muito grande e geral. Os médicos, também desenvolvendo a função de administradores em saúde, identificavam agentes de contaminação desses dois elementos, os quais eram causadores da disseminação de doenças. Desta forma, procuraram sistemas que permitiriam, uma melhor destinação de dejetos, alargamento de ruas para melhor circulação do ar, e criação de projetos nas cidades ligados intimamente com a  urbanização.\n" +
            "\n" +
            "Com todas essas ações a Medicina Social buscava construir uma saúde urbana mais   centrada em objetivos e resultados que levariam à cidades mais limpas, organizadas, com ações de higiene e sanitaristas, que consequentemente teriam uma população mais saudável e socialmente mais bem vista.";

    public Cases() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View layout = inflater.inflate(R.layout.fragment_cases, container, false);

        caseText = (TextView) layout.findViewById(R.id.caseText);
        caseText.setMovementMethod(new ScrollingMovementMethod());
        caseText.setText(text);

        return layout;
    }

}
