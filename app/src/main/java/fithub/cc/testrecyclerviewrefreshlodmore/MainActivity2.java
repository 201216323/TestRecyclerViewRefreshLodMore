package fithub.cc.testrecyclerviewrefreshlodmore;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity2 extends AppCompatActivity {

    @BindView(R.id.tabLayout_main)
    TabLayout tabLayout_main;
    @BindView(R.id.viewpPager_main)
    ViewPager viewpPager_main;
    private FragmentPagerAdapter adapter;

    private ViewPagerAdapter mViewPagerAdapter;
    private List<String> mFragmentTitleList;
    private TextView title_one;
    private TextView title_two;
    private TextView title_three;
    private TextView title_four;
    private TextView title_five;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        mFragmentTitleList = new ArrayList<>();
        mFragmentTitleList.add("优惠");
        mFragmentTitleList.add("团操课");
        mFragmentTitleList.add("约教练");
        mFragmentTitleList.add("赛事活动");
        mFragmentTitleList.add("其他");
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mFragmentTitleList);
        viewpPager_main.setAdapter(mViewPagerAdapter);
//        tabLayout_main.setupWithViewPager(viewpPager_main);
        viewpPager_main.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                tabLayout_main.getTabAt(position).select();
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabLayout_main.addTab(tabLayout_main.newTab().setCustomView(R.layout.title_one));
        title_one = (TextView) findViewById(R.id.title_one);
        title_one.setText(mFragmentTitleList.get(0));
        title_one.setTextColor(Color.parseColor("#ff5533"));
        title_one.setTextSize(15);
        tabLayout_main.addTab(tabLayout_main.newTab().setCustomView(R.layout.title_two));
        title_two = (TextView) findViewById(R.id.title_two);
        title_two.setText(mFragmentTitleList.get(1));
        title_two.setTextColor(Color.parseColor("#666666"));
        title_two.setTextSize(14);
        tabLayout_main.addTab(tabLayout_main.newTab().setCustomView(R.layout.title_three));
        title_three = (TextView) findViewById(R.id.title_three);
        title_three.setText(mFragmentTitleList.get(2));
        title_three.setTextColor(Color.parseColor("#666666"));
        title_three.setTextSize(14);

        tabLayout_main.addTab(tabLayout_main.newTab().setCustomView(R.layout.title_four));
        title_four = (TextView) findViewById(R.id.title_four);
        title_four.setText(mFragmentTitleList.get(3));
        title_four.setTextColor(Color.parseColor("#666666"));
        title_four.setTextSize(14);

        tabLayout_main.addTab(tabLayout_main.newTab().setCustomView(R.layout.title_five));
        title_five = (TextView) findViewById(R.id.title_five);
        title_five.setText(mFragmentTitleList.get(4));
        title_five.setTextColor(Color.parseColor("#666666"));
        title_five.setTextSize(14);
        tabLayout_main.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpPager_main.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()) {
                    case 0:
                        title_one.setTextSize(15);
                        title_one.setTextColor(Color.parseColor("#ff5533"));
                        break;
                    case 1:
                        title_two.setTextSize(15);
                        title_two.setTextColor(Color.parseColor("#ff5533"));
                        break;
                    case 2:
                        title_three.setTextSize(15);
                        title_three.setTextColor(Color.parseColor("#ff5533"));
                        break;
                    case 3:
                        title_four.setTextSize(15);
                        title_four.setTextColor(Color.parseColor("#ff5533"));
                        break;
                    case 4:
                        title_five.setTextSize(15);
                        title_five.setTextColor(Color.parseColor("#ff5533"));
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                title_one.setTextSize(14);
                title_one.setTextColor(Color.parseColor("#666666"));
                title_two.setTextSize(14);
                title_two.setTextColor(Color.parseColor("#666666"));
                title_three.setTextSize(14);
                title_three.setTextColor(Color.parseColor("#666666"));
                title_four.setTextSize(14);
                title_four.setTextColor(Color.parseColor("#666666"));
                title_five.setTextSize(14);
                title_five.setTextColor(Color.parseColor("#666666"));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


    class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<String> mFragmentTitleList;

        public ViewPagerAdapter(FragmentManager fm, List<String> mFragmentTitleList) {
            super(fm);
            this.mFragmentTitleList = mFragmentTitleList;
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new FragmentYouHui();
            } else if (position == 1) {
                return new FragmentTuanCaoKe();
            } else if (position == 1) {
                return new FragmentYouHui();
            } else if (position == 1) {
                return new FragmentYouHui();
            } else if (position == 1) {
                return new FragmentYouHui();
            }
            return new FragmentYouHui();
        }

        @Override
        public int getCount() {
            return mFragmentTitleList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
