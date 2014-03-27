package fr.bemyapp.hackyourhair;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import de.greenrobot.event.EventBus;
import fr.bemyapp.hackyourhair.adapter.QuizzPagerAdapter;
import fr.bemyapp.hackyourhair.event.QuizzChoiceMadeEvent;
import fr.bemyapp.hackyourhair.event.QuizzGoToRecommandationEvent;
import fr.bemyapp.hackyourhair.fragment.quizz.*;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.InstanceState;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_quizz)
public class QuizzActivity extends BaseActivity {

    EventBus mEventBus = EventBus.getDefault();

    @ViewById(R.id.quizz_viewpager)
    ViewPager mViewPager;

    QuizzPagerAdapter mPagerAdapter;

    @InstanceState
    int mCurrentViewPagerItem = 0;

    @AfterViews
    void onPostCreate() {
        mPagerAdapter = new QuizzPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);

        initQuizzFragments();

        mViewPager.setCurrentItem(mCurrentViewPagerItem);
    }

    private void initQuizzFragments() {
        mPagerAdapter
                .addPage(QuizzGenderFragment_.builder().build())
                .addPage(QuizzHairDensityFragment_.builder().build())
                .addPage(QuizzHairLenghtFragment_.builder().build())
                .addPage(QuizzLifeFactorsFragment_.builder().build())
                .addPage(QuizzStageHairLossFragment_.builder().build());

    }

    public void onEventMainThread(QuizzChoiceMadeEvent event) {
        mCurrentViewPagerItem++;
        mViewPager.setCurrentItem(mCurrentViewPagerItem);
    }

    public void onEventMainThread(QuizzGoToRecommandationEvent event) {
        startActivity(new Intent(this, ResultActivity_.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        mEventBus.register(this);
    }

    @Override
    protected void onPause() {
        mEventBus.unregister(this);
        super.onPause();
    }
}
