package com.mervesaruhan.restaurantrecommendationapp.enums;

public enum EnumScore {
    ONE(1.0),
    TWO(2.0),
    THREE(3.0),
    FOUR(4.0),
    FIVE(5.0);

    //sayısal degerleri alabilmek için dönüşüm işlmei gerkeiyor

    private final Double value;
    private EnumScore(Double value) {
        this.value = value;
    }
    public Double getValue() {
        return value;
    }

    public static EnumScore fromValue(Double value) {
        for (EnumScore score : EnumScore.values()) {
            if (score.getValue().equals(value)) {
                return score;
            }
        }
        throw new IllegalArgumentException("Geçersiz puan: " + value);
    }

}
