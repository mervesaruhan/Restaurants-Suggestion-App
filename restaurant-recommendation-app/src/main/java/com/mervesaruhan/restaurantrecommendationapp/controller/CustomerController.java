package com.mervesaruhan.restaurantrecommendationapp.controller;


import com.mervesaruhan.restaurantrecommendationapp.dto.response.CustomerResponseDto;
import com.mervesaruhan.restaurantrecommendationapp.dto.saverequest.CustomerSaveDto;
import com.mervesaruhan.restaurantrecommendationapp.dto.updaterequest.CustomerUpdateDto;
import com.mervesaruhan.restaurantrecommendationapp.restresponse.RestResponse;
import com.mervesaruhan.restaurantrecommendationapp.service.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "restaurant recommendation app", description = "Customer CRUD işlemleri")
@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
@Validated
 class CustomerController {
    private final CustomerService customerService;


    @PostMapping
    public ResponseEntity<RestResponse<CustomerResponseDto>> saveCustomer(@RequestBody @Valid CustomerSaveDto customerSaveDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(RestResponse.of(customerService.save(customerSaveDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestResponse<CustomerResponseDto>> updateCustomer(@RequestBody @Valid CustomerUpdateDto customerUpdateDto, @PathVariable Long id) {
        return ResponseEntity.ok(RestResponse.of(customerService.updateById(id, customerUpdateDto)));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<CustomerResponseDto>>> getAllCustomers() {
        return ResponseEntity.ok(RestResponse.of(customerService.getAllCustomers()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Void>> deleteCustomerById(@PathVariable Long id) {
        customerService.deleteById(id);
        return ResponseEntity.ok(RestResponse.empty());
    }


}
