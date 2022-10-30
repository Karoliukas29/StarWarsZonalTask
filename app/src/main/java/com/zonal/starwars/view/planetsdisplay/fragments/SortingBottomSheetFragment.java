package com.zonal.starwars.view.planetsdisplay.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.zonal.starwars.base.BaseBottomSheetDialogFragment;
import com.zonal.starwars.databinding.FragmentFilteringBottomSheetBinding;
import com.zonal.starwars.view.planetsdisplay.interfaces.OnSortSelected;

public class SortingBottomSheetFragment extends BaseBottomSheetDialogFragment<FragmentFilteringBottomSheetBinding> {

    private String sortByInFragment = "";
    private OnSortSelected onSortSelected;

    @Override
    public FragmentFilteringBottomSheetBinding getFragmentBinding(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentFilteringBottomSheetBinding.inflate(inflater, container, false);
        return binding;
    }

    public SortingBottomSheetFragment() {
        // Required empty public constructor
    }

    public SortingBottomSheetFragment(OnSortSelected onSortSelected) {
        this.onSortSelected = onSortSelected;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupClickListeners();
    }

    private void setupClickListeners(){
        binding.checkboxSortByName.setOnCheckedChangeListener((buttonView, isChecked) -> {
            sortByInFragment = "planetName";
        });

        binding.buttonSort.setOnClickListener(v -> {
            onSortSelected.OnSortCheckBoxSelected(sortByInFragment);
            dismiss();
        });

        binding.textviewCancel.setOnClickListener(view -> dismiss());
    }
}