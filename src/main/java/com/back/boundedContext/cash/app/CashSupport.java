package com.back.boundedContext.cash.app;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.back.boundedContext.cash.domain.CashMember;
import com.back.boundedContext.cash.domain.Wallet;
import com.back.boundedContext.cash.out.CashMemberRepository;
import com.back.boundedContext.cash.out.WalletRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CashSupport {
	private final CashMemberRepository cashMemberRepository;
	private final WalletRepository walletRepository;

	public Optional<CashMember> findMemberByUserName(String userName) {
		return cashMemberRepository.findByUserName(userName);
	}

	public Optional<Wallet> findWalletByHolder(CashMember holder) {
		return walletRepository.findByHolder(holder);
	}
}
