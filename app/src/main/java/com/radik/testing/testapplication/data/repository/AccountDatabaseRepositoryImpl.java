package com.radik.testing.testapplication.data.repository;

import android.content.Context;
import android.database.Cursor;

import com.radik.testing.testapplication.data.database.DBHelper;
import com.radik.testing.testapplication.data.database.LocalDatabaseContract;
import com.radik.testing.testapplication.data.repository.converters.MapToAccountConverter;
import com.radik.testing.testapplication.data.repository.converters.RecordToMapConverter;
import com.radik.testing.testapplication.data.repository.converters.SchemeToFieldsConverter;
import com.radik.testing.testapplication.domain.model.Account;
import com.radik.testing.testapplication.domain.model.describe.AccountScheme;
import com.radik.testing.testapplication.domain.model.query.AccountData;
import com.radik.testing.testapplication.domain.model.query.AccountRecord;
import com.radik.testing.testapplication.domain.repository.AccountDatabaseRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;

public class AccountDatabaseRepositoryImpl implements AccountDatabaseRepository {

    private static DBHelper dbHelper;
    //private Context context;

    @Override
    public Completable createTable(Context context, AccountScheme accountScheme) {
        return createLocalTable(context, accountScheme);
    }

    private Completable createLocalTable(Context context, AccountScheme accountScheme) {
        dbHelper = new DBHelper(context,
                LocalDatabaseContract.DATABASE_NAME,
                LocalDatabaseContract.DATABASE_VERION,
                SchemeToFieldsConverter.convert(accountScheme));
        Completable completable = Completable.fromAction(dbHelper::getReadableDatabase);
        dbHelper.close();
        return completable;
    }

    @Override
    public Completable saveAccounts(AccountData accountData) {
        return saveToLocalDatabase(accountData);
    }

    private Completable saveToLocalDatabase(AccountData accountData) {
        if(dbHelper == null) return null;
        return Single.create((SingleOnSubscribe<List<String>>) e -> {
            List<String> columns = dbHelper.getColumnNames(LocalDatabaseContract.AccountTable.NAME);
            if(columns == null || columns.size() == 0)
                e.onError(new Throwable("Table doesn't have columns"));
            else e.onSuccess(columns);
        })
                .flatMapCompletable(fields -> Completable.create(e -> {
                    Long id;
                    List<AccountRecord> records = accountData.getRecords();
                    for (int i = 0; i < records.size(); i++) {
                        id = dbHelper.insert(LocalDatabaseContract.AccountTable.NAME,
                                RecordToMapConverter.convert(fields, records.get(i)));
                        if(id == -1) e.onError(new Throwable("Local database error"));
                    }
                    e.onComplete();
                    dbHelper.close();
                }));
    }

    @Override
    public Observable<Account> getAccountData() {
        return getAccountsFromLocalDatabase();
    }

    private Observable<Account> getAccountsFromLocalDatabase() {
        return Observable.create(e -> {
            Cursor cursor = dbHelper.queryAll(LocalDatabaseContract.AccountTable.NAME);
            if(cursor == null) e.onError(new Throwable("Table is empty"));
            else {
                if(cursor.moveToFirst()) {
                    do {
                        e.onNext(MapToAccountConverter.convert(cursor));
                    }while(cursor.moveToNext());
                }
                dbHelper.close();
                cursor.close();
                e.onComplete();
            }
        });
    }

    @Override
    public List<Account> getBatchAccountData(int offset, int amount) {
        Cursor cursor = dbHelper.queryBatch(LocalDatabaseContract.AccountTable.NAME, offset, amount);
        List<Account> accounts = new ArrayList<>();
        if(cursor.moveToFirst()) {
            do {
                accounts.add(MapToAccountConverter.convert(cursor));
            }while(cursor.moveToNext());
        }
        dbHelper.close();
        cursor.close();
        return accounts;
    }
}
