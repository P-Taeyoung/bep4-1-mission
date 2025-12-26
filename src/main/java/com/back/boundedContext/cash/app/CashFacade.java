package com.back.boundedContext.cash.app;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.back.boundedContext.cash.domain.CashMember;
import com.back.boundedContext.cash.domain.Wallet;
import com.back.boundedContext.cash.out.CashMemberRepository;
import com.back.boundedContext.cash.out.WalletRepository;
import com.back.shared.member.dto.MemberDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CashFacade {
	private final CashMemberRepository cashMemberRepository;
	private final WalletRepository walletRepository;

	@Transactional
	public CashMember syncMember(MemberDto memberDto) {
		CashMember _member = new CashMember(
			memberDto.getId(),
			memberDto.getCreateTime(),
			memberDto.getModifyTime(),
			memberDto.getUserName(),
			"",
			memberDto.getNickName(),
			memberDto.getActivityScore()
		);

		return cashMemberRepository.save(_member);
	}

	@Transactional
	public Wallet createWallet(CashMember holder) {
		Wallet wallet = new Wallet(holder);

		return walletRepository.save(wallet);
	}

	@Transactional(readOnly = true)
	public Optional<CashMember> findMemberByUserName(String userName) {
		return cashMemberRepository.findByUserName(userName);
	}

	@Transactional(readOnly = true)
	public Optional<Wallet> findWalletByHolder(CashMember holder) {
		return walletRepository.findByHolder(holder);
	}

}
