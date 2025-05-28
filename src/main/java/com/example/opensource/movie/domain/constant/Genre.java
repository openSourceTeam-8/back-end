package com.example.opensource.movie.domain.constant;

public enum Genre {
    ACTION("액션"),
    COMEDY("코미디"),
    ROMANCE("로맨스"),
    THRILLER("스릴러"),
    HORROR("공포"),
    DRAMA("드라마"),
    SF("SF"),
    ANIMATION("애니메이션"),
    CRIME("범죄"),
    WAR("전쟁"),
    FANTASY("판타지"),
    MUSICAL("음악(뮤지컬)"),
    DOCUMENTARY("다큐멘터리"),
    SPORTS("스포츠");

    private final String displayName;

    Genre(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
