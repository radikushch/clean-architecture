package com.radik.testing.testapplication.data.web;

import com.radik.testing.testapplication.domain.model.describe.AccountScheme;
import com.radik.testing.testapplication.domain.model.query.AccountData;

import io.reactivex.Maybe;
import retrofit2.http.GET;

public interface AccountDataService {

    @GET("/describe")
    Maybe<AccountScheme> getAccountScheme();

    @GET("/query")
    Maybe<AccountData> getAccountData();
}
