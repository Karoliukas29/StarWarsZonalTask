package com.zonal.starwars.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewbinding.ViewBinding;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.zonal.starwars.R;
import com.zonal.starwars.view.planetsdisplay.fragments.SortingBottomSheetFragment;

import dagger.hilt.android.internal.managers.FragmentComponentManager;


public abstract class BaseBottomSheetDialogFragment<VB extends ViewBinding> extends BottomSheetDialogFragment {
    public VB binding = null;
    public NavController navController = null;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        if (binding == null) {
            binding = getFragmentBinding(inflater, container);
        }

        NavHostFragment navHostFragment =
                (NavHostFragment) requireActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        if (navHostFragment != null){
            navController = navHostFragment.getNavController();
        }
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        return binding.getRoot();

    }

    public abstract VB getFragmentBinding(LayoutInflater inflater, ViewGroup container);

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setOnShowListener(dialog1 -> {
            BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialog1;
            if (!(binding instanceof SortingBottomSheetFragment)){
                setupRatio(bottomSheetDialog);
            }
        });
        return dialog;
    }

    private void setupRatio(BottomSheetDialog bottomSheetDialog) {
        FrameLayout bottomSheet = (FrameLayout) bottomSheetDialog.findViewById(R.id.design_bottom_sheet);
        BottomSheetBehavior<FrameLayout> behavior = BottomSheetBehavior.from(bottomSheet);
        ViewGroup.LayoutParams layoutParams = bottomSheet.getLayoutParams();
        layoutParams.height = getBottomSheetDialogDefaultHeight();
        bottomSheet.setLayoutParams(layoutParams);
        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    private int getBottomSheetDialogDefaultHeight() {
        return getWindowHeight() * 97 / 100;
    }

    private int getWindowHeight() {
        // Calculate window height for fullscreen use
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) FragmentComponentManager.findActivity(getContext())).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
