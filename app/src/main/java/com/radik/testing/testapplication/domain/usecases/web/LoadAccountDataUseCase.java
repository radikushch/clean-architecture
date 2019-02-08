package com.radik.testing.testapplication.domain.usecases.web;

import com.radik.testing.testapplication.domain.model.query.AccountData;
import com.radik.testing.testapplication.domain.repository.AccountWebRepository;

import io.reactivex.Maybe;

public class LoadAccountDataUseCase {

    private AccountWebRepository repository;

    public LoadAccountDataUseCase(AccountWebRepository repository) {
        this.repository = repository;
    }

    public Maybe<AccountData> loadAccountData() {
        return repository.loadAccountData();
    }
}
