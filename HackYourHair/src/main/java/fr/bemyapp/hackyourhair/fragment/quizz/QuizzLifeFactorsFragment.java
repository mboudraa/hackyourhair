package fr.bemyapp.hackyourhair.fragment.quizz;

import fr.bemyapp.hackyourhair.R;
import fr.bemyapp.hackyourhair.event.QuizzChoiceMadeEvent;
import fr.bemyapp.hackyourhair.fragment.BaseFragment;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.fragment_quizz_life_factors)
public class QuizzLifeFactorsFragment extends BaseFragment {

    @Click(R.id.quizz_life_factors_hairloss)
    void onHairLossClicked() {
        mEventBus.post(new QuizzChoiceMadeEvent());
    }

    @Click(R.id.quizz_life_factors_pregnancy)
    void onPregnancyClicked() {
        mEventBus.post(new QuizzChoiceMadeEvent());
    }

    @Click(R.id.quizz_life_factors_stress)
    void onStressClicked() {
        mEventBus.post(new QuizzChoiceMadeEvent());
    }
}
