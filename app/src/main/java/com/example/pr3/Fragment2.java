package com.example.pr3;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.pr3.databinding.Fragment2Binding;

public class Fragment2 extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            getChildFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(
                            R.id.fragment_container,
                            Fragment3.class,
                            null
                    )
                    .commit();

        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Fragment2Binding binding = Fragment2Binding.inflate(inflater, container, false);
        getChildFragmentManager()
                .setFragmentResultListener("requestKey", this, ((requestKey, result) -> {
                    binding.textView.setText(result.getString("bundleKey"));
                }));
        return binding.getRoot();
    }
}