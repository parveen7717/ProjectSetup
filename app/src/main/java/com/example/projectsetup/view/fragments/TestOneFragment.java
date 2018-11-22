package com.example.projectsetup.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projectsetup.R;
import com.example.projectsetup.view.activities.MainActivity;
import com.example.projectsetup.view.activities.TestActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class TestOneFragment extends Fragment {
    @BindView(R.id.textView)
    TextView textView;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_one_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.textView)
    public void onViewClicked(View view) {
        if (getActivity()!=null){
            ((MainActivity)getActivity()).intentWithoutFinish(TestActivity.class);
        }
    }
}