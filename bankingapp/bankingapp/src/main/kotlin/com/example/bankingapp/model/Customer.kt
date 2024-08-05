package com.example.bankingapp.model

import jakarta.persistence.*

@Entity
data class Customer(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column(unique = true)
    val customerId: String = "",
    val name: String = "",
    @OneToMany(mappedBy = "customer", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val accounts: List<Account> = mutableListOf()
)
