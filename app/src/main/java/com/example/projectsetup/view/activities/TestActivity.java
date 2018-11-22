package com.example.projectsetup.view.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.projectsetup.R;

public class TestActivity extends BaseActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        backPress();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
    }
}