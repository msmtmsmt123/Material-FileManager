package stormouble.op.material_filemanager.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import stormouble.op.material_filemanager.R;

/**
 * Created by Stormouble on 16/1/22.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder>{

    private Context mContext;
    private List<String> mData;

    public HomeAdapter(Context context, List<String> datas) {
        mContext = context;
        mData = datas;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(mContext).inflate(R.layout.item_folder, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        holder.mTv.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class HomeViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.folder) TextView mTv;

        public HomeViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
