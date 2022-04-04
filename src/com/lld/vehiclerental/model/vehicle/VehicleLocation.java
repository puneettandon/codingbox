package com.lld.vehiclerental.model.vehicle;

import com.lld.vehiclerental.model.common.Address;
import com.lld.vehiclerental.model.common.Coordinates;

public class VehicleLocation {

    private String locationId;
    private Address address;
    private Coordinates coordinates;

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
