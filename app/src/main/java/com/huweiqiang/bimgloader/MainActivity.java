package com.huweiqiang.bimgloader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AbsListView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private GridView mGridView;
    private ImageAdapter mImageAdapter;
    private List<String> mData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initData() {
        mData = new ArrayList<>();
        mData.add("http://banbao.chazidian.com/uploadfile/2016-01-25/s145368924044608.jpg");
        mData.add("http://pic36.nipic.com/20131217/6704106_233034463381_.jpg");
        mData.add("http://ww2.sinaimg.cn/large/610dc034jw1f7jkj4hl41j20u00mhq68.jpg");
        mData.add("http://ww1.sinaimg.cn/large/610dc034jw1f7hu7d460oj20u00u075u.jpg");
        mData.add("http://ww1.sinaimg.cn/large/610dc034jw1f7ef7i5m1zj20u011hdjm.jpg");
        mData.add("http://ww1.sinaimg.cn/large/610dc034jw1f7ef7i5m1zj20u011hdjm.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f7d97id9mbj20u00u0q4g.jpg");
        mData.add("http://ww4.sinaimg.cn/large/610dc034jw1f7cmpd95iaj20u011hjtt.jpg");
        mData.add("http://ww2.sinaimg.cn/large/610dc034gw1f7bm1unn17j20u00u00wm.jpg");
        mData.add("http://ww1.sinaimg.cn/large/610dc034jw1f79sjqjn11j20u011hmzv.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f71bezmt3tj20u00k0757.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f6xsqw8057j20dw0kugpf.jpg");
        mData.add("http://ww1.sinaimg.cn/large/610dc034jw1f7ef7i5m1zj20u011hdjm.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f756vb8zl2j20u011haec.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f740f701gqj20u011hgo9.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f71bezmt3tj20u00k0757.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f6xsqw8057j20dw0kugpf.jpg");
        mData.add("http://ww1.sinaimg.cn/large/610dc034jw1f7ef7i5m1zj20u011hdjm.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f7d97id9mbj20u00u0q4g.jpg");
        mData.add("http://ww4.sinaimg.cn/large/610dc034jw1f7cmpd95iaj20u011hjtt.jpg");
        mData.add("http://ww2.sinaimg.cn/large/610dc034gw1f7bm1unn17j20u00u00wm.jpg");
        mData.add("http://ww1.sinaimg.cn/large/610dc034jw1f79sjqjn11j20u011hmzv.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f756vb8zl2j20u011haec.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f740f701gqj20u011hgo9.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f71bezmt3tj20u00k0757.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f6xsqw8057j20dw0kugpf.jpg");
        mData.add("http://ww1.sinaimg.cn/large/610dc034jw1f7ef7i5m1zj20u011hdjm.jpg");
        mData.add("http://ww1.sinaimg.cn/large/610dc034jw1f7hu7d460oj20u00u075u.jpg");
        mData.add("http://ww1.sinaimg.cn/large/610dc034jw1f7ef7i5m1zj20u011hdjm.jpg");
        mData.add("http://ww1.sinaimg.cn/large/610dc034jw1f7ef7i5m1zj20u011hdjm.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f7d97id9mbj20u00u0q4g.jpg");
        mData.add("http://ww4.sinaimg.cn/large/610dc034jw1f7cmpd95iaj20u011hjtt.jpg");
        mData.add("http://ww2.sinaimg.cn/large/610dc034gw1f7bm1unn17j20u00u00wm.jpg");
        mData.add("http://ww1.sinaimg.cn/large/610dc034jw1f79sjqjn11j20u011hmzv.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f71bezmt3tj20u00k0757.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f6xsqw8057j20dw0kugpf.jpg");
        mData.add("http://ww1.sinaimg.cn/large/610dc034jw1f7ef7i5m1zj20u011hdjm.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f756vb8zl2j20u011haec.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f740f701gqj20u011hgo9.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f71bezmt3tj20u00k0757.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f6xsqw8057j20dw0ku.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f7d97id9mbj20u00u0q4g.jpg");
        mData.add("http://ww4.sinaimg.cn/large/610dc034jw1f7cmpd95iaj20u011hjtt.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f71bezmt3tj20u00k0757.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f6xsqw8057j20dw0kugpf.jpg");
        mData.add("http://ww1.sinaimg.cn/large/610dc034jw1f7ef7i5m1zj20u011hdjm.jpg");
        mData.add("http://ww2.sinaimg.cn/large/610dc034gw1f7bm1unn17j20u00u00wm.jpg");
        mData.add("http://ww1.sinaimg.cn/large/610dc034jw1f79sjqjn11j20u011hmzv.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f756vb8zl2j20u011haec.jpg");
        mData.add("http://ww1.sinaimg.cn/large/610dc034jw1f7hu7d460oj20u00u075u.jpg");
        mData.add("http://ww1.sinaimg.cn/large/610dc034jw1f7ef7i5m1zj20u011hdjm.jpg");
        mData.add("http://ww1.sinaimg.cn/large/610dc034jw1f7ef7i5m1zj20u011hdjm.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f7d97id9mbj20u00u0q4g.jpg");
        mData.add("http://ww4.sinaimg.cn/large/610dc034jw1f7cmpd95iaj20u011hjtt.jpg");
        mData.add("http://ww2.sinaimg.cn/large/610dc034gw1f7bm1unn17j20u00u00wm.jpg");
        mData.add("http://ww1.sinaimg.cn/large/610dc034jw1f79sjqjn11j20u011hmzv.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f71bezmt3tj20u00k.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f6xsqw8057j20dw0kugpf.jpg");
        mData.add("http://ww1.sinaimg.cn/large/610dc034jw1f7ef7i5m1zj20u011hdjm.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f756vb8zl2j20u011haec.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f740f701gqj20u011hgo9.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f71bezmt3tj20u00k0757.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f6xsqw8057j20dw0kugpf.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f71bezmt3tj20u00k0757.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f6xsqw8057j20dw0kugpf.jpg");
        mData.add("http://ww1.sinaimg.cn/large/610dc034jw1f7ef7i5m1zj20u011hdjm.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f740f701gqj20u011hgo9.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f71bezmt3tj20u00k0757.jpg");
        mData.add("http://ww3.sinaimg.cn/large/610dc034jw1f6xsqw8057j20dw0kugpf.jpg");

    }

    private void initView() {
        mGridView = (GridView) findViewById(R.id.gridview);
        mImageAdapter = new ImageAdapter(MainActivity.this, mData);
        mGridView.setAdapter(mImageAdapter);
        mGridView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    mImageAdapter.setmIsGridViewVisible(true);
                    mImageAdapter.notifyDataSetChanged();
                } else {
                    mImageAdapter.setmIsGridViewVisible(false);
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }
}
