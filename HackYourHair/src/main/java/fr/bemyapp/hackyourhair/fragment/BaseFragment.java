package fr.bemyapp.hackyourhair.fragment;

import android.support.v4.app.Fragment;
import de.greenrobot.event.EventBus;

public class BaseFragment extends Fragment {

    protected EventBus mEventBus = EventBus.getDefault();
}
