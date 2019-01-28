package com.radik.testing.testapplication.data.repository.converters;

import android.database.Cursor;

import com.radik.testing.testapplication.domain.model.Account;

import java.util.HashMap;
import java.util.Map;

public class MapToAccountConverter {

    public static Account convert(Cursor cursor) {
        Map<String, String> accountFields = new HashMap<>();
        String[] fields = cursor.getColumnNames();
        for (String field : fields) {
            accountFields.put(field, cursor.getString(cursor.getColumnIndex(field)));
        }
        Account account = new Account();
        account.setFields(accountFields);
        return account;
    }
}
