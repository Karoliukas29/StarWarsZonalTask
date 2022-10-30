package com.zonal.starwars.view.planetsdisplay.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.zonal.starwars.R;
import com.zonal.starwars.base.BaseFragment;
import com.zonal.starwars.databinding.FragmentStarwarsBinding;
import com.zonal.starwars.model.Planet;
import com.zonal.starwars.presenter.starwarspresenter.StarWarsPresenter;
import com.zonal.starwars.presenter.starwarspresenter.StarWarsPresenterImpl;
import com.zonal.starwars.utilities.Const;
import com.zonal.starwars.view.planetsdisplay.adapter.StarWarsAdapter;
import com.zonal.starwars.view.planetsdisplay.interfaces.StarWarsView;

import java.util.Comparator;
import java.util.List;

public class StarWarsFragment extends BaseFragment<FragmentStarwarsBinding> implements StarWarsView {

    private StarWarsPresenter starWarsPresenter;
    private StarWarsAdapter starWarsAdapter;
    private SortingBottomSheetFragment sortingBottomSheetFragment;
    private List<Planet> planetList;
    private List<Planet> refreshedList;

    @Override
    public FragmentStarwarsBinding getFragmentBinding(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentStarwarsBinding.inflate(inflater, container, false);
        return binding;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        startLoading();
        setAdapter();
        starWarsPresenter = new StarWarsPresenterImpl(this, requireActivity());
        initClickListeners();
    }

    @SuppressLint("NotifyDataSetChanged")
    private void setAdapter(){
        binding.recyclerViewPlanets.setLayoutManager(new LinearLayoutManager(requireActivity()));
        binding.recyclerViewPlanets.addItemDecoration(new DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL));
        starWarsAdapter = new StarWarsAdapter(planetList, item -> {
           Bundle planetBundle = new Bundle();
           planetBundle.putParcelable(Const.PLANET_ITEM, item);
           navController.navigate(R.id.action_startWarsPlanetsFragment_to_startWarsPlanetsInformationFragment, planetBundle);
        });
        starWarsAdapter.notifyDataSetChanged();
        binding.recyclerViewPlanets.setAdapter(starWarsAdapter);
        binding.recyclerViewPlanets.invalidate();
    }


    @Override
    public void setPlanets(List<Planet> planetList) {
        starWarsAdapter.setPlanetList(planetList);
        this.planetList = planetList;
        this.refreshedList = planetList;
        if (planetList.size() > 0){
            dismissLoading();
            binding.buttonSort.setVisibility(View.VISIBLE);
        }
    }

    private void initClickListeners(){
        binding.buttonSort.setOnClickListener(view -> {
             actionSort();
        });
            binding.swipeRefreshOut.setOnRefreshListener(() -> {
                starWarsPresenter = new StarWarsPresenterImpl(this, requireActivity());
                starWarsAdapter.setPlanetList(refreshedList);
                binding.swipeRefreshOut.setRefreshing(false);
            });
    }

    private void actionSort(){
       sortingBottomSheetFragment = new SortingBottomSheetFragment(sortBy -> {
           if (sortBy.equals("planetName")) {
               planetList.sort(Comparator.comparing(Planet::getName));
           }
           starWarsAdapter.setPlanetList(planetList);
       });
       sortingBottomSheetFragment.show(getChildFragmentManager(), "TAG");
    }


    private void startLoading() {
        binding.progressBarSavings.setVisibility(View.VISIBLE);
    }

    private void dismissLoading() {
        binding.progressBarSavings.setVisibility(View.GONE);
    }
}
