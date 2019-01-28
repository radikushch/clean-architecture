package com.radik.testing.testapplication.domain.usecases.database;

import android.content.Context;

import com.radik.testing.testapplication.domain.model.describe.AccountScheme;
import com.radik.testing.testapplication.domain.repository.AccountRepository;
import com.radik.testing.testapplication.domain.usecases.UseCase;

import io.reactivex.Completable;

public class CreateAccountTableUseCase extends UseCase {
    public CreateAccountTableUseCase(AccountRepository repository) {
        super(repository);
    }

    public Completable createTable(Context context, AccountScheme describePOJO) {
        return repository.createTable(context, describePOJO);
    }
}
