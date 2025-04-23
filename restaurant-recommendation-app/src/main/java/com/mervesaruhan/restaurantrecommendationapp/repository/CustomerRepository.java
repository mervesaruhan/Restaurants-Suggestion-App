package com.mervesaruhan.restaurantrecommendationapp.repository;

import com.mervesaruhan.restaurantrecommendationapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
