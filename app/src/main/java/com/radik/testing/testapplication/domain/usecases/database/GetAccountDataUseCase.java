package com.radik.testing.testapplication.domain.usecases.database;

import com.radik.testing.testapplication.domain.model.Account;
import com.radik.testing.testapplication.domain.repository.AccountDatabaseRepository;

import java.util.List;

import io.reactivex.Observable;

public class GetAccountDataUseCase {

    private AccountDatabaseRepository repository;

    public GetAccountDataUseCase(AccountDatabaseRepository repository) {
        this.repository = repository;
    }

    public Observable<Account> getAccountData() {
        return repository.getAccountData();
    }

    public List<Account> getBatchAccountData(int offset, int amount) {
        return repository.getBatchAccountData(offset, amount);
    }
}
