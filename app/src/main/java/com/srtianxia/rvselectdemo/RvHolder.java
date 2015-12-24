package com.srtianxia.rvselectdemo;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.Set;

/**
 * Created by srtianxia on 2015/12/20.
 */
class RvHolder extends RecyclerView.ViewHolder  {
    private TextView textView;

    public RvHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.tv);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void setData(String item, int position){
        Set<Integer> positionSet = MainActivity.instance.positionSet;
        if (positionSet.contains(position)) {
            itemView.setBackground(MainActivity.instance.getResources().getDrawable(R.drawable.bg_selected));
        } else {
            itemView.setBackground(MainActivity.instance.getResources().getDrawable(R.drawable.btn_common));
        }
        textView.setText(item);
    }

}
