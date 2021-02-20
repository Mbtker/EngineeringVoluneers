package mbtkerteam.com.engvolunteered;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

import mbtkerteam.com.engvolunteered.Helpers.InterestingAdapters;
import mbtkerteam.com.engvolunteered.Helpers.InterestingModel;

public class SelectInterestingAtivity  extends AppCompatActivity implements AbsListView.MultiChoiceModeListener {

    GridView CategoriesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_interesting_ativity);

        CategoriesListView = (GridView) findViewById(R.id.CategoriesListView);

        InterestingAdapters categoriesAdapters = new InterestingAdapters(SelectInterestingAtivity.this, IntroActivity.InterestingList);
        CategoriesListView.setAdapter(categoriesAdapters);

    }


    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }

    @Override
    public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

    }

    public void ContinueButton(View view) {

        Intent intent = new Intent(getApplicationContext(), EngMainActivity.class);
        startActivity(intent);
    }

    public void SkipButton(View view) {

        Intent intent = new Intent(getApplicationContext(), EngMainActivity.class);
        startActivity(intent);
    }
}
