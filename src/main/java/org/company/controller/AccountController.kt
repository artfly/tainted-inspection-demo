package org.company.controller

import org.checkerframework.checker.tainting.qual.Tainted
import org.company.repository.AccountRepository

class Account(val code: String, val type: String)

class AccountController(private val accountRepo: AccountRepository) {
    fun getAccount(code: @Tainted String): Account {
        return accountRepo.getAccount(code) 
    }
}