package stormouble.op.material_filemanager.ui.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import stormouble.op.material_filemanager.R;

/**
 * Created by Stormouble on 16/1/22.
 */
public abstract class ToolbarActivity extends BaseActivity{

    protected AppBarLayout mAppBarLayout;
    protected Toolbar mToolbar;

    public abstract int provideContentViewId();

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideContentViewId());
        setupToolbar();
    }

    private void setupToolbar() {
        mAppBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        if (mAppBarLayout == null || mToolbar == null) {
            throw new IllegalStateException("There is no toolbar");
        }

        setSupportActionBar(mToolbar);

        if(canGoBack()) {
            final ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
        }

        if(Build.VERSION.SDK_INT > 21) {
            mAppBarLayout.setElevation(10.6f);
        }
    }

    public boolean canGoBack() {
        return false;
    }


}
