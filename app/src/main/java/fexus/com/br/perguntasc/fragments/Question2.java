package fexus.com.br.perguntasc.fragments;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fexus.com.br.perguntasc.R;
import fexus.com.br.perguntasc.activities.ModuleAscQuizActivity1;
import fexus.com.br.perguntasc.adapters.RecyclerViewQuestion2;
import fexus.com.br.perguntasc.extras.InformationQuestion2;

/**
 * A simple {@link Fragment} subclass.
 */
public class Question2 extends Fragment {

    static boolean answered;
    static int answer;

    static String[] asnwers = {"Embora seja diretriz constitucional, a participação da comunidade no SUS ainda não foi implantada, devido às dificuldades de financiamento",
                               "A participação da comunidade no SUS é feita por meio das Conferências e Conselhos de Saúde, nos níveis nacional, estaduais, municipais"};

    static String question2 = "Declaração de Alma-Ata, promulgada pela Organização Mundial de Saúde (OMS) em 1978, afirma que as ações primárias de saúde pressupõem a participação da comunidade em seu planejamento, organização, execução e controle. Com base nos princípios e no funcionamento atual do SUS:";
    static TextView question2View;

    static boolean[] correctAnswer = { false, false, true, false };
    static int[] numbers = {1, 2};

    public Question2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        answer = 0;
        answered = false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_question2, container, false);

        question2View = (TextView) layout.findViewById(R.id.question2Text);

        question2View.setText(question2);

        RecyclerView recyclerView = (RecyclerView) layout.findViewById(R.id.question2List);

        RecyclerViewQuestion2 adapter = new RecyclerViewQuestion2(getActivity(), getData());

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {

            @Override
            public void onClick(View view, int position) {
                LinearLayout answerColor = (LinearLayout) view.findViewById(R.id.layoutQuestion2);
                if(answered) {
                    if (answer != (position + 1)) {
                        Toast.makeText(getActivity().getApplicationContext(), "Apenas uma resposta pode ser selecionada por questão", Toast.LENGTH_SHORT).show();
                    } else {
                        answerColor.setBackgroundColor(Color.parseColor("#006060"));
                        answered = false;
                        answer = 0;
                        ModuleAscQuizActivity1.answer2 = answer;
                        //Toast.makeText(getActivity(), "answer2: " + answer, Toast.LENGTH_SHORT).show();

                    }
                } else {
                    answerColor.setBackgroundColor(Color.parseColor("#006099"));
                    answered = true;
                    answer = position + 1;
                    ModuleAscQuizActivity1.answer2 = answer;
                    ModuleAscQuizActivity1.checkQuestionsAnswered(getActivity().getApplicationContext());
                    //Toast.makeText(getActivity(), "answer2: " + answer, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getActivity(), "onLongClick " + position, Toast.LENGTH_SHORT).show();
            }

        }));

        return layout;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public static List<InformationQuestion2> getData() {

        List<InformationQuestion2> data = new ArrayList<>();

        for(int i=0; i < asnwers.length && i < numbers.length; i++) {
            InformationQuestion2 current = new InformationQuestion2();
            current.setNumber(numbers[i]);
            current.setAnswer(asnwers[i]);
            current.setCorrect(correctAnswer[i]);
            data.add(current);
        }

        return data;
    }

    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){

                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());

                    if(child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if(child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildAdapterPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }

        public interface ClickListener {
            void onClick(View view, int position);
            void onLongClick(View view, int position);
        }

    }

}
