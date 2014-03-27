package fr.bemyapp.hackyourhair.fragment.quizz;

import fr.bemyapp.hackyourhair.R;
import fr.bemyapp.hackyourhair.event.QuizzChoiceMadeEvent;
import fr.bemyapp.hackyourhair.fragment.BaseFragment;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.fragment_quizz_hair_density)
public class QuizzHairDensityFragment extends BaseFragment {

    @Click(R.id.quizz_density_dense)
    void onDenseClicked(){
        mEventBus.post(new QuizzChoiceMadeEvent());
    }

    @Click(R.id.quizz_density_normal)
    void onNormalClicked(){
        mEventBus.post(new QuizzChoiceMadeEvent());
    }

    @Click(R.id.quizz_density_sparse)
    void onSparseClicked(){
        mEventBus.post(new QuizzChoiceMadeEvent());
    }
}
