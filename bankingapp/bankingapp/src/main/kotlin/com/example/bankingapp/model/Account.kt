package com.example.bankingapp.model

import jakarta.persistence.*

@Entity
data class Account(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column(unique = true)
    val accountNumber: String = "",
    @Enumerated(EnumType.STRING)
    val accountType: AccountType = AccountType.SAVINGS,
    var balance: Double = 0.0,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    val customer: Customer? = null,
    @OneToMany(mappedBy = "account", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val transactions: List<Transaction> = mutableListOf()
)
