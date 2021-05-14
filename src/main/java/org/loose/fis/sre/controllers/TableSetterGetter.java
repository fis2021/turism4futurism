package org.loose.fis.sre.controllers;

import javafx.scene.control.CheckBox;

public class TableSetterGetter {

    private String id;
    private String cityName, hotelName;
    private Integer price;

    public TableSetterGetter(String id, String cityName, String hotelName, Integer price, CheckBox checkbox) {
        this.id = id;
        this.cityName = cityName;
        this.hotelName = hotelName;
        this.price = price;
        this.checkbox = checkbox;
    }

    public TableSetterGetter(String cityName, String hotelName, Integer price) {
        this.cityName = cityName;
        this.hotelName = hotelName;
        this.price = price;
    }

    CheckBox checkbox;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public CheckBox getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(CheckBox checkbox) {
        this.checkbox = checkbox;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TableSetterGetter hotels = (TableSetterGetter) o;

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
