package fithub.cc.testrecyclerviewrefreshlodmore;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {



    @BindView(R.id.tabLayout_main)
    TabLayout tabLayout_main;
    @BindView(R.id.viewpPager_main)
    ViewPager viewpPager_main;
    private FragmentPagerAdapter adapter;

    private ViewPagerAdapter mViewPagerAdapter;
    private FragmentYouHui fragmentYouHui;
    private FragmentTuanCaoKe fragmentTuanCaoke;
    private FragmentYueCoach fragmentYueCoach;
    private FragmentSaiShiAci fragmentSaiShiAci;
    private FragmentYueOther fragmentOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        fragmentYouHui = new FragmentYouHui();
        fragmentTuanCaoke = new FragmentTuanCaoKe();
        fragmentYueCoach = new FragmentYueCoach();
        fragmentSaiShiAci = new FragmentSaiShiAci();
        fragmentOther = new FragmentYueOther();

        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPagerAdapter.addFragment(fragmentYouHui, "优惠");
        mViewPagerAdapter.addFragment(fragmentTuanCaoke, "团操课");
        mViewPagerAdapter.addFragment(fragmentYueCoach,"约教练");
        mViewPagerAdapter.addFragment(fragmentSaiShiAci, "赛事活动");
        mViewPagerAdapter.addFragment(fragmentOther, "其他");
        viewpPager_main.setAdapter(mViewPagerAdapter);
        tabLayout_main.setupWithViewPager(viewpPager_main);

    }


    class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<String> mFragmentTitleList = new ArrayList<>();
        private ArrayList<Fragment> mFragmentList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
