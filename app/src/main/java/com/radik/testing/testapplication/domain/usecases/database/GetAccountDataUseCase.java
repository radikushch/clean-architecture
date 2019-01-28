package com.radik.testing.testapplication.domain.usecases.database;

import com.radik.testing.testapplication.domain.model.Account;
import com.radik.testing.testapplication.domain.repository.AccountRepository;
import com.radik.testing.testapplication.domain.usecases.UseCase;

import java.util.List;

import io.reactivex.Observable;

public class GetAccountDataUseCase extends UseCase {

    public GetAccountDataUseCase(AccountRepository repository) {
        super(repository);
    }

    public Observable<Account> getAccountData() {
        return repository.getAccountData();
    }

    public List<Account> getBatchAccountData(int offset, int amount) {
        return repository.getBatchAccountData(offset, amount);
    }
}
