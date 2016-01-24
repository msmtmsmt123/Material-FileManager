package stormouble.op.material_filemanager.ui.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import stormouble.op.material_filemanager.R;
import stormouble.op.material_filemanager.ui.adapter.HomeAdapter;
import stormouble.op.material_filemanager.ui.base.SwipeRefreshActivity;

public class HomeActivity extends SwipeRefreshActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.drawer_layout) DrawerLayout mDrawerLayout;
    @Bind(R.id.navigation_view) NavigationView mNavigationView;
    @Bind(R.id.rv_folder) RecyclerView mRecyclerView;

    private ActionBarDrawerToggle mDrawerToggle;

    @Override public int provideContentViewId() {
        return R.layout.activity_main;
    }

    @Override public void provideHowDataRefresh() {

    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            animateToolbar();
        }

        setupDrawer();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        List<String> list = new ArrayList<>();
        list.add("文件夹1");
        list.add("文件夹1");
        list.add("文件夹1");
        list.add("文件夹1");
        list.add("文件夹1");
        list.add("文件夹1");
        list.add("文件夹1");
        list.add("文件夹1");
        list.add("文件夹1");
        list.add("文件夹1");
        list.add("文件夹1");
        list.add("文件夹1");
        HomeAdapter adapters = new HomeAdapter(this,list);
        mRecyclerView.setAdapter(adapters);
    }

    private void animateToolbar() {
        if (mToolbar != null) {
            Log.d("TAG", "mToolbar is not null");
            View v = mToolbar.getChildAt(0);
//            if (v != null && v instanceof TextView) {
//                Logger.d("It is a TextView");
//            }
        }
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                R.string.drawer_open,
                R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mNavigationView.setNavigationItemSelectedListener(this);
    }

    @Override protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            case R.id.menu_search:
                View searchView = mToolbar.findViewById(R.id.menu_search);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override public boolean onNavigationItemSelected(MenuItem item) {
        item.setChecked(true);
        mDrawerLayout.closeDrawers();
        return true;
    }


    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
