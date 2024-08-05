// File: src/main/kotlin/com/example/bankingapp/controller/CustomerController.kt
package com.example.bankingapp.controller

import com.example.bankingapp.model.Customer
import com.example.bankingapp.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerController(
    @Autowired private val customerService: CustomerService
) {

    @PostMapping
    fun createCustomer(@RequestBody name: String): Customer {
        return customerService.createCustomer(name)
    }

    @GetMapping
    fun getAllCustomers(): List<Customer> {
        return customerService.getAllCustomers()
    }
}
