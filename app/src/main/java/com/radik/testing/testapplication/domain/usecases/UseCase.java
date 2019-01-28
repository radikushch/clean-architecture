package com.radik.testing.testapplication.domain.usecases;

import com.radik.testing.testapplication.domain.repository.AccountRepository;

public abstract class UseCase {

    protected AccountRepository repository;

    public UseCase(AccountRepository repository) {
        this.repository = repository;
    }


}
