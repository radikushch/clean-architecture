package com.radik.testing.testapplication.data.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Arrays;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static final String ACCOUNT_TABLE = LocalDatabaseContract.AccountTable.NAME;
    private List<String> fields;

    public DBHelper(Context context,String name, int version, List<String> fields) {
        super(context, name, null, version);
        this.fields = fields;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        if(fields == null) return;
        StringBuilder createQuery = new StringBuilder("create table " +
                                                        ACCOUNT_TABLE +
                                                        "( _id integer primary key autoincrement,");
        for (String field : fields) {
                createQuery.append(field);
                createQuery.append(" text,");
        }
        createQuery.deleteCharAt(createQuery.length() - 1);
        createQuery.append(");");
        sqLiteDatabase.execSQL(createQuery.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Long insert(String tableName, ContentValues cv) {
        SQLiteDatabase db = getWritableDatabase();
        return db.insert(tableName, null, cv);
    }

    public List<String> getColumnNames(String tableName) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = queryAllRecords(tableName);
        String[] columnsNames = cursor.getColumnNames();
        cursor.close();
        return Arrays.asList(columnsNames);
    }

    public Cursor queryAll(String tableName) {
        return queryAllRecords(tableName);
    }

    private Cursor queryAllRecords(String tableName) {
        SQLiteDatabase db = getReadableDatabase();
        return db.query(tableName,
                null,
                null,
                null,
                null,
                null,
                null);
    }

    public Cursor queryBatch(String tableName, int offset, int amount) {
        SQLiteDatabase db = getReadableDatabase();
        return db.query(tableName,
                null,
                "_id >= ? and _id <= ?",
                new String[] {String.valueOf(offset), String.valueOf(offset + amount - 1)},
                null,
                null,
                null);
    }
}
