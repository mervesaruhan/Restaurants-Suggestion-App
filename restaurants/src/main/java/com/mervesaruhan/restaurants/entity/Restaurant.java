package com.mervesaruhan.restaurants.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name= "RESTAURANT")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "restaurant")
    @SequenceGenerator(name ="restaurant", sequenceName = "RESTAURANT_ID_SEQ",allocationSize = 1)
    private Long id;

    @Column(name ="NAME",nullable = false)
    @NotBlank
    @Size(min = 2, max = 200)
    private String name;

    @Column(name="LATITUDE",nullable = false)
    @NotNull
    @Positive
    private Double latitude;

    @Column(name="LONGITUDE",nullable = false)
    @NotNull
    @Positive
    private Double longitude;


    @Builder.Default
    @Column (name = "AVERAGE_SCORE",nullable = false)
    private Double averageScore = 0.0;
}
