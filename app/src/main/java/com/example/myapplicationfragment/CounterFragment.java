package com.example.myapplicationfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplicationfragment.databinding.ActivityMainBinding;
import com.example.myapplicationfragment.databinding.FragmentCounterBinding;

public class CounterFragment extends Fragment {
    private FragmentCounterBinding binding;
    private int counter = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCounterBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnCounter.setOnClickListener(v -> {
            counter++;
            binding.tvCounter.setText(String.valueOf(counter));
        });

        binding.btnResult.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putInt("key", counter);

            ResultFragment resultFragment = new ResultFragment();
            resultFragment.setArguments(bundle);

            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainerView, resultFragment)
                    .addToBackStack(null)
                    .commit();
        });
    }
}