package com.radik.testing.testapplication.domain.model.describe;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.Set;
import java.util.function.Consumer;

public class AccountScheme {

    @SerializedName("fields")
    private Set<AccountField> fields;

    public AccountScheme() {
    }

    public Set<AccountField> getFields() {
        return fields;
    }

    public void setFields(Set<AccountField> fields) {
        this.fields = fields;
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            fields.forEach(accountField -> {
                sb.append(accountField.toString());
                sb.append("  |  ");
            });
        }else {
            for (AccountField accountField: fields) {
                sb.append(accountField.toString());
                sb.append("  |  ");
            }
        }
        sb.delete(sb.length() - 6,sb.length() - 1);
        return sb.toString();
    }
}
