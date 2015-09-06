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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fexus.com.br.perguntasc.R;
import fexus.com.br.perguntasc.activitys.ModuleAscQuizActivity1;
import fexus.com.br.perguntasc.adapters.RecyclerViewQuestion1;
import fexus.com.br.perguntasc.extras.InformationQuestion1;

/**
 * A simple {@link Fragment} subclass.
 */
public class Question1 extends Fragment {

    static boolean answered = false;
    static int answer = 0;
    static String[] asnwers = {"Resposta 1", "Resposta 2", "Resposta 3", "Resposta 4"};
    static int[] numbers = {1, 2, 3, 4};

    public Question1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View layout = inflater.inflate(R.layout.fragment_question1, container, false);

        RecyclerView recyclerView = (RecyclerView) layout.findViewById(R.id.question1List);

        RecyclerViewQuestion1 adapter = new RecyclerViewQuestion1(getActivity(), getData());

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {

            @Override
            public void onClick(View view, int position) {
                LinearLayout answerColor = (LinearLayout) view.findViewById(R.id.layoutQuestion1);
                if(answered) {
                    if (answer != (position + 1)) {
                        Toast.makeText(getActivity().getApplicationContext(), "Apenas uma resposta pode ser selecionada por questão", Toast.LENGTH_SHORT).show();
                    } else {
                        answerColor.setBackgroundColor(Color.parseColor("#006060"));
                        answered = false;
                        answer = 0;
                    }
                } else {
                    answerColor.setBackgroundColor(Color.parseColor("#006099"));
                    answered = true;
                    answer = position + 1;
                }
                ModuleAscQuizActivity1.answer1 = answer;
                ModuleAscQuizActivity1.checkQuestionsAnswered(getActivity().getApplicationContext());
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

    public static List<InformationQuestion1> getData() {

        List<InformationQuestion1> data = new ArrayList<>();

        for(int i=0; i < asnwers.length && i < numbers.length; i++) {
            InformationQuestion1 current = new InformationQuestion1();
            current.number = numbers[i];
            current.answer = asnwers[i];
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
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if(child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }

        public static interface ClickListener {
            public void onClick(View view, int position);
            public void onLongClick(View view, int position);
        }

    }

}
