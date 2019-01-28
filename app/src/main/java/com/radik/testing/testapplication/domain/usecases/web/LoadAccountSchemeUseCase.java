package com.radik.testing.testapplication.domain.usecases.web;

import com.radik.testing.testapplication.domain.model.describe.AccountScheme;
import com.radik.testing.testapplication.domain.repository.AccountRepository;
import com.radik.testing.testapplication.domain.usecases.UseCase;

import io.reactivex.Maybe;
import io.reactivex.Single;

public class LoadAccountSchemeUseCase extends UseCase {

    public LoadAccountSchemeUseCase(AccountRepository repository) {
        super(repository);
    }

    public Maybe<AccountScheme> loadAccountScheme() {
        return repository.loadAccountScheme();
    }
}
