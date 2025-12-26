package com.back.boundedContext.cash.out;

import org.springframework.data.repository.CrudRepository;

import com.back.boundedContext.cash.domain.Wallet;

public interface WalletRepository extends CrudRepository<Wallet, Integer> {
}
