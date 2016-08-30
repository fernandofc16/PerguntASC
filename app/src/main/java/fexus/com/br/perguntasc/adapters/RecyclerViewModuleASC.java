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
import fexus.com.br.perguntasc.animations.AnimationUtils;
import fexus.com.br.perguntasc.extras.InformationModuleASC;

public class RecyclerViewModuleASC extends RecyclerView.Adapter<RecyclerViewModuleASC.MyViewHolder> {

    private LayoutInflater inflater;
    private int previousPosition = 0;
    List<InformationModuleASC> data = Collections.emptyList();

    public RecyclerViewModuleASC(Context context, List<InformationModuleASC> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.custom_layout_module_asc, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        InformationModuleASC currentInformationRanking = data.get(holder.getAdapterPosition());
        holder.text.setText(currentInformationRanking.getName());

        if(holder.getAdapterPosition() > previousPosition) {
            AnimationUtils.animate(holder, true);
        } else {
            AnimationUtils.animate(holder, false);
        }

        previousPosition = holder.getAdapterPosition();

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text;

        public MyViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.moduleASCName);
        }
    }
}
