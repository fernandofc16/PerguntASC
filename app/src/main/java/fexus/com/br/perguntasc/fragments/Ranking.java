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
        String[] profilePicturesId = { Login.profile.getId(), "", "", "", "", "", "", "", "", "" };
        String[] names = { Login.profile.getName(), "Pessoa 2", "Pessoa 3", "Pessoa 4", "Pessoa 5", "Pessoa 6", "Pessoa 7", "Pessoa 8", "Pessoa 9", "Pessoa 10" };
        String[] scores = { "500", "400", "300", "200", "100", "50", "40", "30", "20", "10" };

        for(int i=0; i < names.length && i < scores.length && i < profilePicturesId.length; i++) {
            InformationRanking current = new InformationRanking();
            current.setName(names[i]);
            current.setScore(scores[i]);
            current.setProfilePictureId(profilePicturesId[i]);
            current.setPosition(positions[i]);
            data.add(current);
        }

        return data;
    }

}
