package com.sani.shahid.remotejobtest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class HallListAdapter extends RecyclerView.Adapter<HallListAdapter.ViewHolder> {

    private List<Hall> hallList;
    private OnclickListener onclickListener;
    private Context context;

    HallListAdapter(Context context, List<Hall> hallList, OnclickListener onclickListener) {
        this.hallList = hallList;
        this.onclickListener = onclickListener;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickListener.onItemClick(viewHolder.getAdapterPosition());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HallListAdapter.ViewHolder holder, int position) {
        holder.cinemaName.setText(hallList.get(position).getName());
        holder.movieTime.setText(hallList.get(position).getTime());
        holder.numberOfScreens.setText(String.valueOf(hallList.get(position).getNumOfScreen()));
    }

    @Override
    public int getItemCount() {
        if (hallList.isEmpty()){
            return 0;
        }else {
            return hallList.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        final View mView;

        public TextView cinemaName, movieTime, numberOfScreens;

        public ViewHolder(View itemView) {
            super(itemView);

            mView = itemView;

            cinemaName = mView.findViewById(R.id.hallName);
            movieTime = mView.findViewById(R.id.movieTime);
            numberOfScreens = mView.findViewById(R.id.numberofScreens);
        }
    }
}
