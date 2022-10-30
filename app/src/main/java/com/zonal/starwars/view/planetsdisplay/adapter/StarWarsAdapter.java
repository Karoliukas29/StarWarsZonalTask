package com.zonal.starwars.view.planetsdisplay.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.zonal.starwars.databinding.ListItemPlanetBinding;
import com.zonal.starwars.model.Planet;

import java.util.ArrayList;
import java.util.List;

public class StarWarsAdapter extends RecyclerView.Adapter<StarWarsAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Planet item);
    }

    private final List<Planet> planetList = new ArrayList<>();
    private List<Planet> listOfPlanets;
    private final OnItemClickListener listener;

    public StarWarsAdapter(List<Planet> listOfPlanets, OnItemClickListener listener) {
        this.listOfPlanets = listOfPlanets;
        this.listener = listener;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(ListItemPlanetBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(planetList.get(position), listener);
    }

    @Override public int getItemCount() {
        return planetList.size();
    }

    public void setPlanetList(List<Planet> items) {
        planetList.clear();
        planetList.addAll(items);
        listOfPlanets = planetList;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final ListItemPlanetBinding binding;

        public ViewHolder(ListItemPlanetBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(final Planet item, final OnItemClickListener listener) {
            binding.planetName.setText(item.getName());
            binding.planetPopulation.setText(item.getPopulation());
            itemView.setOnClickListener(v -> listener.onItemClick(item));
        }
    }
}