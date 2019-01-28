package com.radik.testing.testapplication.presentation;

import android.content.Context;

import com.radik.testing.testapplication.presentation.paging.AccountListAdapter;

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

    }
}
