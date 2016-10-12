package fithub.cc.testrecyclerviewrefreshlodmore;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hosa2015 on 2016-9-18.
 */
public class FragmentTuanCaoKe extends Fragment {
    @BindView(R.id.recyclerViewTwo)
    XRecyclerView xRecyclerView;

    RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<String> mData;
    private Handler handler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        ButterKnife.bind(this, view);
        initData();
        return view;

    }

    private void initData() {
        xRecyclerView.setPullRefreshEnabled(false);
        mData = new ArrayList<>();
        recyclerViewAdapter = new RecyclerViewAdapter(mData);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(layoutManager);
        xRecyclerView.setAdapter(recyclerViewAdapter);
//        xRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        handler = new Handler();
        xRecyclerView.setRefreshProgressStyle(ProgressStyle.LineScalePulseOut);
        xRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.Pacman);

        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refresh();
                        xRecyclerView.refreshComplete();
//                        Toast.makeText(getActivity(), "onRefresh", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);


            }

            @Override
            public void onLoadMore() {


                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadMore();
                        xRecyclerView.loadMoreComplete();
//                        Toast.makeText(getActivity(), "onLoadMore", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);


            }
        });

        refresh();
    }


    private void refresh() {
        if (mData.size() > 0) {
            mData.clear();
        }

        for (int i = 0; i < 10; i++) {
            mData.add("刷新第" + i + "数据");
        }


    }

    private void loadMore() {
        for (int i = 0; i < 5; i++) {
            mData.add("更多第" + i + "数据");
        }

    }
}
