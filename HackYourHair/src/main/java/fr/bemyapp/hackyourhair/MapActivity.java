package fr.bemyapp.hackyourhair;

import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import fr.bemyapp.hackyourhair.model.findsalon.FindSalonResponse;
import fr.bemyapp.hackyourhair.model.findsalon.SalonEntry;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;


@EActivity(R.layout.activity_map)
public class MapActivity extends FragmentActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private FindSalonResponse mSalons;

    private GoogleMap mMap;


    @AfterViews
    void onPostCreate() {
        mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();

        Serializer serializer = new Persister();
        try {
            mSalons = serializer.read(FindSalonResponse.class, getResources().openRawResource(R.raw.find_a_salon), false);
            for (SalonEntry entry : mSalons.getSalons()) {
                if (entry.hasHaircare()) {
                    LatLng position = new LatLng(entry.getLatitude(), entry.getLongitude());
                    mMap.addMarker(new MarkerOptions().position(position)
                            .title(entry.getName())
                            .snippet(entry.getAddress())
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
                    //.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                }
            }

            // Showing current location
            mMap.setMyLocationEnabled(true);

            // Move the camera instantly to our current location with a zoom of 12
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mSalons.getCenterPoint(), 12));

            // Zoom in, animating the camera.
            mMap.animateCamera(CameraUpdateFactory.zoomTo(13.5f), 2000, null);
        } catch (Exception e) {
            Log.e(TAG, "", e);
        }
    }

}
