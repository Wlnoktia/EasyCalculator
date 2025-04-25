package com.example.easycalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException; // Gunakan ini, bukan java.sql.SQLException
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "calculator_history.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "history";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_EXPRESSION = "expression";
    private static final String COLUMN_RESULT = "result";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_EXPRESSION + " TEXT, " +
                COLUMN_RESULT + " TEXT)";
        try {
            db.execSQL(CREATE_TABLE);
        } catch (SQLException e) { // Tangani SQLException dengan benar
            Log.e("DatabaseHelper", "Error creating table: " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        } catch (SQLException e) {
            Log.e("DatabaseHelper", "Error upgrading database: " + e.getMessage());
        }
    }

    public void addHistoryItem(HistoryItem item) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put(COLUMN_EXPRESSION, item.getExpression());
            values.put(COLUMN_RESULT, item.getResult());
            db.insert(TABLE_NAME, null, values);
        } catch (SQLException e) {
            Log.e("DatabaseHelper", "Error adding history item: " + e.getMessage());
        } finally {
            db.close();
        }
    }

    public List<HistoryItem> getAllHistory() {
        List<HistoryItem> historyList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY ID DESC", null);
            if (cursor.moveToFirst()) {
                do {
                    String expression = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EXPRESSION));
                    String result = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_RESULT));
                    historyList.add(new HistoryItem(expression, result));
                } while (cursor.moveToNext());
            }
        } catch (SQLException e) {
            Log.e("DatabaseHelper", "Error getting all history: " + e.getMessage());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }
        return historyList;
    }

    public void deleteHistoryItem(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.delete(TABLE_NAME, COLUMN_ID + "=?", new String[]{String.valueOf(id)});
        } catch (SQLException e) {
            Log.e("DatabaseHelper", "Error deleting history item: " + e.getMessage());
        } finally {
            db.close();
        }
    }

    public void clearHistory() {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.execSQL("DELETE FROM " + TABLE_NAME);
        } catch (SQLException e) {
            Log.e("DatabaseHelper", "Error clearing history: " + e.getMessage());
        } finally {
            db.close();
        }
    }
}
