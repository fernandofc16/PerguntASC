package fexus.com.br.perguntasc.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import fexus.com.br.perguntasc.R;
import fexus.com.br.perguntasc.extras.InformationQuestion1;

public class RecyclerViewQuestion1 extends RecyclerView.Adapter<RecyclerViewQuestion1.MyViewHolder> {

    private LayoutInflater inflater;
    List<InformationQuestion1> data = Collections.emptyList();

    public RecyclerViewQuestion1(Context context, List<InformationQuestion1> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.custom_layout_question1, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        InformationQuestion1 currentInformationQuestion1 = data.get(position);
        holder.number.setText(String.valueOf(currentInformationQuestion1.number) + ")  ");
        holder.text.setText(currentInformationQuestion1.answer);
        holder.selected = currentInformationQuestion1.selected;

        if(holder.selected) {
            holder.layout.setBackgroundColor(Color.parseColor("#006099"));
        } else {
            holder.layout.setBackgroundColor(Color.parseColor("#006060"));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView number, text;
        LinearLayout layout;
        boolean selected;

        public MyViewHolder(View itemView) {
            super(itemView);
            number = (TextView) itemView.findViewById(R.id.question1Number);
            text = (TextView) itemView.findViewById(R.id.question1Text);
            layout = (LinearLayout) itemView.findViewById(R.id.layoutQuestion1);
        }
    }
}
