package fr.bemyapp.hackyourhair;

import fr.bemyapp.hackyourhair.adapter.DashboardPagerAdapter;
import fr.bemyapp.hackyourhair.fragment.AbstractDashboardFragment;
import fr.bemyapp.hackyourhair.fragment.MainDashboardFragment_;
import fr.bemyapp.hackyourhair.fragment.TileDashboardFragment_;
import fr.bemyapp.hackyourhair.model.DashboardTile;
import fr.castorflex.android.verticalviewpager.VerticalViewPager;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @ViewById(R.id.vertical_viewpager)
    VerticalViewPager mViewPager;

    DashboardPagerAdapter mPagerAdapter;

    @AfterViews
    void onPostCreate() {
        mPagerAdapter = new DashboardPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);

        mPagerAdapter.addPage(MainDashboardFragment_.builder().build());

        addTileToDashboard(new DashboardTile(R.string.tile_fake_title, R.drawable.home_3));
        addTileToDashboard(new DashboardTile(R.string.tile_fake_title, R.drawable.home_3));
        addTileToDashboard(new DashboardTile(R.string.tile_fake_title, R.drawable.home_3));
        addTileToDashboard(new DashboardTile(R.string.tile_fake_title, R.drawable.home_3));
        addTileToDashboard(new DashboardTile(R.string.tile_fake_title, R.drawable.home_3));
        addTileToDashboard(new DashboardTile(R.string.tile_fake_title, R.drawable.home_3));
        addTileToDashboard(new DashboardTile(R.string.tile_fake_title, R.drawable.home_3));
    }

    public void addTileToDashboard(DashboardTile tile) {
        final int item = mPagerAdapter.getCount() - 1;
        AbstractDashboardFragment dashboardFragment = mPagerAdapter.getItem(item);
        if (dashboardFragment.isPageFull()) {
            mPagerAdapter.addPage(TileDashboardFragment_.builder().build());
            addTileToDashboard(tile);
        } else {
            dashboardFragment.addTile(tile);
//            mViewPager.setCurrentItem(item, true);
        }
    }

}
