package com.mervesaruhan.restaurantrecommendationapp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name= "CUSTOMER")
@ToString(exclude ="commentList")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer")
    @SequenceGenerator(name="customer", sequenceName = "CUSTOMER_ID_SEQ", allocationSize=1)
    @Column(name = "ID")
    private Long id;

    @Column(name ="NAME",nullable = false)
    @NotBlank
    @Size(min = 2, max = 50)
    private String name;

    @Column(name="SURNAME",nullable = false)
    @NotBlank
    @Size(min = 2, max = 50)
    private String surname;

    @Column(name="LATITUDE",nullable = false)
    @NotNull
    @Positive
    private Double latidute;

    @Column(name="LONGITUDE",nullable = false)
    @NotNull
    @Positive
    private Double longitude;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comment> commentList = new ArrayList<>();
}
