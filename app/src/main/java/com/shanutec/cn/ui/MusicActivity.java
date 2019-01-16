package com.shanutec.cn.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;



import com.shanutec.cn.R;
import com.shanutec.cn.adapter.MusicAdapter;
import com.shanutec.cn.util.ToastUtil;
import com.xfresh.cn.RxRefreshLayout;
import com.xfresh.cn.header.progresslayout.ProgressLayout;
import com.xfresh.cn.util.RefreshListenerAdapter;

//TODO 有FixedHeader的界面fling有问题
public class MusicActivity extends AppCompatActivity {

    private MusicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(R.drawable.back);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        setupListView((ListView) findViewById(R.id.listView));
    }

    private void setupListView(ListView listView) {
        RxRefreshLayout refreshLayout = (RxRefreshLayout) findViewById(R.id.refresh);
        ProgressLayout headerView = new ProgressLayout(this);
        refreshLayout.setHeaderView(headerView);
        View exHeader = View.inflate(this, R.layout.header_music, null);
        refreshLayout.addFixedExHeader(exHeader);
        refreshLayout.setOverScrollRefreshShow(false);
//        refreshLayout.setFloatRefresh(true);
        adapter = new MusicAdapter();
        listView.setAdapter(adapter);
        adapter.refreshCard();

        exHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.show("fixed header clicked!");
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ToastUtil.show("item clicked!");
            }
        });

        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(final RxRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.refreshCard();
                        refreshLayout.finishRefreshing();
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore(final RxRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.loadMoreCard();
                        refreshLayout.finishLoadmore();
                    }
                }, 2000);
            }
        });
    }
}
