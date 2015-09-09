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
    String text = "Você está no Núcleo de Saúde da Família 1, pela disciplina de ASC, e acompanha o Dr. Gaspar na consulta com Fabiano, Vitória e seus filhos.\n" +
            "Vitória: “Eu trouxe o Fabiano porque falaram que é bom o pai estar junto na consulta do bebê. Eu vou mudar pra casa dele, é lá no bairro Alagoas. Lá é ruim porque não tem posto de saúde nem creche. \n" +
            "Eu não sei cuidar direito deste mais novo, e sem creche com quem eu vou deixar as crianças pra ir trabalhar mais pra frente?”\n" +
            "Gaspar: “Sim, eu passo por lá quando chego de viagem. Tem muito lixo e esgoto a céu aberto. É onde mais precisaria de creche e serviços de saúde!”\n" +
            "Vitória: “Pois é! Mas esses políticos rouba tudo.”\n" +
            "Você: “Será que a gente não pode fazer algo pra ajudar?”\n" +
            "Fabiano: “Um vizinho meu representa nosso bairro lá na secretaria de saúde. Ele leva os problemas da gente pra lá, mas ninguém resolve.”\n" +
            "Gaspar termina de examinar as crianças, e vocês saem para discutir o caso da família.\n" +
            "Gaspar: “Você perguntou se poderíamos fazer algo. \n" +
            "Bom, vou te explicar como funciona o sistema de saúde, e vamos ver como você ajuda eles. No centro da cidade fica a secretaria municipal de saúde. Lá, o Conselho se reúne todo mês, e tem representantes da população de vários bairros (como o vizinho de Fabiano), além de profissionais de saúde e gestores. Eles discutem sobre o orçamento pra saúde, quais programas de saúde incentivar, enfim, sobre o planejamento de saúde da cidade.”\n" +
            "Você: “Tá... E daí?”\n" +
            "Gaspar: “Você pode enviar uma carta para esse Conselho, reivindicando melhorias naquele bairro. E para defender com mais peso sua reivindicação, seria importante você se embasar nos princípios do SUS. Você conhece os princípios?”";

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
