package fr.bemyapp.hackyourhair.model.findsalon;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "poi")
public class SalonEntry {

    @Element
    private String name;

    @Element
    private String address1;

    @Element(required = false)
    private String address2;

    @Element
    private String city;

    @Element
    private boolean haircare;

    @Element
    private double latitude;

    @Element
    private double longitude;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address1;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public boolean hasHaircare() {
        return haircare;
    }
}
