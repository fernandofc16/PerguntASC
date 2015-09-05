/**
 * Created by Fernando on 09/06/2015.
 */

package fexus.com.br.perguntasc.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.login.widget.ProfilePictureView;

import java.util.Collections;
import java.util.List;

import fexus.com.br.perguntasc.R;
import fexus.com.br.perguntasc.animations.AnimationUtils;
import fexus.com.br.perguntasc.extras.InformationRanking;

public class RecyclerViewRanking extends RecyclerView.Adapter<RecyclerViewRanking.MyViewHolder> {

    private LayoutInflater inflater;
    private int previousPosition = 0;
    List<InformationRanking> data = Collections.emptyList();

    public RecyclerViewRanking(Context context, List<InformationRanking> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.custom_layout_ranking, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        InformationRanking currentInformationRanking = data.get(position);
        holder.position.setText(currentInformationRanking.position);
        holder.text.setText(currentInformationRanking.name + "\n" + currentInformationRanking.score);
        holder.profilePictureView.setProfileId(currentInformationRanking.profilePictureId);


            if (position > previousPosition) {
                AnimationUtils.animate(holder, true);
            } else {
                AnimationUtils.animate(holder, false);
            }

        previousPosition = position;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text, position;
        ProfilePictureView profilePictureView;

        public MyViewHolder(View itemView) {
            super(itemView);

            position = (TextView) itemView.findViewById(R.id.textPosition);
            text = (TextView) itemView.findViewById(R.id.textView);
            profilePictureView = (ProfilePictureView) itemView.findViewById(R.id.profilePicture);
        }
    }
}
