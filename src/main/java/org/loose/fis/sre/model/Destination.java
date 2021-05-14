package org.loose.fis.sre.model;

public class Destination {

    private String city;
    private String hotel;
    private String typeOfTransport;
    private double pricePerson;

    public Destination(String city, String hotel, String typeOfTransport, double pricePerson) {
        this.city = city;
        this.hotel = hotel;
        this.typeOfTransport = typeOfTransport;
        this.pricePerson = pricePerson;
    }

    public Destination(){
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getTypeOfTransport() {
        return typeOfTransport;
    }

    public void setTypeOfTransport(String typeOfTransport) {
        this.typeOfTransport = typeOfTransport;
    }

    public double getPricePerson() {
        return pricePerson;
    }

    public void setPricePerson(double pricePerson) {
        this.pricePerson = pricePerson;
    }
}
