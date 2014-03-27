package fr.bemyapp.hackyourhair;

import android.content.Intent;
import android.view.View;
import fr.bemyapp.hackyourhair.views.SemiBlurredImageTextView;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity implements View.OnClickListener {

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
                intent = new Intent(this, ResultActivity_.class);
                intent.putExtra(ResultActivity.EXTRA_TIP, true);
                break;
            case R.id.home_about:
                intent = new Intent(this, AboutActivity_.class);
                break;
            case R.id.home_analyze_my_hair:
                intent = new Intent(this, QuizzActivity_.class);
                break;
            case R.id.home_find_a_salon:
                intent = new Intent(this, MapActivity_.class);
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
