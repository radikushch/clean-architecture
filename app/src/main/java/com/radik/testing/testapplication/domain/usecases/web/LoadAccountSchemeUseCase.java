package com.radik.testing.testapplication.domain.usecases.web;

import com.radik.testing.testapplication.domain.model.describe.AccountScheme;
import com.radik.testing.testapplication.domain.repository.AccountWebRepository;

import io.reactivex.Maybe;

public class LoadAccountSchemeUseCase {

    private AccountWebRepository repository;

    public LoadAccountSchemeUseCase(AccountWebRepository repository) {
        this.repository = repository;
    }

    public Maybe<AccountScheme> loadAccountScheme() {
        return repository.loadAccountScheme();
    }
}
