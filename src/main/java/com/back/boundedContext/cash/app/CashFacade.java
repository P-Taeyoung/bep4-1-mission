package com.back.boundedContext.cash.app;

import org.springframework.stereotype.Service;

import com.back.boundedContext.cash.domain.CashMember;
import com.back.boundedContext.cash.out.CashMemberRepository;
import com.back.shared.member.dto.MemberDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CashFacade {
	private final CashMemberRepository cashMemberRepository;

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

}
