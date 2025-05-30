package com.example.opensource.movie.domain.constant;

public enum Countries {
    KOREA("한국"),
    AMERICA("미국");

    private final String country;


    Countries(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
}
