package fr.bemyapp.hackyourhair;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.res.Configuration;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.about)
public class AboutActivity extends BaseActivity {

    private static final int RIGHT_TO_LEFT = 1;
    private static final int LEFT_TO_RIGHT = 2;
    private static final int DURATION = 46000;

    @ViewById(R.id.about_body)
    TextView mBody;

    @ViewById(R.id.about_background)
    ImageView mBackground;

    // Background animation
    private int mDirection = RIGHT_TO_LEFT;
    private float mScaleFactor;
    private RectF mDisplayRect = new RectF();
    private final Matrix mMatrix = new Matrix();
    private ValueAnimator mCurrentAnimator;

    @AfterViews
    void onPostCreate() {
        mBody.setText(Html.fromHtml(getString(R.string.about_cody)));
        mBody.setMovementMethod(new LinkMovementMethod());

        moveBackground();
    }

    private void moveBackground() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT &&
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
            fadeInBackground();

            // Move background
            mBackground.post(new Runnable() {
                @Override
                public void run() {
                    mScaleFactor = (float) mBackground.getHeight() / (float) mBackground.getDrawable().getIntrinsicHeight();
                    mMatrix.postScale(mScaleFactor, mScaleFactor);
                    mBackground.setImageMatrix(mMatrix);
                    animateBackground();
                }
            });
        } else {
            mBackground.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    private void fadeInBackground() {
        mBackground.setAlpha(0f);
        ViewPropertyAnimator animator = mBackground.animate();
        animator.alpha(1f);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            animator.setStartDelay(250);
        }
        animator.setDuration(1800);
    }

    private void animateBackground() {
        // Update display Rect
        mDisplayRect.set(0, 0, mBackground.getDrawable().getIntrinsicWidth(), mBackground.getDrawable().getIntrinsicHeight());
        mMatrix.mapRect(mDisplayRect);

        if (mDirection == RIGHT_TO_LEFT) {
            animateBackground(0.0f, -(mDisplayRect.right - mBackground.getWidth()));
        } else {
            animateBackground(mDisplayRect.left, 0.0f);
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    private void animateBackground(float from, float to) {
        mCurrentAnimator = ValueAnimator.ofFloat(from, to);
        mCurrentAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (Float) animation.getAnimatedValue();

                mMatrix.reset();
                mMatrix.postScale(mScaleFactor, mScaleFactor);
                mMatrix.postTranslate(value, 0);

                mBackground.setImageMatrix(mMatrix);
            }
        });

        mCurrentAnimator.setDuration(DURATION);
        mCurrentAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                if (mDirection == RIGHT_TO_LEFT) {
                    mDirection = LEFT_TO_RIGHT;
                } else {
                    mDirection = RIGHT_TO_LEFT;
                }
                animateBackground();
            }
        });
        mCurrentAnimator.start();
    }
}
