package fexus.com.br.perguntasc.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import fexus.com.br.perguntasc.R;
import fexus.com.br.perguntasc.adapters.TabsAdapterQuestionsModuleASC;

/**
 * A simple {@link Fragment} subclass.
 */
public class Question1 extends Fragment {


    public Question1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_question1, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button answer1 = (Button) view.findViewById(R.id.answerButtonQ1);

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TabsAdapterQuestionsModuleASC.question1Answered = true;
                Toast.makeText(getActivity().getApplicationContext(), "Questão 1 respondida" + "\nquestion1Answered = " + TabsAdapterQuestionsModuleASC.question1Answered, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
