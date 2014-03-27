package fr.bemyapp.hackyourhair;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.result)
public class ResultActivity extends BaseActivity {

    private static final int MENU_PRODUCTS = 0;
    private static final int MENU_HAIRCUTS = 1;
    private static final int MENU_ADVICES = 2;

    @ViewById(R.id.result_component_products)
    View mCompProducts;

    @ViewById(R.id.result_component_haircuts)
    View mCompHaircuts;

    @ViewById(R.id.result_component_advices)
    View mCompAdvices;

    @ViewById(R.id.result_subcontainer)
    FrameLayout mContainer;

    @ViewById(R.id.result_products)
    TextView mMenuProducts;

    @ViewById(R.id.result_haircuts)
    TextView mMenuHaircuts;

    @ViewById(R.id.result_advices)
    TextView mMenuAdvices;

    @AfterViews
    void afterViews() {
        onProductsClicked();
    }

    @Click(R.id.result_advices)
    void onAdvicesClicked() {
        updateHeadlinesColors(MENU_ADVICES);
        changeSubView(MENU_ADVICES);
    }

    @Click(R.id.result_haircuts)
    void onHaircutsClicked() {
        updateHeadlinesColors(MENU_HAIRCUTS);
        changeSubView(MENU_HAIRCUTS);
    }

    @Click(R.id.result_products)
    void onProductsClicked() {
        updateHeadlinesColors(MENU_PRODUCTS);
        changeSubView(MENU_PRODUCTS);
    }

    void updateHeadlinesColors(int type) {
        int selectedColor = getResources().getColor(R.color.result_title_active);
        int unselectedColor = getResources().getColor(R.color.result_title_inactive);

        mMenuProducts.setTextColor(unselectedColor);
        mMenuHaircuts.setTextColor(unselectedColor);
        mMenuAdvices.setTextColor(unselectedColor);

        switch (type) {
            case MENU_PRODUCTS:
                mMenuProducts.setTextColor(selectedColor);
                break;
            case MENU_HAIRCUTS:
                mMenuHaircuts.setTextColor(selectedColor);
                break;
            case MENU_ADVICES:
                mMenuAdvices.setTextColor(selectedColor);
                break;
        }
    }

    void changeSubView(int type) {
        mCompAdvices.setVisibility(View.GONE);
        mCompHaircuts.setVisibility(View.GONE);
        mCompProducts.setVisibility(View.GONE);

        switch (type) {
            case MENU_PRODUCTS:
                mCompProducts.setVisibility(View.VISIBLE);
                break;
            case MENU_HAIRCUTS:
                mCompHaircuts.setVisibility(View.VISIBLE);
                break;
            case MENU_ADVICES:
                mCompAdvices.setVisibility(View.VISIBLE);
                break;
        }
    }
}
