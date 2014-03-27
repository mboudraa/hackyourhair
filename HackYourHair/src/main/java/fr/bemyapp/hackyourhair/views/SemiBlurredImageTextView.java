package fr.bemyapp.hackyourhair.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import fr.bemyapp.hackyourhair.R;
import fr.bemyapp.hackyourhair.utils.Compatibility;
import fr.bemyapp.hackyourhair.utils.FastBlur;

public class SemiBlurredImageTextView extends FrameLayout {

    private TextView mText;
    private ImageView mBackground;

    private String mOnClickedId;
    private int mBlurredRadius;

    public SemiBlurredImageTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public SemiBlurredImageTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.semi_blurred_image_text_view, this, true);
        mText = (TextView) findViewById(R.id.blurred_text);
        mBackground = (ImageView) findViewById(R.id.blurred_image);
        setCustomAttributes(context, attrs);
        applyBlur();
    }

    private void setCustomAttributes(Context context, AttributeSet attrs) {
        TypedArray styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.SemiBlurredImageTextView);

        Drawable background = styledAttrs.getDrawable(R.styleable.SemiBlurredImageTextView_imageBackground);
        mBackground.setImageDrawable(background);

        CharSequence text = styledAttrs.getText(R.styleable.SemiBlurredImageTextView_blurredText);
        mText.setText(text);

        mBlurredRadius = styledAttrs.getInt(R.styleable.SemiBlurredImageTextView_blurredRadius, 4);
        mOnClickedId = styledAttrs.getString(R.styleable.SemiBlurredImageTextView_onClickedId);

        styledAttrs.recycle();
    }

    private void applyBlur() {
        mBackground.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                mBackground.getViewTreeObserver().removeOnPreDrawListener(this);
                mBackground.buildDrawingCache();

                Bitmap bmp = mBackground.getDrawingCache();
                blur(bmp, mText);
                return true;
            }
        });
    }

    // Blurs, downscaling the bitmap first
    private void blur(Bitmap bkg, View view) {
        float scaleFactor = 8;

        Bitmap overlay = Bitmap.createBitmap((int) (view.getMeasuredWidth() / scaleFactor), (int) (view.getMeasuredHeight() / scaleFactor), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(overlay);
        canvas.translate(-view.getLeft() / scaleFactor, -view.getTop() / scaleFactor);
        canvas.scale(1 / scaleFactor, 1 / scaleFactor);

        Paint paint = new Paint();
        paint.setFlags(Paint.FILTER_BITMAP_FLAG);
        canvas.drawBitmap(bkg, 0, 0, paint);

        overlay = FastBlur.doBlur(overlay, mBlurredRadius, true);
        Compatibility.setBackground(view, new BitmapDrawable(getResources(), overlay));
    }

    public void update(int title, int background) {
        mBackground.setBackgroundResource(background);
        if (title != 0) {
            mText.setText(title);
        } else {
            mText.setText(null);
        }
        applyBlur();
        invalidate();
    }
}
