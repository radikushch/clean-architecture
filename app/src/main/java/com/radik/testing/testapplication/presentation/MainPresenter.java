package com.radik.testing.testapplication.presentation;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.paging.PagedList;
import android.util.Log;

import com.radik.testing.testapplication.data.repository.AccountRepositoryImpl;
import com.radik.testing.testapplication.domain.model.Account;
import com.radik.testing.testapplication.domain.repository.AccountRepository;
import com.radik.testing.testapplication.domain.usecases.database.CreateAccountTableUseCase;
import com.radik.testing.testapplication.domain.usecases.database.GetAccountDataUseCase;
import com.radik.testing.testapplication.domain.usecases.web.LoadAccountSchemeUseCase;
import com.radik.testing.testapplication.domain.usecases.web.LoadAccountDataUseCase;
import com.radik.testing.testapplication.domain.usecases.database.SaveAccountDataUseCase;
import com.radik.testing.testapplication.presentation.paging.AccountDiffUtilCallback;
import com.radik.testing.testapplication.presentation.paging.AccountListAdapter;
import com.radik.testing.testapplication.presentation.paging.MainThreadExecutor;
import com.radik.testing.testapplication.presentation.paging.MyPositionalDataSource;

import java.util.concurrent.Executors;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainContract.Presenter {

    private static final String TAG = "mainPresenterTag";

    public static final int LIMIT = 40;

    private MainContract.FragmentView view;
    private AccountRepository repository;
    private Disposable disposable;

    public MainPresenter(MainContract.FragmentView view) {
        this.view = view;
        repository = new AccountRepositoryImpl();
    }

    @Override
    public void create() {
        loadAccountsFromServer();
    }

    public void loadAccountsFromServer() {
        LoadAccountSchemeUseCase loadFieldsUseCase = new LoadAccountSchemeUseCase(repository);
        CreateAccountTableUseCase createTableUseCase = new CreateAccountTableUseCase(repository);
        LoadAccountDataUseCase loadRecordsUseCase = new LoadAccountDataUseCase(repository);
        SaveAccountDataUseCase saveRecordsUseCase = new SaveAccountDataUseCase(repository);
        disposable = loadFieldsUseCase.loadAccountScheme()
                .flatMapCompletable(accountScheme -> createTableUseCase.createTable(view.context(), accountScheme))
                .andThen(loadRecordsUseCase.loadAccountData())
                .flatMapCompletable(saveRecordsUseCase::saveAccounts)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(throwable -> view.onLoadError(throwable.getMessage()))
                .doOnComplete(this::loadAccountsFromDatabase)
                .doFinally(() -> view.hideLoading())
                .subscribe();
    }

    private void loadAccountsFromDatabase() {
        AccountListAdapter accountListAdapter;
        GetAccountDataUseCase getAccountDataUseCase = new GetAccountDataUseCase(repository);
        MyPositionalDataSource dataSource = new MyPositionalDataSource(getAccountDataUseCase);

        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(LIMIT)
                .setInitialLoadSizeHint(LIMIT)
                .build();

        PagedList<Account> pagedList = new PagedList.Builder<>(dataSource, config)
                .setNotifyExecutor(new MainThreadExecutor())
                .setFetchExecutor(Executors.newSingleThreadExecutor())
                .build();

        accountListAdapter = new AccountListAdapter(new AccountDiffUtilCallback());
        accountListAdapter.submitList(pagedList);
        view.onLoadSuccess(accountListAdapter);
    }

    @Override
    public void destroy() {
        disposable.dispose();
    }
}
