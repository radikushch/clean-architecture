package com.radik.testing.testapplication.presentation;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.radik.testing.testapplication.R;


public class MainActivity extends AppCompatActivity {

    private final static String TAG = "mainActivityTag";

    private static final String TAG_LIST_FRAGMENT = "list_fragment";
    private AccountListFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showListFragment();
    }

    private void showListFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragment = (AccountListFragment) fragmentManager.findFragmentByTag(TAG_LIST_FRAGMENT);

        if(fragment == null) {
            fragment = new AccountListFragment();
            fragmentManager.beginTransaction().add(R.id.fragment_container, fragment, TAG_LIST_FRAGMENT).commit();
        }
    }
}
