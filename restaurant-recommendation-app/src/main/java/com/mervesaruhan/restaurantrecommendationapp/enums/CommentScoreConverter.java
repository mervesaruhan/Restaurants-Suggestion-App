package com.mervesaruhan.restaurantrecommendationapp.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CommentScoreConverter implements AttributeConverter<EnumScore, Double> {
    @Override
    public Double convertToDatabaseColumn(EnumScore score) {
        return score != null ? score.getValue() : null;
    }

    @Override
    public EnumScore convertToEntityAttribute(Double value) {
        return value != null ? EnumScore.fromValue(value) : null;
    }
}
