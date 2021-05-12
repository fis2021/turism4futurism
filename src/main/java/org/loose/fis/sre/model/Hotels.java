package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

public class Hotels{
    @Id
    private String id;
    private String cityName, hotelName, price;

    public Hotels(String id, String cityName, String hotelName, String price) {
        this.id = id;
        this.cityName = cityName;
        this.hotelName = hotelName;
        this.price = price;
    }

    public Hotels() {
    }

    public String getNameOfHotel() {
        return hotelName;
    }

    public void setNameOfHotel(String nameOfHotel) {
        this.hotelName = hotelName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCity(String nameOfCity) {
        this.cityName = cityName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}