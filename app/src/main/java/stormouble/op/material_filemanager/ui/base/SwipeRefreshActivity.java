package stormouble.op.material_filemanager.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import stormouble.op.material_filemanager.R;

/**
 * Created by Stormouble on 16/1/22.
 */
public abstract class SwipeRefreshActivity extends ToolbarActivity{

    @Bind(R.id.swipe_refresh_layout) public SwipeRefreshLayout mSwipeRefreshLayout;

    public abstract void provideHowDataRefresh();

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        trySetupSwipeRefresh();
    }

    protected void trySetupSwipeRefresh() {
        if (mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.setColorSchemeColors(R.color.refresh_progress_1,
                    R.color.refresh_progress_2, R.color.refresh_progress_3);

            mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    mSwipeRefreshLayout.setRefreshing(true);
                    provideHowDataRefresh();
                }
            });
        }
    }

    public void finishRefreshing() {
        mSwipeRefreshLayout.setRefreshing(false);
    }


}
