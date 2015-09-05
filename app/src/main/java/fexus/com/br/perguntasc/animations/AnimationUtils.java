package fexus.com.br.perguntasc.animations;

import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Fernando
 */
public class AnimationUtils {

    public static void animate(RecyclerView.ViewHolder holder, boolean goesDown) {
        ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(holder.itemView, "translationY", goesDown ? 100 : -100, 0);
        animatorTranslateY.setDuration(300);
        animatorTranslateY.start();
    }

}
