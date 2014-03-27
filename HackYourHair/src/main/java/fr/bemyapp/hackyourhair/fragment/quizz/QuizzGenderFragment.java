package fr.bemyapp.hackyourhair.fragment.quizz;

import fr.bemyapp.hackyourhair.R;
import fr.bemyapp.hackyourhair.event.QuizzChoiceMadeEvent;
import fr.bemyapp.hackyourhair.fragment.BaseFragment;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.fragment_quizz_gender)
public class QuizzGenderFragment extends BaseFragment {


    @Click(R.id.quizz_male)
    void onMaleClicked(){
        mEventBus.post(new QuizzChoiceMadeEvent());
    }

    @Click(R.id.quizz_female)
    void onFemaleClicked(){
        mEventBus.post(new QuizzChoiceMadeEvent());
    }


}
