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
    public void onCrimeSelected(Task crime) {
        if (findViewById(R.id.detail_fragment_container) == null) {
            Intent intent = TaskPagerActivity.newIntent(this, crime.getId());
            startActivity(intent);
        } else {
            Fragment newDetail = TaskFragment.newInstance(crime.getId());

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container, newDetail)
                    .commit();
        }
    }

    public void onCrimeUpdated(Task crime) {
        TaskListFragment listFragment = (TaskListFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        listFragment.updateUI();
    }
}
