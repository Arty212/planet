package com.example.arturbaboskin.planet;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlanetListAdapter extends RecyclerView.Adapter<PlanetListAdapter.ViewHolder>{

    interface OnClickListener{
        void onClick(Planet planet);
    }

    private ArrayList<Planet> data;
    private OnClickListener callback;


    public PlanetListAdapter(OnClickListener callback) {
        this.callback = callback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_planet, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(holder.view.getContext())
                .load(data.get(position).bitmapUrl).into(holder.img);
        holder.name.setText(data.get(position).name);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        if (data != null)
            return data.size();
        else
            return 0;
    }

    public void setData(ArrayList<Planet> data) {
        this.data = data;
        this.notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        View view;
        @BindView(R.id.ico)
        ImageView img;
        @BindView(R.id.name)
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this,view);
        }
    }
}
