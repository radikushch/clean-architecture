package com.radik.testing.testapplication.data.repository.converters;

import android.content.ContentValues;
import android.util.Log;

import com.radik.testing.testapplication.domain.model.query.AccountRecord;
import com.radik.testing.testapplication.domain.model.query.RecordAttributes;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class RecordToMapConverter {

    private static final String TAG = "recordToMapConverter";

    public static ContentValues convert(List<String> fields, AccountRecord record) {
        ContentValues cv = new ContentValues();
        String value;
        for (String field: fields) {
            value = getFieldValue(field, record);
            cv.put(field, value);
        }
        return cv;
    }

    private static String getFieldValue(String field, AccountRecord record) {
        Field[] recordFieldObj = record.getClass().getDeclaredFields();
        Field[] recordAttributesFieldObj = record.getAttributes().getClass().getDeclaredFields();

        List<String> recordFieldStr = new ArrayList<>();
        for (Field f : recordFieldObj) {
            recordFieldStr.add(f.getName());
        }

        List<String> recordAttributesFieldStr = new ArrayList<>();
        for(Field f: recordAttributesFieldObj) {
            recordAttributesFieldStr.add(f.getName());
        }

        Field currentField;
        try {
            if(recordFieldStr.contains(field)) {
                currentField = AccountRecord.class.getDeclaredField(field);
                currentField.setAccessible(true);
                return String.valueOf(currentField.get(record));
            }else if(recordAttributesFieldStr.contains(field)) {
                currentField = RecordAttributes.class.getDeclaredField(field);
                currentField.setAccessible(true);
                return String.valueOf(currentField.get(record.getAttributes()));
            }else return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
}
