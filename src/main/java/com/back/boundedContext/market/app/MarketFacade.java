package com.back.boundedContext.market.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.back.boundedContext.market.domain.MarketMember;
import com.back.shared.member.dto.MemberDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MarketFacade {
	private final MarketSyncMemberUseCase marketSyncMemberUseCase;

	@Transactional
	public MarketMember syncMember(MemberDto memberDto) {
		return marketSyncMemberUseCase.syncMember(memberDto);
	}

}
