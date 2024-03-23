package com.example.pr3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public MainActivity() {
        super(R.layout.activity_main);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("some_int", 0);
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view,
                            ExampleFragment.class, bundle)
                    .commit();
        }
    }
}