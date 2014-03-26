package fr.bemyapp.hackyourhair.utils;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

public class Compatibility {

    private Compatibility() {
        throw new UnsupportedOperationException();
    }

    /**
     * Checks if current SDK is compatible with the desired API level.
     *
     * @param apiLevel the required API level
     * @return {@code true} if current OS is compatible
     */
    public static boolean isCompatible(int apiLevel) {
        return android.os.Build.VERSION.SDK_INT >= apiLevel;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void setBackground(View view, Drawable drawable) {
        if (Compatibility.isCompatible(Build.VERSION_CODES.JELLY_BEAN)) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }
}
