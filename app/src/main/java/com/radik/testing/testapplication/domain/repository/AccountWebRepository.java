package com.radik.testing.testapplication.domain.repository;

import com.radik.testing.testapplication.domain.model.describe.AccountScheme;
import com.radik.testing.testapplication.domain.model.query.AccountData;

import io.reactivex.Maybe;

public interface AccountWebRepository {

    Maybe<AccountScheme> loadAccountScheme();
    Maybe<AccountData> loadAccountData();

}
