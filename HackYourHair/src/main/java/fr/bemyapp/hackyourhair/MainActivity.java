package fr.bemyapp.hackyourhair;

import fr.bemyapp.hackyourhair.adapter.DashboardPagerAdapter;
import fr.bemyapp.hackyourhair.fragment.AbstractDashboardFragment;
import fr.bemyapp.hackyourhair.fragment.MainDashboardFragment_;
import fr.bemyapp.hackyourhair.fragment.TileDashboardFragment;
import fr.bemyapp.hackyourhair.fragment.TileDashboardFragment_;
import fr.bemyapp.hackyourhair.model.DashboardTile;
import fr.castorflex.android.verticalviewpager.VerticalViewPager;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.InstanceState;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @ViewById(R.id.vertical_viewpager)
    VerticalViewPager mViewPager;

    DashboardPagerAdapter mPagerAdapter;

    @InstanceState
    ArrayList<DashboardTile> mTilesList = new ArrayList<DashboardTile>();

    @InstanceState
    boolean mTilesAlreadyLoaded;

    @AfterViews
    void onPostCreate() {
        mPagerAdapter = new DashboardPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);


        mPagerAdapter.addPage(MainDashboardFragment_.builder().build());

        if (mTilesAlreadyLoaded) {
            for (DashboardTile tile : mTilesList) {
                createOrUpdateTileFragment(tile);
            }
        } else {
            addTileToDashboard(new DashboardTile(R.string.tile_fake_title, R.drawable.home_3));
            addTileToDashboard(new DashboardTile(R.string.tile_fake_title, R.drawable.home_3));
            addTileToDashboard(new DashboardTile(R.string.tile_fake_title, R.drawable.home_3));
            addTileToDashboard(new DashboardTile(R.string.tile_fake_title, R.drawable.home_3));
            addTileToDashboard(new DashboardTile(R.string.tile_fake_title, R.drawable.home_3));
            addTileToDashboard(new DashboardTile(R.string.tile_fake_title, R.drawable.home_3));
            addTileToDashboard(new DashboardTile(R.string.tile_fake_title, R.drawable.home_3));
            mTilesAlreadyLoaded = true;
        }

    }

    public void addTileToDashboard(DashboardTile tile) {
        mTilesList.add(tile);
        createOrUpdateTileFragment(tile);
    }

    private void createOrUpdateTileFragment(DashboardTile tile) {
        final int item = mPagerAdapter.getCount() - 1;

        AbstractDashboardFragment dashboardFragment = mPagerAdapter.getItem(item);
        if (dashboardFragment.isPageFull()) {
            TileDashboardFragment fragment = TileDashboardFragment_.builder().build();
            mPagerAdapter.addPage(fragment);
            createOrUpdateTileFragment(tile);
        } else {
            dashboardFragment.addTile(tile);
//            mViewPager.setCurrentItem(item, true);
        }
    }

}
