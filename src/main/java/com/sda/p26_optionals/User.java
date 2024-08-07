package com.sda.p26_optionals;

public class User {
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User {" +
                "address=" + address +
                '}';
    }
}


class Address {
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country=" + country +
                '}';
    }
}


class Country {
    private String isoCode;

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    @Override
    public String toString() {
        return "Country{" +
                "isoCode='" + isoCode + '\'' +
                '}';
    }
}
