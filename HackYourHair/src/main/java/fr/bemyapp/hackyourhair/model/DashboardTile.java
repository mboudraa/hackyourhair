package fr.bemyapp.hackyourhair.model;

import android.os.Parcel;
import android.os.Parcelable;

public class DashboardTile implements Parcelable {

    private int mDrawable;
    private int mTitle;

    public DashboardTile(int title, int background) {
        mDrawable = background;
        mTitle = title;
    }

    private DashboardTile(Parcel in) {
        mDrawable = in.readInt();
        mTitle = in.readInt();
    }

    public int getBackground() {
        return mDrawable;
    }

    public int getTitle() {
        return mTitle;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mDrawable);
        dest.writeInt(mTitle);
    }


    public static final Parcelable.Creator<DashboardTile> CREATOR = new Parcelable.Creator<DashboardTile>() {
        public DashboardTile createFromParcel(Parcel in) {
            return new DashboardTile(in);
        }

        public DashboardTile[] newArray(int size) {
            return new DashboardTile[size];
        }
    };

    @Override
    public int describeContents() {
        return mDrawable + mTitle;
    }


}
