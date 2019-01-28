package com.radik.testing.testapplication.presentation.paging;

import android.arch.paging.PositionalDataSource;
import android.support.annotation.NonNull;
import android.util.Log;

import com.radik.testing.testapplication.domain.model.Account;
import com.radik.testing.testapplication.domain.usecases.database.GetAccountDataUseCase;

import java.util.List;

public class MyPositionalDataSource extends PositionalDataSource<Account> {

    private static final String TAG = "mDataSource";
    private final GetAccountDataUseCase getAccountDataUseCase;

    public MyPositionalDataSource(GetAccountDataUseCase getAccountDataUseCase) {
        this.getAccountDataUseCase = getAccountDataUseCase;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<Account> callback) {
        Log.e(TAG, "loadInitial, requestedStartPosition = " + params.requestedStartPosition +
                ", requestedLoadSize = " + params.requestedLoadSize);
        List<Account> result = getAccountDataUseCase.getBatchAccountData(params.requestedStartPosition, params.requestedLoadSize);
        callback.onResult(result, 0);
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<Account> callback) {
        Log.e(TAG, "loadRange, startPosition = " + params.startPosition + ", loadSize = " + params.loadSize);
        List<Account> result = getAccountDataUseCase.getBatchAccountData(params.startPosition, params.loadSize);
        callback.onResult(result);
    }
}
