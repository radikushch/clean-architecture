package com.radik.testing.testapplication.data.repository.converters;

import com.radik.testing.testapplication.domain.model.describe.AccountField;
import com.radik.testing.testapplication.domain.model.describe.AccountScheme;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SchemeToFieldsConverter {

    public static List<String> convert(AccountScheme scheme) {
        List<String> fieldsStr = new ArrayList<>();
        Set<AccountField> fieldsObj = scheme.getFields();
        for (AccountField field: fieldsObj) {
            fieldsStr.add(field.toString());
        }
        return fieldsStr;
    }
}
