package fr.bemyapp.hackyourhair.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import fr.bemyapp.hackyourhair.fragment.AbstractDashboardFragment;

import java.util.ArrayList;

public class DashboardPagerAdapter extends FragmentStatePagerAdapter{

    ArrayList<AbstractDashboardFragment> mFragmentArrayList = new ArrayList<AbstractDashboardFragment>();
    public DashboardPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addPage(AbstractDashboardFragment f){
        if(f != null){
            mFragmentArrayList.add(f);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mFragmentArrayList.size();
    }

    @Override
    public int getItemPosition(Object fragment) {
         int position = mFragmentArrayList.indexOf(fragment);
        if(position == -1){
            position = POSITION_NONE;
        }
        return position;
    }

    @Override
    public AbstractDashboardFragment getItem(int position) {
        return mFragmentArrayList.get(position);
    }

}
