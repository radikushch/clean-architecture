package com.radik.testing.testapplication.domain.model.describe;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class AccountField {

    @SerializedName("name")
    private String name;

    public AccountField() {

    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
