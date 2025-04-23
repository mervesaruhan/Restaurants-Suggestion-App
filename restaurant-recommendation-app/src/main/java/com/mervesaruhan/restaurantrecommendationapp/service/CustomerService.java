package com.mervesaruhan.restaurantrecommendationapp.service;

import com.mervesaruhan.restaurantrecommendationapp.dto.response.CustomerResponseDto;
import com.mervesaruhan.restaurantrecommendationapp.dto.saverequest.CustomerSaveDto;
import com.mervesaruhan.restaurantrecommendationapp.dto.updaterequest.CustomerUpdateDto;
import com.mervesaruhan.restaurantrecommendationapp.entity.Customer;
import com.mervesaruhan.restaurantrecommendationapp.mapper.CustomerMapper;
import com.mervesaruhan.restaurantrecommendationapp.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerResponseDto save(CustomerSaveDto customerSaveDto) {
        var customer = customerMapper.toEntity(customerSaveDto);
        var saved =customerRepository.save(customer);
        return customerMapper.toDto(saved);
    }

    public CustomerResponseDto updateById(Long id, CustomerUpdateDto customerUpdateDto ) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if(customer == null) { throw new EntityNotFoundException("Customer not found with id: " + id);}
        customer.setName(customerUpdateDto.name());
        customer.setSurname(customerUpdateDto.surname());
        customer.setLatidute(customerUpdateDto.latitude());
        customer.setLongitude(customerUpdateDto.longitude());
        Customer updated = customerRepository.save(customer);
        return customerMapper.toDto(updated);
    }

    public void deleteById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + id));
        customerRepository.delete(customer);
    }

    public List<CustomerResponseDto> getAllCustomers() {
        return customerMapper.toDtoList(customerRepository.findAll());
    }
    
}
