package com.example.myapplicationfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplicationfragment.databinding.FragmentCounterBinding;


public class ResultFragment extends Fragment {
    private FragmentCounterBinding binding;

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
        CounterFragment counterFragment = new CounterFragment();

        Bundle arguments = getArguments();
        if (arguments != null) {
            int counter = arguments.getInt("key", 0); // "0" — значение по умолчанию
            binding.tvCounter.setText("Result: " + counter);
        }

        binding.btnResult.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainerView, counterFragment);
            fragmentTransaction.addToBackStack(null).commit();
        });
    }
}