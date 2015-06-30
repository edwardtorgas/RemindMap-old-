package com.fb.android.remindmap;

import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by judyl on 6/18/15.
 */
public class TaskListActivity extends SingleFragmentActivity implements TaskListFragment.Callbacks, TaskFragment.Callbacks {

    @Override
    protected Fragment createFragment() {
        return new TaskListFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_masterdetail;
    }

    @Override
    public void onTaskSelected(Task task) {
        if (findViewById(R.id.detail_fragment_container) == null) {
            Intent intent = TaskPagerActivity.newIntent(this, task.getId());
            startActivity(intent);
        } else {
            Fragment newDetail = TaskFragment.newInstance(task.getId());

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container, newDetail)
                    .commit();
        }
    }

    public void onTaskUpdated(Task task) {
        TaskListFragment listFragment = (TaskListFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        listFragment.updateUI();
    }
}
