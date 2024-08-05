// File: src/main/kotlin/com/example/bankingapp/controller/TransactionController.kt
package com.example.bankingapp.controller

import com.example.bankingapp.model.Transaction
import com.example.bankingapp.service.TransactionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/transactions")
class TransactionController(
    @Autowired private val transactionService: TransactionService
) {

    @PostMapping("/deposit")
    fun deposit(@RequestParam accountNumber: String, @RequestParam amount: Double): Transaction {
        return transactionService.deposit(accountNumber, amount)
    }

    @PostMapping("/withdraw")
    fun withdraw(@RequestParam accountNumber: String, @RequestParam amount: Double): Transaction {
        return transactionService.withdraw(accountNumber, amount)
    }

    @PostMapping("/transfer")
    fun transfer(@RequestParam fromAccountNumber: String, @RequestParam toAccountNumber: String, @RequestParam amount: Double): Transaction {
        return transactionService.transfer(fromAccountNumber, toAccountNumber, amount)
    }

    @GetMapping
    fun getTransactions(@RequestParam accountNumber: String, @RequestParam startDate: LocalDateTime, @RequestParam endDate: LocalDateTime): List<Transaction> {
        return transactionService.getTransactions(accountNumber, startDate, endDate)
    }
}
