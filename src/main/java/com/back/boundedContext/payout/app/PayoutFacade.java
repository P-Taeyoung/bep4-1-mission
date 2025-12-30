package com.back.boundedContext.payout.app;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.back.boundedContext.payout.domain.Payout;
import com.back.boundedContext.payout.domain.PayoutCandidateItem;
import com.back.global.RsData.RsData;
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
	private final PayoutCollectPayoutItemsMoreUseCase payoutCollectPayoutItemsMoreUseCase;
	private final PayoutSupport payoutSupport;

	@Transactional
	public void syncMember(MemberDto memberDto) {
		payoutSyncMemberUseCase.syncMember(memberDto);
	}

	@Transactional
	public Payout createPayout(PayoutMemberDto payee) {
		return payoutCreatePayoutUseCase.createPayout(payee);
	}

	@Transactional
	public void addPayoutCandidateItem(OrderDto orderDto) {
		payoutAddPayoutCandidateItemUseCase.addPayoutCandidateItems(orderDto);
	}

	@Transactional
	public RsData<Integer> collectPayoutItemsMore(int limit) {
		return payoutCollectPayoutItemsMoreUseCase.collectPayoutItemsMore(limit);
	}

	@Transactional(readOnly = true)
	public List<PayoutCandidateItem> findPayoutCandidateItems() {
		return payoutSupport
			.findPayoutCandidateItems();
	}

}
