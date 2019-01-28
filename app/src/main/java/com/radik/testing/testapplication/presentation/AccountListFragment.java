package com.radik.testing.testapplication.presentation;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.radik.testing.testapplication.R;
import com.radik.testing.testapplication.presentation.paging.AccountListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AccountListFragment extends Fragment implements MainContract.FragmentView {

    private static final String TAG = "listFragment";
    private MainContract.Presenter presenter;
    private boolean isInitDone;


    @BindView(R.id.recycler_view) RecyclerView listRecyclerView;
    @BindView(R.id.progress_bar)  ProgressBar listProgressBar;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        presenter = new MainPresenter(this);
        isInitDone = false;
        presenter.create();
        Log.e(TAG, "onCreate: " );
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_fragment, null);
        ButterKnife.bind(this, v);
        if(!isInitDone) showLoading();
        init();
        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
        presenter.destroy();
    }

    private void init() {
        listRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        listRecyclerView.setHasFixedSize(true);
    }

    @Override
    public void showLoading() {
        listRecyclerView.setVisibility(View.GONE);
        listProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        listRecyclerView.setVisibility(View.VISIBLE);
        listProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onLoadSuccess(AccountListAdapter adapter) {
        isInitDone = true;
        listRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onLoadError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context context() {
        return getActivity();
    }

}
