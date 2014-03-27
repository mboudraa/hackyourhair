package fr.bemyapp.hackyourhair.fragment;

import android.content.Intent;
import android.view.View;
import fr.bemyapp.hackyourhair.AboutActivity_;
import fr.bemyapp.hackyourhair.MapActivity_;
import fr.bemyapp.hackyourhair.R;
import fr.bemyapp.hackyourhair.views.SemiBlurredImageTextView;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;


@EFragment(R.layout.main_dahsboard)
public class MainDashboardFragment extends BaseFragment implements View.OnClickListener {

    @ViewById(R.id.home_about)
    SemiBlurredImageTextView mAboutTile;

    @ViewById(R.id.home_daily_tip)
    SemiBlurredImageTextView mDailyTipTile;

    @ViewById(R.id.home_analyze_my_hair)
    SemiBlurredImageTextView mAnalyzeMyHairTile;

    @ViewById(R.id.home_find_a_salon)
    SemiBlurredImageTextView mFindASalonTile;


    @AfterViews
    void onPostCreate() {
        mAboutTile.setOnClickListener(this);
        mDailyTipTile.setOnClickListener(this);
        mAnalyzeMyHairTile.setOnClickListener(this);
        mFindASalonTile.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.home_daily_tip:
                break;

            case R.id.home_about:
                intent = new Intent(getActivity(), AboutActivity_.class);
                break;

            case R.id.home_analyze_my_hair:
                break;

            case R.id.home_find_a_salon:
                intent = new Intent(getActivity(), MapActivity_.class);
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
