package fr.bemyapp.hackyourhair.fragment;

import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import fr.bemyapp.hackyourhair.R;
import fr.bemyapp.hackyourhair.model.DashboardTile;
import fr.bemyapp.hackyourhair.views.SemiBlurredImageTextView;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.tile_dahsboard)
public class TileDashboardFragment extends AbstractDashboardFragment {


    @ViewById(R.id.tile1)
    SemiBlurredImageTextView mTile1;

    @ViewById(R.id.tile2)
    SemiBlurredImageTextView mTile2;

    @ViewById(R.id.tile3)
    SemiBlurredImageTextView mTile3;

    @ViewById(R.id.tile4)
    SemiBlurredImageTextView mTile4;

    @ViewById(R.id.tile5)
    SemiBlurredImageTextView mTile5;

    SparseArray<DashboardTile> mTilesSparseArray = new SparseArray<DashboardTile>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mTilesSparseArray = savedInstanceState.getSparseParcelableArray("tiles");
        }

        if (mTilesSparseArray == null) {
            mTilesSparseArray = new SparseArray<DashboardTile>();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        initDashboard();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSparseParcelableArray("tiles", mTilesSparseArray);
    }

    @Override
    public void addTile(final DashboardTile tile) {
        if (isPageFull()) {
            return;
        }

        Log.i(this.toString(), "ADD TILE -> " + tile);
        int index = mTilesSparseArray.size();
        mTilesSparseArray.put(index, tile);
        updateTile(index, tile);
    }


    void initDashboard() {
        Log.i(this.toString(), "INIT DASHBOARD");
        if (isVisible()) {
            mTile1.update(0, 0);
            mTile2.update(0, 0);
            mTile3.update(0, 0);
            mTile4.update(0, 0);
            mTile5.update(0, 0);
        }
        for (int i = 0; i < mTilesSparseArray.size(); i++) {
            DashboardTile tile = mTilesSparseArray.get(mTilesSparseArray.keyAt(i));
            updateTile(i, tile);
        }
    }

    void updateTile(final int index, final DashboardTile tile) {
        Log.i(this.toString(), "FRAGMENT VISIBLE -> " + isVisible());
        if (isVisible()) {
            Log.i(this.toString(), "UPDATING TILE " + index + " -> " + tile);
            SemiBlurredImageTextView tileView = getTile(index);
            registerForContextMenu(tileView);
            tileView.update(tile.getTitle(), tile.getBackground());
            tileView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void removeTile(int position) {

    }


    private int getIndex(View v) {
        switch (v.getId()) {
            case R.id.tile1:
                return 0;

            case R.id.tile2:
                return 1;

            case R.id.tile3:
                return 2;

            case R.id.tile4:
                return 3;

            case R.id.tile5:
                return 4;

            default:
                return -1;
        }
    }

    private SemiBlurredImageTextView getTile(int index) {

        SemiBlurredImageTextView tileView;

        switch (index) {
            case 0:
                tileView = mTile1;
                break;

            case 1:
                tileView = mTile2;
                break;

            case 2:
                tileView = mTile3;
                break;

            case 3:
                tileView = mTile4;
                break;

            case 4:
                tileView = mTile5;
                break;

            default:
                tileView = null;
                break;
        }


        return tileView;
    }

    @Override
    public boolean isPageFull() {
        return mTilesSparseArray.size() == 5;
    }


}
