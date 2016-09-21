package com.huweiqiang.bimgloader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.huweiqiang.butil.core.BLoad;

import java.util.List;

/**
 * Description ${Desc}
 * Author huweiqiang
 * Date 2016/9/6.
 */
public class ImageAdapter extends BaseAdapter {
    private List<String> mUrlList;
    private LayoutInflater mInflater;
    private Context mContext;
    private boolean mIsGridViewVisible = true;

    public void setmIsGridViewVisible(boolean mIsGridViewVisible) {
        this.mIsGridViewVisible = mIsGridViewVisible;
    }

    public ImageAdapter(Context context, List<String> data) {
        this.mUrlList = data;
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mUrlList.size();
    }

    @Override
    public String getItem(int position) {
        return mUrlList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_img, parent, false);
            holder = new ViewHolder();
            holder.imageView = (SquareImageView) convertView.findViewById(R.id.image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ImageView imageView = holder.imageView;
        final String uri = getItem(position);
        if (mIsGridViewVisible) {
            imageView.setTag(uri);
            BLoad.with(mContext)
                    .load(uri)
                    .placeHolder(R.drawable.big_img)
                    .error(R.drawable.ic_launcher)
                    .into(imageView);
        }

        return convertView;
    }

    private static class ViewHolder {
        public SquareImageView imageView;
    }
}
