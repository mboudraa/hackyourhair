package fr.bemyapp.hackyourhair.fragment.quizz;

import fr.bemyapp.hackyourhair.R;
import fr.bemyapp.hackyourhair.event.QuizzGoToRecommandationEvent;
import fr.bemyapp.hackyourhair.fragment.BaseFragment;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.fragment_quizz_stage_hairloss)
public class QuizzStageHairLossFragment extends BaseFragment {

    @Click(R.id.quizz_stage_hairloss_mild_moderate)
    void onMildModeratesClicked() {
        mEventBus.post(new QuizzGoToRecommandationEvent());
    }

    @Click(R.id.quizz_stage_hairloss_moderate_heavy)
    void onModerateHeavyClicked() {
        mEventBus.post(new QuizzGoToRecommandationEvent());
    }


}
