package com.example.TravelAgency.dto;


import com.example.TravelAgency.model.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {
    private Long id;

    private String address;

    private double longitude;

    private double latitude;

    public LocationDto(Location location){
        id = location.getId();
        address = location.getAddress();
        longitude = location.getLongitude();
        latitude = location.getLatitude();
    }

    public Location convertToLocation(){
        Location location = new Location();
        location.setAddress(address);
        location.setLongitude(longitude);
        location.setLatitude(latitude);
        return location;
    }
}
