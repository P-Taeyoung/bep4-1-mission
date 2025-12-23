package com.back.service;

import org.springframework.stereotype.Service;

import com.back.entity.Member;
import com.back.exception.DomainException;
import com.back.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

	public long count() {
		return memberRepository.count();
	}

	public Member join(String userName, String password, String nickName) {
		memberRepository.findByUserName(userName).ifPresent(member -> {
			throw new DomainException("409-1", "이미 존재하는 username 입니다.");
		});

		return memberRepository.save(new Member(userName, password, nickName));
	}
}
