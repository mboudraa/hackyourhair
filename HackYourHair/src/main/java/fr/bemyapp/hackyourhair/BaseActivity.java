package fr.bemyapp.hackyourhair;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public abstract class BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CalligraphyConfig.initDefault("fonts/roboto_regular.ttf");
        getActionBar().setDisplayShowTitleEnabled(false);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(new CalligraphyContextWrapper(newBase));
    }
}
