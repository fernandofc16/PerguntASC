package fexus.com.br.perguntasc.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fexus.com.br.perguntasc.R;
import fexus.com.br.perguntasc.adapters.RecyclerViewRanking;
import fexus.com.br.perguntasc.extras.InformationRanking;

public class Ranking extends Fragment {

    public Ranking() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Indicate that this fragment would like to influence the set of actions in the action bar.
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_ranking, container, false);

        RecyclerView recyclerView = (RecyclerView) layout.findViewById(R.id.rankingList);

        RecyclerViewRanking adapter = new RecyclerViewRanking(getActivity(), getData());

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return layout;
    }


    public static List<InformationRanking> getData() {

        List<InformationRanking> data = new ArrayList<>();

        String[] positions = { "1º ", "2º ", "3º ", "4º ", "5º ", "6º ", "7º ", "8º ", "9º ", "10º" };
        String[] profilePicturesId = { "777637332331539", "892473870815110", "100001214976629", "1766424992", "1411025269", "100002727294468", "100000883164741", "1547204626", "100002187255916", "623439890" };
        String[] names = { "Fernando Ferreira", "Sandra Ferreira", "Frederico Vilela", "Lívia Ciabati", "Sarah Guadagnin", "Gabriela Lobato", "Thais Helena de Paula", "William Dias Ferreira", "José Carlos Moraes", "Miki Nakamura" };
        String[] scores = { "500", "400", "300", "200", "100", "50", "40", "30", "20", "10" };

        for(int i=0; i < names.length && i < scores.length && i < profilePicturesId.length; i++) {
            InformationRanking current = new InformationRanking();
            current.name = names[i];
            current.score = scores[i];
            current.profilePictureId = profilePicturesId[i];
            current.position = positions[i];
            data.add(current);
        }

        return data;
    }

}
