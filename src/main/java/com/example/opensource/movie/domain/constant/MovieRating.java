package com.example.opensource.movie.domain.constant;

public enum MovieRating {
    ALL("전체 관람가"),
    AGE_12("12세 이상 관람가"),
    AGE_15("15세 이상 관람가"),
    RESTRICTED("청소년 관람불가");

    private final String displayName;

    MovieRating(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
