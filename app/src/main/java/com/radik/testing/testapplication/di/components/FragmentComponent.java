package com.radik.testing.testapplication.di.components;

import com.radik.testing.testapplication.di.modules.ListFragmentModule;
import com.radik.testing.testapplication.di.scopes.FragmentScope;
import com.radik.testing.testapplication.presentation.MainContract;

import dagger.Component;

@FragmentScope
@Component(modules = {ListFragmentModule.class})
public interface FragmentComponent {

    @FragmentScope
    MainContract.Presenter getPresenter();

}
