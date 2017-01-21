//package com.example.alex.leggo;
//
//import android.content.ContentValues;
//import android.database.sqlite.SQLiteDatabase;
//import android.provider.BaseColumns;
//
///**
// * Created by alex on 1/21/17.
// */
//
//public class mySQL {
//    // To prevent someone from accidentally instantiating the contract class,
//    // make the constructor private.
//    private mySQL() {}
//
//    /* Inner class that defines the table contents */
//    public static class FeedEntry implements BaseColumns {
//        public static final String TABLE_NAME = "table";
//        public static final String COLUMN_NAME_EVENT = "event";
//        public static final String COLUMN_NAME_CATEGORY = "Category";
//        public static final String COLUMN_NAME_DESCRIPTION = "decsciption";
//        public static final String COLUMN_NAME_IMAGE = "image";
//        public static final String COLUMN_NAME_DATE = "date";
//    }
//
//    private static final String SQL_CREATE_ENTRIES =
//            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
//                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
//                    FeedEntry.COLUMN_NAME_EVENT + " TEXT" +
//                    FeedEntry.COLUMN_NAME_CATEGORY + " TEXT" +
//                    FeedEntry.COLUMN_NAME_DESCRIPTION + " TEXT" +
//                    FeedEntry.COLUMN_NAME_IMAGE + " TEXT" +
//                    FeedEntry.COLUMN_NAME_DATE + " TEXT)";
//    SQLiteDatabase db = mDbHelper.getWritableDatabase();
//
//    // Create a new map of values, where column names are the keys
//    ContentValues values = new ContentValues();
//    values.put(FeedEntry.COLUMN_NAME_TITLE, title);
//    values.put(FeedEntry.COLUMN_NAME_SUBTITLE, subtitle);
//
//    // Insert the new row, returning the primary key value of the new row
//    long newRowId = db.insert(FeedEntry.TABLE_NAME, null, values);
//}
