package fr.bemyapp.hackyourhair.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import fr.bemyapp.hackyourhair.fragment.AbstractDashboardFragment;

import java.util.LinkedList;

public class DashboardPagerAdapter extends FragmentStatePagerAdapter {

    LinkedList<AbstractDashboardFragment> mFragmentList = new LinkedList<AbstractDashboardFragment>();

    public DashboardPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addPage(AbstractDashboardFragment f) {

        if (f != null) {
            Log.i(this.toString(), "ADDING PAGE -> " + f);
            mFragmentList.add(f);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }


    public void clear() {
        mFragmentList.clear();
        notifyDataSetChanged();
    }

    @Override
    public AbstractDashboardFragment getItem(int position) {
        return mFragmentList.get(position);
    }

}
