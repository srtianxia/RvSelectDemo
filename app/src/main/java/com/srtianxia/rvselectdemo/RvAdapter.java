package com.srtianxia.rvselectdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by srtianxia on 2015/12/20.
 */
public class RvAdapter extends RecyclerView.Adapter<RvHolder>  {
    private List<String> items;
    private LayoutInflater inflater;
    private Context context;


    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public RvAdapter(Context context, List<String> items){
        this.items = items;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public RvHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item,parent,false);
        RvHolder holder = new RvHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RvHolder holder, final int position) {
        holder.setData(items.get(position),position);
        if (onItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(v,position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onItemClickListener.onItemLongClick(v,position);
                    return false;
                }
            });
        }
    }

    public void remove(String str){
        items.remove(str);
        notifyDataSetChanged();
    }

    public String getItem(int pos){
        return items.get(pos);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }



    public interface OnItemClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view,int position);
    }

}

