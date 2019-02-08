package com.radik.testing.testapplication.domain.usecases.database;

import android.content.Context;

import com.radik.testing.testapplication.domain.model.describe.AccountScheme;
import com.radik.testing.testapplication.domain.repository.AccountDatabaseRepository;

import io.reactivex.Completable;

public class CreateAccountTableUseCase {
    private AccountDatabaseRepository repository;

    public CreateAccountTableUseCase(AccountDatabaseRepository repository) {
        this.repository = repository;
    }

    public Completable createTable(Context context, AccountScheme describePOJO) {
        return repository.createTable(context, describePOJO);
    }
}
