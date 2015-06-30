package com.fb.android.remindmap.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.fb.android.remindmap.database.TaskDbSchema.TaskTable;

/**
 * Created by judyl on 6/22/15.
 */
public class TaskBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static String DATEBASE_NAME = "taskBase.db";

    public TaskBaseHelper(Context context) {
        super(context, DATEBASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TaskTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                TaskTable.Cols.UUID + ", " +
                TaskTable.Cols.TITLE + ", " +
                TaskTable.Cols.DATE + ", " +
                TaskTable.Cols.DONE + ", " +
                TaskTable.Cols.LOCATION +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
