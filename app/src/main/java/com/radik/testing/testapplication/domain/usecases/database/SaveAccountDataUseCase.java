package com.radik.testing.testapplication.domain.usecases.database;

import com.radik.testing.testapplication.domain.model.Account;
import com.radik.testing.testapplication.domain.model.query.AccountData;
import com.radik.testing.testapplication.domain.repository.AccountRepository;
import com.radik.testing.testapplication.domain.usecases.UseCase;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public class SaveAccountDataUseCase extends UseCase {
    public SaveAccountDataUseCase(AccountRepository repository) {
        super(repository);
    }

    public Completable saveAccounts(AccountData accountData) {
        return repository.saveAccounts(accountData);
    }
}
