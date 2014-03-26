package fr.bemyapp.hackyourhair.fragment;

import android.support.v4.app.Fragment;
import fr.bemyapp.hackyourhair.model.DashboardTile;

public abstract class AbstractDashboardFragment extends Fragment{

    public abstract void addTile(DashboardTile tile);
    public abstract void removeTile(int position);
    public abstract boolean isPageFull();

}
