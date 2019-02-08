package com.radik.testing.testapplication.di.modules;

import com.radik.testing.testapplication.di.scopes.FragmentScope;
import com.radik.testing.testapplication.presentation.AccountListFragment;
import com.radik.testing.testapplication.presentation.MainContract;
import com.radik.testing.testapplication.presentation.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ListFragmentModule {

    private AccountListFragment fragment;

    public ListFragmentModule(AccountListFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public MainContract.FragmentView provideFragment() {
        return fragment;
    }

    @Provides
    @FragmentScope
    public MainContract.Presenter providePresenter() {
        return new MainPresenter(fragment);
    }
}
