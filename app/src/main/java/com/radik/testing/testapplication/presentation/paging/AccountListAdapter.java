package com.radik.testing.testapplication.presentation.paging;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.radik.testing.testapplication.R;
import com.radik.testing.testapplication.domain.model.Account;

import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AccountListAdapter extends PagedListAdapter<Account, AccountListAdapter.AccountViewHolder> {


    public AccountListAdapter(@NonNull DiffUtil.ItemCallback<Account> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public AccountViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.list_item, viewGroup, false);
        return new AccountViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountViewHolder accountViewHolder, int i) {
        accountViewHolder.bind(getItem(i));
    }

    public class AccountViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.account_info_tv) TextView accountInfoTextView;

        public AccountViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Account account) {
            Map<String, String> accountData = account.getFields();
            Set<String> accountFields = accountData.keySet();
            StringBuilder sb = new StringBuilder();
            String value;
            for (String field: accountFields) {
                value = accountData.get(field);
                if(value == null) continue;
                sb.append(field)
                        .append(":")
                        .append(accountData.get(field))
                        .append("\n");
            }
            accountInfoTextView.setText(sb.toString());
        }
    }
}
