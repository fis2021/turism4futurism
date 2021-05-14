package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

public class Hotels{
    @Id
    private String id;
    private String cityName, hotelName;
    private Integer price;

    public Hotels(String id, String cityName, String hotelName, Integer price) {
        this.id = id;
        this.cityName = cityName;
        this.hotelName = hotelName;
        this.price = price;
    }

    public Hotels(String cityName, String hotelName, Integer price) {
        this.cityName = cityName;
        this.hotelName = hotelName;
        this.price = price;
    }


    public Hotels() {
    }


    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotels hotels = (Hotels) o;

        if (!cityName.equals(hotels.cityName)) return false;
        return price<hotels.price;
    }

    @Override
    public int hashCode() {
        int result = cityName.hashCode();
        result = 31 * result + hotelName.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Hotels{" +
                "cityName='" + cityName + '\'' +
                ", hotels='" + hotelName + '\'' +
                ", price='" + price + '\'' +
                ", ID=" + id +
                '}';
    }
}