package fr.bemyapp.hackyourhair.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class QuizzPagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<Fragment> mFragmentsList = new ArrayList<Fragment>();

    public QuizzPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentsList.size();
    }


    public QuizzPagerAdapter addPage(Fragment fragment) {
        if (fragment != null) {
            mFragmentsList.add(fragment);
        }

        notifyDataSetChanged();
        return this;
    }
}
