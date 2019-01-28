package com.radik.testing.testapplication.presentation;

import android.arch.lifecycle.LifecycleObserver;
import android.content.Context;

import com.radik.testing.testapplication.domain.model.Account;
import com.radik.testing.testapplication.presentation.paging.AccountListAdapter;

import java.io.Serializable;
import java.util.List;

public interface MainContract {

    interface FragmentView {
        void showLoading();
        void hideLoading();

        void onLoadSuccess(AccountListAdapter adapter);
        void onLoadError(String message);


        Context context();
    }

    interface Presenter {

        void loadAccountsFromServer();
        void destroy();
        void create();
        void configChanged();

    }
}
