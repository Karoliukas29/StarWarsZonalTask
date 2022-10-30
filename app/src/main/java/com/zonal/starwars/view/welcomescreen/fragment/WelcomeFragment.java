package com.zonal.starwars.view.welcomescreen.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.airbnb.lottie.LottieDrawable;
import com.zonal.starwars.R;
import com.zonal.starwars.base.BaseFragment;
import com.zonal.starwars.databinding.FragmentWelcomeBinding;

public class WelcomeFragment extends BaseFragment<FragmentWelcomeBinding> {

    @Override
    public FragmentWelcomeBinding getFragmentBinding(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false);
        return binding;
    }

    public WelcomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initClickListeners();
    }

    private void initView() {
        setAnimation("spaceride.json");

    }
    private void initClickListeners(){
        binding.btnGetPlanets.setOnClickListener(v -> {
//            Intent intent = new Intent(requireActivity(), StarWarsActivity.class);
//            startActivity(intent);
            navController.navigate(R.id.action_welcomeFragment_to_startWarsPlanetsFragment);
        });
    }

    public void setAnimation(String animation) {
        binding.lottieAnimationView.setAnimation(animation);
        binding.lottieAnimationView.setVisibility(View.VISIBLE);
        binding.lottieAnimationView.setRepeatCount(LottieDrawable.INFINITE);
        binding.lottieAnimationView.setScaleType(ImageView.ScaleType.FIT_XY);
        binding.lottieAnimationView.playAnimation();
    }
}