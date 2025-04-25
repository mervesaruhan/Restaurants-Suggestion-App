package com.mervesaruhan.restaurantrecommendationapp.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mervesaruhan.restaurantrecommendationapp.enums.EnumScore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="COMMENT")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "comment")
    @SequenceGenerator(name ="comment", sequenceName = "COMMNET_ID_SEQ",allocationSize = 1)
    private Long id;

    @Column(name = "TEXT", nullable = false, length = 500)
    @NotBlank
    @Size(min = 2, max = 500)
    private String text;

    @Column(name="SCORE",nullable = false)
    @NotNull
    private EnumScore score;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="CUSTOMER_ID")
    private Customer customer;

    //@ManyToOne
    //@JoinColumn(name="RESTAURANT_ID")
    @Column(name="RESTAURANT_ID",nullable = false)
    private Long restaurantId;

}
