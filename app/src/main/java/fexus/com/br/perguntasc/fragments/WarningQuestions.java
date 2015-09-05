package fexus.com.br.perguntasc.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fexus.com.br.perguntasc.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WarningQuestions extends Fragment {


    public WarningQuestions() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_warning_questions, container, false);
    }


}
