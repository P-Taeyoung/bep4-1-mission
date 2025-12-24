package com.back.boundedContext.member.app;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.back.boundedContext.member.domain.Member;
import com.back.boundedContext.member.domain.MemberPolicy;
import com.back.boundedContext.member.out.MemberRepository;
import com.back.global.RsData.RsData;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberFacade {

	private final MemberJoinUseCase memberJoinUseCase;
	private final MemberRepository memberRepository;
	private final MemberPolicy memberPolicy;

	@Transactional(readOnly = true)
	public long count() {

		return memberRepository.count();
	}

	@Transactional
	public RsData<Member> join(String userName, String password, String nickName) {

		return memberJoinUseCase.join(userName, password, nickName);
	}

	@Transactional(readOnly = true)
	public Optional<Member> findByUserName(String userName) {

		return memberRepository.findByUserName(userName);
	}

	@Transactional(readOnly = true)
	public Optional<Member> findById(int id) {
		return memberRepository.findById(id);
	}

	public String getRandomSecureTip() {
		return "비밀번호의 유효기간은 %d 일 입니다."
			.formatted(memberPolicy.getNeedToChangePasswordDays());
	}
}
