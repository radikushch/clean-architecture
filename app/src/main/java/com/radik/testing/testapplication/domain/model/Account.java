package com.radik.testing.testapplication.domain.model;

import android.support.annotation.NonNull;

import com.radik.testing.testapplication.domain.model.query.AccountRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Account {

    private Map<String, String> fields;


    public Account() {
        fields = new HashMap<>();
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }

    @NonNull
    @Override
    public String toString() {
        return fields.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Account)) return false;
        else {
            return fields.equals(((Account)obj).getFields());
        }
    }
}
