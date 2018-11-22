package com.example.projectsetup.view.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;

import com.example.projectsetup.R;
import com.example.projectsetup.view.activities.BaseActivity;
import com.example.projectsetup.view.fragments.TestOneFragment;
import com.example.projectsetup.view.fragments.TestThreeFragment;
import com.example.projectsetup.view.fragments.TestTwoFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btnOne)
    Button btnOne;
    @BindView(R.id.btnTwo)
    Button btnTwo;
    @BindView(R.id.btnThree)
    Button btnThree;

    @Override
    public void onBackPressed() {
        backPress();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragmentNavigation(new TestOneFragment());
    }

    @OnClick({R.id.btnOne, R.id.btnTwo, R.id.btnThree})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnOne:
                fragmentNavigation(new TestOneFragment());
                break;
            case R.id.btnTwo:
                fragmentNavigation(new TestTwoFragment());
                break;
            case R.id.btnThree:
                fragmentNavigation(new TestThreeFragment());
                break;
        }
    }

    public void fragmentNavigation(Fragment fragment) {
        fragment(R.id.frame, fragment);
    }
}