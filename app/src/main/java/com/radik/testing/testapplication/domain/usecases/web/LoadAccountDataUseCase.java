package com.radik.testing.testapplication.domain.usecases.web;

import com.radik.testing.testapplication.domain.model.query.AccountData;
import com.radik.testing.testapplication.domain.repository.AccountRepository;
import com.radik.testing.testapplication.domain.usecases.UseCase;

import io.reactivex.Maybe;
import io.reactivex.Single;

public class LoadAccountDataUseCase extends UseCase {
    public LoadAccountDataUseCase(AccountRepository repository) {
        super(repository);
    }

    public Maybe<AccountData> loadAccountData() {
        return repository.loadAccountData();
    }
}
