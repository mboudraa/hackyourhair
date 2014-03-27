package fr.bemyapp.hackyourhair.fragment.quizz;

import fr.bemyapp.hackyourhair.R;
import fr.bemyapp.hackyourhair.event.QuizzChoiceMadeEvent;
import fr.bemyapp.hackyourhair.fragment.BaseFragment;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.fragment_quizz_hair_lenght)
public class QuizzHairLenghtFragment extends BaseFragment {


    @Click(R.id.quizz_hair_lenght_long)
    void onLongClicked() {
        mEventBus.post(new QuizzChoiceMadeEvent());
    }

    @Click(R.id.quizz_hair_lenght_medium)
    void onMediumClicked() {
        mEventBus.post(new QuizzChoiceMadeEvent());
    }

    @Click(R.id.quizz_hair_lenght_short)
    void onShortClicked() {
        mEventBus.post(new QuizzChoiceMadeEvent());
    }
}
