package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

public class Booking{
    @Id
    private String id;
    private String clientUsername, cityName, hotelName, nrPers, totalPrice, checkInDate, checkOutDate;

    public Booking(String id, String clientUsername, String cityName, String hotelName, String nrPers, String totalPrice, String checkInDate, String checkOutDate) {
        this.id = id;
        this.clientUsername = clientUsername;
        this.cityName = cityName;
        this.hotelName = hotelName;
        this.nrPers = nrPers;
        this.totalPrice = totalPrice;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Booking(){

    }

    public String getNrPers() {
        return nrPers;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public String getCity() {
        return cityName;
    }

    public String getClientUsername() {
        return clientUsername;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getId() {
        return id;
    }


}