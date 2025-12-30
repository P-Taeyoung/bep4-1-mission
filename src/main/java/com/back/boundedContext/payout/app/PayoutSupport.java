package com.back.boundedContext.payout.app;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.back.boundedContext.payout.domain.PayoutMember;
import com.back.boundedContext.payout.out.PayoutMemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PayoutSupport {
	private final PayoutMemberRepository payoutMemberRepository;

	public Optional<PayoutMember> findHoldingMember() {
		return payoutMemberRepository.findByUserName("holding");
	}

	public Optional<PayoutMember> findMemberById(int id) {
		return payoutMemberRepository.findById(id);
	}
}
