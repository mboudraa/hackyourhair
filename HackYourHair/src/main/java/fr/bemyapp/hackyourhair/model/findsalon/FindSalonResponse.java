package fr.bemyapp.hackyourhair.model.findsalon;

import com.google.android.gms.maps.model.LatLng;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "response")
public class FindSalonResponse {

    @Attribute
    private int code;

    @Element
    private Collection collection;

    public List<SalonEntry> getSalons() {
        return collection.entries;
    }

    public LatLng getCenterPoint() {
        String[] coords = collection.centerpoint.split(",");
        return new LatLng(Double.parseDouble(coords[1]), Double.parseDouble(coords[0]));
    }

    static final class Collection {

        @Attribute
        int count;

        @Attribute
        String centerpoint;

        @ElementList(inline = true)
        List<SalonEntry> entries;
    }
}
