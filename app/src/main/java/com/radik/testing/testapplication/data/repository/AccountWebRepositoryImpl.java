package com.radik.testing.testapplication.data.repository;

import com.radik.testing.testapplication.MyApp;
import com.radik.testing.testapplication.data.web.AccountDataService;
import com.radik.testing.testapplication.domain.model.describe.AccountScheme;
import com.radik.testing.testapplication.domain.model.query.AccountData;
import com.radik.testing.testapplication.domain.repository.AccountWebRepository;

import io.reactivex.Maybe;

public class AccountWebRepositoryImpl implements AccountWebRepository {

    public AccountDataService accountDataService;

    public AccountWebRepositoryImpl() {
        accountDataService = MyApp.get().getComponent().getAccountDataService();
    }

    public Maybe<AccountScheme> loadAccountScheme() {
        return loadSchemeWithRetrofit();
    }

    private Maybe<AccountScheme> loadSchemeWithRetrofit() {
        return accountDataService.getAccountScheme();
    }

    public Maybe<AccountData> loadAccountData() {
        return loadDataWithRetrofit();
    }

    private Maybe<AccountData> loadDataWithRetrofit() {
        return accountDataService.getAccountData();
    }

}
