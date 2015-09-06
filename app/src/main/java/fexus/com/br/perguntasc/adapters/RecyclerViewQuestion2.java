package fexus.com.br.perguntasc.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import fexus.com.br.perguntasc.R;
import fexus.com.br.perguntasc.extras.InformationQuestion2;

public class RecyclerViewQuestion2 extends RecyclerView.Adapter<RecyclerViewQuestion2.MyViewHolder> {

    private LayoutInflater inflater;
    List<InformationQuestion2> data = Collections.emptyList();

    public RecyclerViewQuestion2(Context context, List<InformationQuestion2> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.custom_layout_question2, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        InformationQuestion2 currentInformationQuestion2 = data.get(position);
        holder.number.setText(String.valueOf(currentInformationQuestion2.number) + ")  ");
        holder.text.setText(currentInformationQuestion2.answer);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView number, text;

        public MyViewHolder(View itemView) {
            super(itemView);
            number = (TextView) itemView.findViewById(R.id.question2Number);
            text = (TextView) itemView.findViewById(R.id.question2Text);
        }
    }
}
