package com.fb.android.remindmap.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.fb.android.remindmap.Task;
import com.fb.android.remindmap.database.TaskDbSchema.TaskTable;

import java.util.Date;
import java.util.UUID;

/**
 * Created by judyl on 6/22/15.
 */
public class TaskCursorWrapper extends CursorWrapper {
    public TaskCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Task getCrime() {
        String uuidString = getString(getColumnIndex(TaskTable.Cols.UUID));
        String title = getString(getColumnIndex(TaskTable.Cols.TITLE));
        long date = getLong(getColumnIndex(TaskTable.Cols.DATE));
        int isDone = getInt(getColumnIndex(TaskTable.Cols.DONE));
        String location = getString(getColumnIndex(TaskTable.Cols.LOCATION));

        Task crime = new Task(UUID.fromString(uuidString));
        crime.setTitle(title);
        crime.setDate(new Date(date));
        crime.setDone(isDone != 0);
        crime.setLocation(location);

        return crime;
    }
}
