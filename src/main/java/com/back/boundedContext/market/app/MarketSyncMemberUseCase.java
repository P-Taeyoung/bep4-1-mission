package com.back.boundedContext.market.app;

import org.springframework.stereotype.Service;

import com.back.boundedContext.market.domain.MarketMember;
import com.back.boundedContext.market.out.MarketMemberRepository;
import com.back.shared.member.dto.MemberDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MarketSyncMemberUseCase {
	private final MarketMemberRepository marketMemberRepository;

	public MarketMember syncMember(MemberDto memberDto) {
		MarketMember marketMember = new MarketMember(
			memberDto.getId(),
			memberDto.getCreateTime(),
			memberDto.getModifyTime(),
			memberDto.getUserName(),
			"",
			memberDto.getNickName(),
			memberDto.getActivityScore()
		);

		return marketMemberRepository.save(marketMember);
	}
}
