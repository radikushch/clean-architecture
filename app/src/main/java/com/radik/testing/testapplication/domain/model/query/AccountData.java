package com.radik.testing.testapplication.domain.model.query;

import android.os.Build;
import android.support.annotation.NonNull;

import java.util.List;

public class AccountData {

    private List<AccountRecord> records;

    public AccountData() {
    }

    public List<AccountRecord> getRecords() {
        return records;
    }

    public void setRecords(List<AccountRecord> records) {
        this.records = records;
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            records.forEach(accountRecord -> {
               sb.append(accountRecord.toString());
               sb.append("  |  ");
            });
        }else {
            for (AccountRecord accountRecord: records) {
                sb.append(accountRecord.toString());
                sb.append("  |  ");
            }
        }
        sb.delete(sb.length() - 6,sb.length() - 1);
        return sb.toString();
    }
}
