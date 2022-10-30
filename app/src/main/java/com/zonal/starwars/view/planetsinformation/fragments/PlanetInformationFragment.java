package com.zonal.starwars.view.planetsinformation.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zonal.starwars.R;
import com.zonal.starwars.base.BaseFragment;
import com.zonal.starwars.databinding.FragmentPlanetInformationBinding;
import com.zonal.starwars.model.Planet;
import com.zonal.starwars.utilities.Const;

public class PlanetInformationFragment extends BaseFragment<FragmentPlanetInformationBinding>{
        private Planet planetItem;

        @Override
        public FragmentPlanetInformationBinding getFragmentBinding(LayoutInflater inflater, ViewGroup container) {
            binding = FragmentPlanetInformationBinding.inflate(inflater, container, false);
            return binding;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getExtras();
        }


    @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            setTexts();
        }

    private void getExtras() {
        if (getArguments() != null){
            planetItem = getArguments().getParcelable(Const.PLANET_ITEM);
        }
    }

    @SuppressLint("SetTextI18n")
    private void setTexts(){
    binding.tvPlanetName.setText(requireContext()
            .getString(R.string.name) + ": " + planetItem.getName());
    binding.tvPlanetPopulation.setText(requireContext()
            .getString(R.string.planet_population) + ": " + planetItem.getPopulation());
    binding.tvPlanetClimate.setText(requireContext()
            .getString(R.string.planet_climate) + ": "+ planetItem.getClimate());
    binding.tvPlanetDiameter.setText(requireContext()
            .getString(R.string.planet_diameter)+ ": " + planetItem.getDiameter());
    binding.tvPlanetGravity.setText(requireContext()
            .getString(R.string.planet_gravity) + ": "+ planetItem.getGravity());
    binding.tvPlanetRotationPeriod.setText(requireContext()
            .getString(R.string.rotation_period)+ ": " + planetItem.getRotation_period());
    binding.tvPlanetSurfaceWater.setText(requireContext()
            .getString(R.string.surface_water)+ ": " + planetItem.getSurface_water());
    binding.tvPlanetTerrain.setText(requireContext()
            .getString(R.string.planets_terrain) + ": "+ planetItem.getTerrain());

    }

    }
