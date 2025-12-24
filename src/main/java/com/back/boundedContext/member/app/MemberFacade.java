package com.back.boundedContext.member.app;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.back.boundedContext.member.domain.Member;
import com.back.boundedContext.member.out.MemberRepository;
import com.back.global.RsData.RsData;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberFacade {

	private final MemberJoinUseCase memberJoinUseCase;
	private final MemberRepository memberRepository;

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
}
