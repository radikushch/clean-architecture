package com.radik.testing.testapplication.presentation.paging;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

import com.radik.testing.testapplication.domain.model.Account;

public class AccountDiffUtilCallback extends DiffUtil.ItemCallback<Account> {

    @Override
    public boolean areItemsTheSame(@NonNull Account account, @NonNull Account t1) {
        return account.getFields().get("_id").equals(t1.getFields().get("_id"));
    }

    @Override
    public boolean areContentsTheSame(@NonNull Account account, @NonNull Account t1) {
        return account.equals(t1);
    }
}
