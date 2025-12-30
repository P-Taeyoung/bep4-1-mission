package com.back.boundedContext.payout.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.back.shared.market.dto.OrderDto;
import com.back.shared.member.dto.MemberDto;
import com.back.shared.payout.dto.PayoutMemberDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PayoutFacade {
	private final PayoutSyncMemberUseCase payoutSyncMemberUseCase;
	private final PayoutAddPayoutCandidateItemUseCase payoutAddPayoutCandidateItemUseCase;
	private final PayoutCreatePayoutUseCase payoutCreatePayoutUseCase;

	@Transactional
	public void syncMember(MemberDto memberDto) {
		payoutSyncMemberUseCase.syncMember(memberDto);
	}

	@Transactional
	public void createPayout(PayoutMemberDto payee) {
		payoutCreatePayoutUseCase.createPayout(payee);
	}

	@Transactional
	public void addPayoutCandidateItem(OrderDto orderDto) {
		payoutAddPayoutCandidateItemUseCase.addPayoutCandidateItems(orderDto);
	}

}
