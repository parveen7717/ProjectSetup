package com.example.projectsetup.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

abstract public class BaseActivity extends AppCompatActivity {
    public FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = this.getSupportFragmentManager();
    }

    public void backPress() {
        if (fragmentManager.getBackStackEntryCount() <= 1) {
            this.finish();
        } else {
            fragmentManager.popBackStack();
        }
    }

    public void clearAllFrag() {
        for (int i = 0; i < fragmentManager.getBackStackEntryCount(); ++i) {
            fragmentManager.popBackStack();
        }
    }

    public void fragment(int containerBody, Fragment fragment) {
        replaceFragment(containerBody, fragment);
    }

    private void replaceFragment(int containerBody, Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        boolean fragmentPopped = this.fragmentManager.popBackStackImmediate(backStateName, 0);
        if (!fragmentPopped && this.getSupportFragmentManager().findFragmentByTag(backStateName) == null) {
            FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
            /* can implement animation */
            // fragmentTransaction.setCustomAnimations(R.animator.fadein, R.animator.fadeout, R.animator.fadein, R.animator.fadeout);
            fragmentTransaction.replace(containerBody, fragment, backStateName);
            fragmentTransaction.addToBackStack(backStateName);
            fragmentTransaction.commit();
        }
    }

    public void withoutBackStack(int containerBody, Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(containerBody, fragment);
        fragmentTransaction.commit();
    }

    public void intentWithFinish(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        this.startActivity(intent);
        this.finish();
    }

    public void intentWithoutFinish(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        this.startActivity(intent);
    }

    public void intentWithoutTransition(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        this.startActivity(intent);
        this.finish();
        this.overridePendingTransition(0, 0);
    }

    public void intentWithBundle(Class activityClass, Bundle bundle) {
        Intent intent = new Intent(this, activityClass);
        intent.putExtras(bundle);
        this.startActivity(intent, bundle);
    }

}