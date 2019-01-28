package com.radik.testing.testapplication.domain.repository;


import android.content.Context;

import com.radik.testing.testapplication.domain.model.Account;
import com.radik.testing.testapplication.domain.model.describe.AccountScheme;
import com.radik.testing.testapplication.domain.model.query.AccountData;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;

public interface AccountRepository {

    Maybe<AccountScheme> loadAccountScheme();
    Maybe<AccountData> loadAccountData();

    Completable createTable(Context context, AccountScheme accountScheme);
    Completable saveAccounts(AccountData accountData);
    Observable<Account> getAccountData();
    List<Account> getBatchAccountData(int offset, int amount);

}
