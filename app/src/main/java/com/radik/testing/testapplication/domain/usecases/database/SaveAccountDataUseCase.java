package com.radik.testing.testapplication.domain.usecases.database;

import com.radik.testing.testapplication.domain.model.query.AccountData;
import com.radik.testing.testapplication.domain.repository.AccountDatabaseRepository;

import io.reactivex.Completable;

public class SaveAccountDataUseCase {
    private AccountDatabaseRepository repository;

    public SaveAccountDataUseCase(AccountDatabaseRepository repository) {
        this.repository = repository;
    }

    public Completable saveAccounts(AccountData accountData) {
        return repository.saveAccounts(accountData);
    }
}
