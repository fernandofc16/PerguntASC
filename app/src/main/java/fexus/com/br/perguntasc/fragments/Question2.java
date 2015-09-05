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
public class Question2 extends Fragment {


    public Question2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question2, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button answer2 = (Button) view.findViewById(R.id.answerButtonQ2);

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TabsAdapterQuestionsModuleASC.question2Answered = true;
                Toast.makeText(getActivity().getApplicationContext(), "Questão 2 respondida" + "\nquestion2Answered = " + TabsAdapterQuestionsModuleASC.question2Answered, Toast.LENGTH_SHORT).show();
            }
        });
    }


}
